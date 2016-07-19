package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

final class Http2$ContinuationSource
  implements Source
{
  byte flags;
  int left;
  int length;
  short padding;
  private final BufferedSource source;
  int streamId;
  
  public Http2$ContinuationSource(BufferedSource paramBufferedSource)
  {
    source = paramBufferedSource;
  }
  
  private void readContinuationHeader()
    throws IOException
  {
    int i = streamId;
    int j = Http2.access$300(source);
    left = j;
    length = j;
    byte b = (byte)(source.readByte() & 0xFF);
    flags = ((byte)(source.readByte() & 0xFF));
    if (Http2.access$100().isLoggable(Level.FINE)) {
      Http2.access$100().fine(Http2.FrameLogger.formatHeader(true, streamId, length, b, flags));
    }
    streamId = (source.readInt() & 0x7FFFFFFF);
    if (b != 9) {
      throw Http2.access$200("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
    }
    if (streamId != i) {
      throw Http2.access$200("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
  }
  
  public void close()
    throws IOException
  {}
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    while (left == 0)
    {
      source.skip(padding);
      padding = 0;
      if ((flags & 0x4) != 0) {
        return -1L;
      }
      readContinuationHeader();
    }
    paramLong = source.read(paramBuffer, Math.min(paramLong, left));
    if (paramLong == -1L) {
      return -1L;
    }
    left = ((int)(left - paramLong));
    return paramLong;
  }
  
  public Timeout timeout()
  {
    return source.timeout();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.Http2.ContinuationSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */