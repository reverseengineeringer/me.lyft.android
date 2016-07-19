package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class zzcq$zza
{
  ByteArrayOutputStream zzatd = new ByteArrayOutputStream(4096);
  Base64OutputStream zzate = new Base64OutputStream(zzatd, 10);
  
  public String toString()
  {
    try
    {
      zzate.close();
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          zzatd.close();
          String str = zzatd.toString();
          return str;
        }
        catch (IOException localIOException2)
        {
          zzkh.zzb("HashManager: Unable to convert to Base64.", localIOException2);
          return "";
        }
        finally
        {
          zzatd = null;
          zzate = null;
        }
        localIOException1 = localIOException1;
        zzkh.zzb("HashManager: Unable to convert to Base64.", localIOException1);
      }
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    zzate.write(paramArrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcq.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */