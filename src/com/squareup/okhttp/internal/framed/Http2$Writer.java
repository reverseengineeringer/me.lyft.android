package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

final class Http2$Writer
  implements FrameWriter
{
  private final boolean client;
  private boolean closed;
  private final Buffer hpackBuffer;
  private final Hpack.Writer hpackWriter;
  private int maxFrameSize;
  private final BufferedSink sink;
  
  Http2$Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    sink = paramBufferedSink;
    client = paramBoolean;
    hpackBuffer = new Buffer();
    hpackWriter = new Hpack.Writer(hpackBuffer);
    maxFrameSize = 16384;
  }
  
  private void writeContinuationFrames(int paramInt, long paramLong)
    throws IOException
  {
    if (paramLong > 0L)
    {
      int i = (int)Math.min(maxFrameSize, paramLong);
      paramLong -= i;
      if (paramLong == 0L) {}
      for (byte b = 4;; b = 0)
      {
        frameHeader(paramInt, i, (byte)9, b);
        sink.write(hpackBuffer, i);
        break;
      }
    }
  }
  
  public void ackSettings(Settings paramSettings)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    maxFrameSize = paramSettings.getMaxFrameSize(maxFrameSize);
    frameHeader(0, 0, (byte)4, (byte)1);
    sink.flush();
  }
  
  public void close()
    throws IOException
  {
    try
    {
      closed = true;
      sink.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void connectionPreface()
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    boolean bool = client;
    if (!bool) {}
    for (;;)
    {
      return;
      if (Http2.access$100().isLoggable(Level.FINE)) {
        Http2.access$100().fine(String.format(">> CONNECTION %s", new Object[] { Http2.access$000().hex() }));
      }
      sink.write(Http2.access$000().toByteArray());
      sink.flush();
    }
  }
  
  public void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    byte b = 0;
    if (paramBoolean) {
      b = (byte)1;
    }
    dataFrame(paramInt1, b, paramBuffer, paramInt2);
  }
  
  void dataFrame(int paramInt1, byte paramByte, Buffer paramBuffer, int paramInt2)
    throws IOException
  {
    frameHeader(paramInt1, paramInt2, (byte)0, paramByte);
    if (paramInt2 > 0) {
      sink.write(paramBuffer, paramInt2);
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    sink.flush();
  }
  
  void frameHeader(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    throws IOException
  {
    if (Http2.access$100().isLoggable(Level.FINE)) {
      Http2.access$100().fine(Http2.FrameLogger.formatHeader(false, paramInt1, paramInt2, paramByte1, paramByte2));
    }
    if (paramInt2 > maxFrameSize) {
      throw Http2.access$500("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(maxFrameSize), Integer.valueOf(paramInt2) });
    }
    if ((0x80000000 & paramInt1) != 0) {
      throw Http2.access$500("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    Http2.access$600(sink, paramInt2);
    sink.writeByte(paramByte1 & 0xFF);
    sink.writeByte(paramByte2 & 0xFF);
    sink.writeInt(0x7FFFFFFF & paramInt1);
  }
  
  public void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (httpCode == -1) {
      throw Http2.access$500("errorCode.httpCode == -1", new Object[0]);
    }
    frameHeader(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
    sink.writeInt(paramInt);
    sink.writeInt(httpCode);
    if (paramArrayOfByte.length > 0) {
      sink.write(paramArrayOfByte);
    }
    sink.flush();
  }
  
  public void headers(int paramInt, List<Header> paramList)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    headers(false, paramInt, paramList);
  }
  
  void headers(boolean paramBoolean, int paramInt, List<Header> paramList)
    throws IOException
  {
    if (closed) {
      throw new IOException("closed");
    }
    hpackWriter.writeHeaders(paramList);
    long l = hpackBuffer.size();
    int i = (int)Math.min(maxFrameSize, l);
    if (l == i) {}
    for (byte b1 = 4;; b1 = 0)
    {
      byte b2 = b1;
      if (paramBoolean) {
        b2 = (byte)(b1 | 0x1);
      }
      frameHeader(paramInt, i, (byte)1, b2);
      sink.write(hpackBuffer, i);
      if (l > i) {
        writeContinuationFrames(paramInt, l - i);
      }
      return;
    }
  }
  
  public int maxDataLength()
  {
    return maxFrameSize;
  }
  
  public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramBoolean) {}
    for (byte b = 1;; b = 0)
    {
      frameHeader(0, 8, (byte)6, b);
      sink.writeInt(paramInt1);
      sink.writeInt(paramInt2);
      sink.flush();
      return;
    }
  }
  
  public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    hpackWriter.writeHeaders(paramList);
    long l = hpackBuffer.size();
    int i = (int)Math.min(maxFrameSize - 4, l);
    if (l == i) {}
    for (byte b = 4;; b = 0)
    {
      frameHeader(paramInt1, i + 4, (byte)5, b);
      sink.writeInt(0x7FFFFFFF & paramInt2);
      sink.write(hpackBuffer, i);
      if (l > i) {
        writeContinuationFrames(paramInt1, l - i);
      }
      return;
    }
  }
  
  public void rstStream(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (httpCode == -1) {
      throw new IllegalArgumentException();
    }
    frameHeader(paramInt, 4, (byte)3, (byte)0);
    sink.writeInt(httpCode);
    sink.flush();
  }
  
  public void settings(Settings paramSettings)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    frameHeader(0, paramSettings.size() * 6, (byte)4, (byte)0);
    int i = 0;
    if (i < 10) {
      if (paramSettings.isSet(i)) {
        break label105;
      }
    }
    for (;;)
    {
      int j;
      sink.writeShort(j);
      sink.writeInt(paramSettings.get(i));
      break label98;
      sink.flush();
      return;
      label98:
      i += 1;
      break;
      label105:
      int k = i;
      if (k == 4)
      {
        j = 3;
      }
      else
      {
        j = k;
        if (k == 7) {
          j = 4;
        }
      }
    }
  }
  
  public void synReply(boolean paramBoolean, int paramInt, List<Header> paramList)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    headers(paramBoolean, paramInt, paramList);
  }
  
  public void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException
  {
    if (paramBoolean2) {
      try
      {
        throw new UnsupportedOperationException();
      }
      finally {}
    }
    if (closed) {
      throw new IOException("closed");
    }
    headers(paramBoolean1, paramInt1, paramList);
  }
  
  public void windowUpdate(int paramInt, long paramLong)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    if ((paramLong == 0L) || (paramLong > 2147483647L)) {
      throw Http2.access$500("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
    }
    frameHeader(paramInt, 4, (byte)8, (byte)0);
    sink.writeInt((int)paramLong);
    sink.flush();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.Http2.Writer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */