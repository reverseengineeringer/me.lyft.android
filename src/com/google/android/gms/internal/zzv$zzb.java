package com.google.android.gms.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class zzv$zzb
  extends FilterInputStream
{
  private int zzcc = 0;
  
  private zzv$zzb(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read()
    throws IOException
  {
    int i = super.read();
    if (i != -1) {
      zzcc += 1;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      zzcc += paramInt1;
    }
    return paramInt1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzv.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */