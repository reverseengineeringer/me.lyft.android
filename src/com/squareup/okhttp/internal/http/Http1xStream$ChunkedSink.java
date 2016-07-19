package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

final class Http1xStream$ChunkedSink
  implements Sink
{
  private boolean closed;
  private final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.access$300(this$0).timeout());
  
  private Http1xStream$ChunkedSink(Http1xStream paramHttp1xStream) {}
  
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
    Http1xStream.access$300(this$0).writeHexadecimalUnsignedLong(paramLong);
    Http1xStream.access$300(this$0).writeUtf8("\r\n");
    Http1xStream.access$300(this$0).write(paramBuffer, paramLong);
    Http1xStream.access$300(this$0).writeUtf8("\r\n");
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.ChunkedSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */