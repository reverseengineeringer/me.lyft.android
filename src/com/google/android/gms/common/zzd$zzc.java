package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzd$zzc
  extends zzd.zza
{
  private static final WeakReference<byte[]> rd = new WeakReference(null);
  private WeakReference<byte[]> rc = rd;
  
  zzd$zzc(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])rc.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = zzanj();
        rc = new WeakReference(arrayOfByte1);
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  protected abstract byte[] zzanj();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzd.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */