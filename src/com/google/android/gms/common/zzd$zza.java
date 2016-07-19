package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.internal.zzs.zza;
import com.google.android.gms.common.util.zzm;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzd$zza
  extends zzs.zza
{
  private int ra;
  
  protected zzd$zza(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte.length != 25)
    {
      int i = paramArrayOfByte.length;
      localObject = String.valueOf(zzm.zza(paramArrayOfByte, 0, paramArrayOfByte.length, false));
      Log.wtf("GoogleCertificates", String.valueOf(localObject).length() + 51 + "Cert hash data has incorrect length (" + i + "):\n" + (String)localObject, new Exception());
      localObject = Arrays.copyOfRange(paramArrayOfByte, 0, 25);
      if (localObject.length == 25) {
        bool = true;
      }
      i = localObject.length;
      zzab.zzb(bool, 55 + "cert hash data has incorrect length. length=" + i);
    }
    ra = Arrays.hashCode((byte[])localObject);
  }
  
  protected static byte[] zzgw(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zzs))) {
      return false;
    }
    try
    {
      paramObject = (zzs)paramObject;
      if (((zzs)paramObject).zzani() != hashCode()) {
        return false;
      }
      paramObject = ((zzs)paramObject).zzanh();
      if (paramObject == null) {
        return false;
      }
      paramObject = (byte[])zze.zzad((zzd)paramObject);
      boolean bool = Arrays.equals(getBytes(), (byte[])paramObject);
      return bool;
    }
    catch (RemoteException paramObject)
    {
      Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
    }
    return false;
  }
  
  abstract byte[] getBytes();
  
  public int hashCode()
  {
    return ra;
  }
  
  public zzd zzanh()
  {
    return zze.zzae(getBytes());
  }
  
  public int zzani()
  {
    return hashCode();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */