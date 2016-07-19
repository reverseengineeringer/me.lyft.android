package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class zzaa
  extends ByteArrayOutputStream
{
  private final zzu zzbq;
  
  public zzaa(zzu paramzzu, int paramInt)
  {
    zzbq = paramzzu;
    buf = zzbq.zzb(Math.max(paramInt, 256));
  }
  
  private void zzd(int paramInt)
  {
    if (count + paramInt <= buf.length) {
      return;
    }
    byte[] arrayOfByte = zzbq.zzb((count + paramInt) * 2);
    System.arraycopy(buf, 0, arrayOfByte, 0, count);
    zzbq.zza(buf);
    buf = arrayOfByte;
  }
  
  public void close()
    throws IOException
  {
    zzbq.zza(buf);
    buf = null;
    super.close();
  }
  
  public void finalize()
  {
    zzbq.zza(buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      zzd(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      zzd(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */