package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1xStream
  implements HttpStream
{
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  private HttpEngine httpEngine;
  private final BufferedSink sink;
  private final BufferedSource source;
  private int state = 0;
  private final StreamAllocation streamAllocation;
  
  public Http1xStream(StreamAllocation paramStreamAllocation, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    streamAllocation = paramStreamAllocation;
    source = paramBufferedSource;
    sink = paramBufferedSink;
  }
  
  private void detachTimeout(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    localTimeout.clearDeadline();
    localTimeout.clearTimeout();
  }
  
  private Source getTransferStream(Response paramResponse)
    throws IOException
  {
    if (!HttpEngine.hasBody(paramResponse)) {
      return newFixedLengthSource(0L);
    }
    if ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))) {
      return newChunkedSource(httpEngine);
    }
    long l = OkHeaders.contentLength(paramResponse);
    if (l != -1L) {
      return newFixedLengthSource(l);
    }
    return newUnknownLengthSource();
  }
  
  public void cancel()
  {
    RealConnection localRealConnection = streamAllocation.connection();
    if (localRealConnection != null) {
      localRealConnection.cancel();
    }
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
    throws IOException
  {
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding"))) {
      return newChunkedSink();
    }
    if (paramLong != -1L) {
      return newFixedLengthSink(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public void finishRequest()
    throws IOException
  {
    sink.flush();
  }
  
  public boolean isClosed()
  {
    return state == 6;
  }
  
  public Sink newChunkedSink()
  {
    if (state != 1) {
      throw new IllegalStateException("state: " + state);
    }
    state = 2;
    return new ChunkedSink(null);
  }
  
  public Source newChunkedSource(HttpEngine paramHttpEngine)
    throws IOException
  {
    if (state != 4) {
      throw new IllegalStateException("state: " + state);
    }
    state = 5;
    return new ChunkedSource(paramHttpEngine);
  }
  
  public Sink newFixedLengthSink(long paramLong)
  {
    if (state != 1) {
      throw new IllegalStateException("state: " + state);
    }
    state = 2;
    return new FixedLengthSink(paramLong, null);
  }
  
  public Source newFixedLengthSource(long paramLong)
    throws IOException
  {
    if (state != 4) {
      throw new IllegalStateException("state: " + state);
    }
    state = 5;
    return new FixedLengthSource(paramLong);
  }
  
  public Source newUnknownLengthSource()
    throws IOException
  {
    if (state != 4) {
      throw new IllegalStateException("state: " + state);
    }
    if (streamAllocation == null) {
      throw new IllegalStateException("streamAllocation == null");
    }
    state = 5;
    streamAllocation.noNewStreams();
    return new UnknownLengthSource(null);
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    Source localSource = getTransferStream(paramResponse);
    return new RealResponseBody(paramResponse.headers(), Okio.buffer(localSource));
  }
  
  public Headers readHeaders()
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    for (;;)
    {
      String str = source.readUtf8LineStrict();
      if (str.length() == 0) {
        break;
      }
      Internal.instance.addLenient(localBuilder, str);
    }
    return localBuilder.build();
  }
  
  public Response.Builder readResponse()
    throws IOException
  {
    if ((state != 1) && (state != 3)) {
      throw new IllegalStateException("state: " + state);
    }
    try
    {
      StatusLine localStatusLine;
      do
      {
        localStatusLine = StatusLine.parse(source.readUtf8LineStrict());
        localObject = new Response.Builder().protocol(protocol).code(code).message(message).headers(readHeaders());
      } while (code == 100);
      state = 4;
      return (Response.Builder)localObject;
    }
    catch (EOFException localEOFException)
    {
      Object localObject = new IOException("unexpected end of stream on " + streamAllocation);
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
  }
  
  public Response.Builder readResponseHeaders()
    throws IOException
  {
    return readResponse();
  }
  
  public void setHttpEngine(HttpEngine paramHttpEngine)
  {
    httpEngine = paramHttpEngine;
  }
  
  public void writeRequest(Headers paramHeaders, String paramString)
    throws IOException
  {
    if (state != 0) {
      throw new IllegalStateException("state: " + state);
    }
    sink.writeUtf8(paramString).writeUtf8("\r\n");
    int i = 0;
    int j = paramHeaders.size();
    while (i < j)
    {
      sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
      i += 1;
    }
    sink.writeUtf8("\r\n");
    state = 1;
  }
  
  public void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException
  {
    if (state != 1) {
      throw new IllegalStateException("state: " + state);
    }
    state = 3;
    paramRetryableSink.writeToSocket(sink);
  }
  
  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    httpEngine.writingRequestHeaders();
    String str = RequestLine.get(paramRequest, httpEngine.getConnection().getRoute().getProxy().type());
    writeRequest(paramRequest.headers(), str);
  }
  
  private abstract class AbstractSource
    implements Source
  {
    protected boolean closed;
    protected final ForwardingTimeout timeout = new ForwardingTimeout(source.timeout());
    
    private AbstractSource() {}
    
    protected final void endOfInput()
      throws IOException
    {
      if (state != 5) {
        throw new IllegalStateException("state: " + state);
      }
      Http1xStream.this.detachTimeout(timeout);
      Http1xStream.access$502(Http1xStream.this, 6);
      if (streamAllocation != null) {
        streamAllocation.streamFinished(Http1xStream.this);
      }
    }
    
    public Timeout timeout()
    {
      return timeout;
    }
    
    protected final void unexpectedEndOfInput()
    {
      if (state == 6) {}
      do
      {
        return;
        Http1xStream.access$502(Http1xStream.this, 6);
      } while (streamAllocation == null);
      streamAllocation.noNewStreams();
      streamAllocation.streamFinished(Http1xStream.this);
    }
  }
  
  private final class ChunkedSink
    implements Sink
  {
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(sink.timeout());
    
    private ChunkedSink() {}
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 47	com/squareup/okhttp/internal/http/Http1xStream$ChunkedSink:closed	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 47	com/squareup/okhttp/internal/http/Http1xStream$ChunkedSink:closed	Z
      //   19: aload_0
      //   20: getfield 19	com/squareup/okhttp/internal/http/Http1xStream$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/Http1xStream;
      //   23: invokestatic 28	com/squareup/okhttp/internal/http/Http1xStream:access$300	(Lcom/squareup/okhttp/internal/http/Http1xStream;)Lokio/BufferedSink;
      //   26: ldc 49
      //   28: invokeinterface 53 2 0
      //   33: pop
      //   34: aload_0
      //   35: getfield 19	com/squareup/okhttp/internal/http/Http1xStream$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/Http1xStream;
      //   38: aload_0
      //   39: getfield 38	com/squareup/okhttp/internal/http/Http1xStream$ChunkedSink:timeout	Lokio/ForwardingTimeout;
      //   42: invokestatic 57	com/squareup/okhttp/internal/http/Http1xStream:access$400	(Lcom/squareup/okhttp/internal/http/Http1xStream;Lokio/ForwardingTimeout;)V
      //   45: aload_0
      //   46: getfield 19	com/squareup/okhttp/internal/http/Http1xStream$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/Http1xStream;
      //   49: iconst_3
      //   50: invokestatic 61	com/squareup/okhttp/internal/http/Http1xStream:access$502	(Lcom/squareup/okhttp/internal/http/Http1xStream;I)I
      //   53: pop
      //   54: goto -43 -> 11
      //   57: astore_2
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_2
      //   61: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	62	0	this	ChunkedSink
      //   6	2	1	bool	boolean
      //   57	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	57	finally
      //   14	54	57	finally
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 47	com/squareup/okhttp/internal/http/Http1xStream$ChunkedSink:closed	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 19	com/squareup/okhttp/internal/http/Http1xStream$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/Http1xStream;
      //   18: invokestatic 28	com/squareup/okhttp/internal/http/Http1xStream:access$300	(Lcom/squareup/okhttp/internal/http/Http1xStream;)Lokio/BufferedSink;
      //   21: invokeinterface 65 1 0
      //   26: goto -15 -> 11
      //   29: astore_2
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	ChunkedSink
      //   6	2	1	bool	boolean
      //   29	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
    
    public Timeout timeout()
    {
      return timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (closed) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      sink.writeHexadecimalUnsignedLong(paramLong);
      sink.writeUtf8("\r\n");
      sink.write(paramBuffer, paramLong);
      sink.writeUtf8("\r\n");
    }
  }
  
  private class ChunkedSource
    extends Http1xStream.AbstractSource
  {
    private static final long NO_CHUNK_YET = -1L;
    private long bytesRemainingInChunk = -1L;
    private boolean hasMoreChunks = true;
    private final HttpEngine httpEngine;
    
    ChunkedSource(HttpEngine paramHttpEngine)
      throws IOException
    {
      super(null);
      httpEngine = paramHttpEngine;
    }
    
    private void readChunkSize()
      throws IOException
    {
      if (bytesRemainingInChunk != -1L) {
        source.readUtf8LineStrict();
      }
      try
      {
        bytesRemainingInChunk = source.readHexadecimalUnsignedLong();
        String str = source.readUtf8LineStrict().trim();
        if ((bytesRemainingInChunk < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
          throw new ProtocolException("expected chunk size and optional extensions but was \"" + bytesRemainingInChunk + str + "\"");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
      if (bytesRemainingInChunk == 0L)
      {
        hasMoreChunks = false;
        httpEngine.receiveHeaders(readHeaders());
        endOfInput();
      }
    }
    
    public void close()
      throws IOException
    {
      if (closed) {
        return;
      }
      if ((hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
        unexpectedEndOfInput();
      }
      closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (closed) {
        throw new IllegalStateException("closed");
      }
      if (!hasMoreChunks) {
        return -1L;
      }
      if ((bytesRemainingInChunk == 0L) || (bytesRemainingInChunk == -1L))
      {
        readChunkSize();
        if (!hasMoreChunks) {
          return -1L;
        }
      }
      paramLong = source.read(paramBuffer, Math.min(paramLong, bytesRemainingInChunk));
      if (paramLong == -1L)
      {
        unexpectedEndOfInput();
        throw new ProtocolException("unexpected end of stream");
      }
      bytesRemainingInChunk -= paramLong;
      return paramLong;
    }
  }
  
  private final class FixedLengthSink
    implements Sink
  {
    private long bytesRemaining;
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(sink.timeout());
    
    private FixedLengthSink(long paramLong)
    {
      bytesRemaining = paramLong;
    }
    
    public void close()
      throws IOException
    {
      if (closed) {
        return;
      }
      closed = true;
      if (bytesRemaining > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      Http1xStream.this.detachTimeout(timeout);
      Http1xStream.access$502(Http1xStream.this, 3);
    }
    
    public void flush()
      throws IOException
    {
      if (closed) {
        return;
      }
      sink.flush();
    }
    
    public Timeout timeout()
    {
      return timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (closed) {
        throw new IllegalStateException("closed");
      }
      Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      if (paramLong > bytesRemaining) {
        throw new ProtocolException("expected " + bytesRemaining + " bytes but received " + paramLong);
      }
      sink.write(paramBuffer, paramLong);
      bytesRemaining -= paramLong;
    }
  }
  
  private class FixedLengthSource
    extends Http1xStream.AbstractSource
  {
    private long bytesRemaining;
    
    public FixedLengthSource(long paramLong)
      throws IOException
    {
      super(null);
      bytesRemaining = paramLong;
      if (bytesRemaining == 0L) {
        endOfInput();
      }
    }
    
    public void close()
      throws IOException
    {
      if (closed) {
        return;
      }
      if ((bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
        unexpectedEndOfInput();
      }
      closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (closed) {
        throw new IllegalStateException("closed");
      }
      if (bytesRemaining == 0L) {
        paramLong = -1L;
      }
      long l;
      do
      {
        return paramLong;
        l = source.read(paramBuffer, Math.min(bytesRemaining, paramLong));
        if (l == -1L)
        {
          unexpectedEndOfInput();
          throw new ProtocolException("unexpected end of stream");
        }
        bytesRemaining -= l;
        paramLong = l;
      } while (bytesRemaining != 0L);
      endOfInput();
      return l;
    }
  }
  
  private class UnknownLengthSource
    extends Http1xStream.AbstractSource
  {
    private boolean inputExhausted;
    
    private UnknownLengthSource()
    {
      super(null);
    }
    
    public void close()
      throws IOException
    {
      if (closed) {
        return;
      }
      if (!inputExhausted) {
        unexpectedEndOfInput();
      }
      closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (closed) {
        throw new IllegalStateException("closed");
      }
      if (inputExhausted) {
        paramLong = -1L;
      }
      long l;
      do
      {
        return paramLong;
        l = source.read(paramBuffer, paramLong);
        paramLong = l;
      } while (l != -1L);
      inputExhausted = true;
      endOfInput();
      return -1L;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */