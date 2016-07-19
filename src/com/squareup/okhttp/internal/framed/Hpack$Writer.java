package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.ByteString;

final class Hpack$Writer
{
  private final Buffer out;
  
  Hpack$Writer(Buffer paramBuffer)
  {
    out = paramBuffer;
  }
  
  void writeByteString(ByteString paramByteString)
    throws IOException
  {
    writeInt(paramByteString.size(), 127, 0);
    out.write(paramByteString);
  }
  
  void writeHeaders(List<Header> paramList)
    throws IOException
  {
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      ByteString localByteString = getname.toAsciiLowercase();
      Integer localInteger = (Integer)Hpack.access$200().get(localByteString);
      if (localInteger != null)
      {
        writeInt(localInteger.intValue() + 1, 15, 0);
        writeByteString(getvalue);
      }
      for (;;)
      {
        i += 1;
        break;
        out.writeByte(0);
        writeByteString(localByteString);
        writeByteString(getvalue);
      }
    }
  }
  
  void writeInt(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt1 < paramInt2)
    {
      out.writeByte(paramInt3 | paramInt1);
      return;
    }
    out.writeByte(paramInt3 | paramInt2);
    paramInt1 -= paramInt2;
    while (paramInt1 >= 128)
    {
      out.writeByte(paramInt1 & 0x7F | 0x80);
      paramInt1 >>>= 7;
    }
    out.writeByte(paramInt1);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.Hpack.Writer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */