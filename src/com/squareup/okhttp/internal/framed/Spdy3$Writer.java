package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;

final class Spdy3$Writer
  implements FrameWriter
{
  private final boolean client;
  private boolean closed;
  private final Buffer headerBlockBuffer;
  private final BufferedSink headerBlockOut;
  private final BufferedSink sink;
  
  Spdy3$Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    sink = paramBufferedSink;
    client = paramBoolean;
    paramBufferedSink = new Deflater();
    paramBufferedSink.setDictionary(Spdy3.DICTIONARY);
    headerBlockBuffer = new Buffer();
    headerBlockOut = Okio.buffer(new DeflaterSink(headerBlockBuffer, paramBufferedSink));
  }
  
  private void writeNameValueBlockToBuffer(List<Header> paramList)
    throws IOException
  {
    headerBlockOut.writeInt(paramList.size());
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      ByteString localByteString = getname;
      headerBlockOut.writeInt(localByteString.size());
      headerBlockOut.write(localByteString);
      localByteString = getvalue;
      headerBlockOut.writeInt(localByteString.size());
      headerBlockOut.write(localByteString);
      i += 1;
    }
    headerBlockOut.flush();
  }
  
  public void ackSettings(Settings paramSettings) {}
  
  public void close()
    throws IOException
  {
    try
    {
      closed = true;
      Util.closeAll(sink, headerBlockOut);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void connectionPreface() {}
  
  public void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      try
      {
        sendDataFrame(paramInt1, i, paramBuffer, paramInt2);
        return;
      }
      finally {}
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
    if (spdyGoAwayCode == -1) {
      throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
    }
    sink.writeInt(-2147287033);
    sink.writeInt(8);
    sink.writeInt(paramInt);
    sink.writeInt(spdyGoAwayCode);
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
    writeNameValueBlockToBuffer(paramList);
    int i = (int)(headerBlockBuffer.size() + 4L);
    sink.writeInt(-2147287032);
    sink.writeInt(0xFFFFFF & i | 0x0);
    sink.writeInt(0x7FFFFFFF & paramInt);
    sink.writeAll(headerBlockBuffer);
  }
  
  public int maxDataLength()
  {
    return 16383;
  }
  
  public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool2 = true;
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    boolean bool3 = client;
    boolean bool1;
    if ((paramInt1 & 0x1) == 1) {
      bool1 = true;
    }
    for (;;)
    {
      if (paramBoolean != bool1) {
        throw new IllegalArgumentException("payload != reply");
      }
      sink.writeInt(-2147287034);
      sink.writeInt(4);
      sink.writeInt(paramInt1);
      sink.flush();
      return;
      for (;;)
      {
        if (bool3 == bool1) {
          break label130;
        }
        bool1 = bool2;
        break;
        bool1 = false;
      }
      label130:
      bool1 = false;
    }
  }
  
  public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException
  {}
  
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
    if (spdyRstCode == -1) {
      throw new IllegalArgumentException();
    }
    sink.writeInt(-2147287037);
    sink.writeInt(8);
    sink.writeInt(0x7FFFFFFF & paramInt);
    sink.writeInt(spdyRstCode);
    sink.flush();
  }
  
  void sendDataFrame(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3)
    throws IOException
  {
    if (closed) {
      throw new IOException("closed");
    }
    if (paramInt3 > 16777215L) {
      throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + paramInt3);
    }
    sink.writeInt(0x7FFFFFFF & paramInt1);
    sink.writeInt((paramInt2 & 0xFF) << 24 | 0xFFFFFF & paramInt3);
    if (paramInt3 > 0) {
      sink.write(paramBuffer, paramInt3);
    }
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
    int i = paramSettings.size();
    sink.writeInt(-2147287036);
    sink.writeInt(i * 8 + 4 & 0xFFFFFF | 0x0);
    sink.writeInt(i);
    i = 0;
    for (;;)
    {
      if (i <= 10)
      {
        if (paramSettings.isSet(i))
        {
          int j = paramSettings.flags(i);
          sink.writeInt((j & 0xFF) << 24 | i & 0xFFFFFF);
          sink.writeInt(paramSettings.get(i));
        }
      }
      else
      {
        sink.flush();
        return;
      }
      i += 1;
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
    writeNameValueBlockToBuffer(paramList);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      int j = (int)(headerBlockBuffer.size() + 4L);
      sink.writeInt(-2147287038);
      sink.writeInt((i & 0xFF) << 24 | 0xFFFFFF & j);
      sink.writeInt(0x7FFFFFFF & paramInt);
      sink.writeAll(headerBlockBuffer);
      sink.flush();
      return;
    }
  }
  
  public void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException
  {
    try
    {
      if (closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    writeNameValueBlockToBuffer(paramList);
    int k = (int)(10L + headerBlockBuffer.size());
    int i;
    if (paramBoolean1) {
      i = 1;
    }
    for (;;)
    {
      sink.writeInt(-2147287039);
      sink.writeInt(((i | j) & 0xFF) << 24 | 0xFFFFFF & k);
      sink.writeInt(0x7FFFFFFF & paramInt1);
      sink.writeInt(0x7FFFFFFF & paramInt2);
      sink.writeShort(0);
      sink.writeAll(headerBlockBuffer);
      sink.flush();
      return;
      i = 0;
      while (!paramBoolean2)
      {
        j = 0;
        break;
      }
      int j = 2;
    }
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
      throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + paramLong);
    }
    sink.writeInt(-2147287031);
    sink.writeInt(8);
    sink.writeInt(paramInt);
    sink.writeInt((int)paramLong);
    sink.flush();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.Spdy3.Writer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */