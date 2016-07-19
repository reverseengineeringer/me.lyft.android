package com.leanplum;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

final class q
  extends DataInputStream
{
  public q(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {}
      int j;
      do
      {
        if (i == paramInt) {
          break;
        }
        throw new IOException(String.format("Read wrong number of bytes. Got: %s, Expected: %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
        j = read(arrayOfByte, i, paramInt - i);
      } while (j == -1);
      i += j;
    }
    return arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */