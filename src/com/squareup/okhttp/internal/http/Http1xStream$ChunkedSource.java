package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

class Http1xStream$ChunkedSource
  extends Http1xStream.AbstractSource
{
  private static final long NO_CHUNK_YET = -1L;
  private long bytesRemainingInChunk = -1L;
  private boolean hasMoreChunks = true;
  private final HttpEngine httpEngine;
  
  Http1xStream$ChunkedSource(Http1xStream paramHttp1xStream, HttpEngine paramHttpEngine)
    throws IOException
  {
    super(paramHttp1xStream, null);
    httpEngine = paramHttpEngine;
  }
  
  private void readChunkSize()
    throws IOException
  {
    if (bytesRemainingInChunk != -1L) {
      Http1xStream.access$600(this$0).readUtf8LineStrict();
    }
    try
    {
      bytesRemainingInChunk = Http1xStream.access$600(this$0).readHexadecimalUnsignedLong();
      String str = Http1xStream.access$600(this$0).readUtf8LineStrict().trim();
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
      httpEngine.receiveHeaders(this$0.readHeaders());
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
    paramLong = Http1xStream.access$600(this$0).read(paramBuffer, Math.min(paramLong, bytesRemainingInChunk));
    if (paramLong == -1L)
    {
      unexpectedEndOfInput();
      throw new ProtocolException("unexpected end of stream");
    }
    bytesRemainingInChunk -= paramLong;
    return paramLong;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.ChunkedSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */