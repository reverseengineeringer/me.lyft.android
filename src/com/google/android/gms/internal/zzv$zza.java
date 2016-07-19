package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

class zzv$zza
{
  public String zza;
  public long zzb;
  public long zzc;
  public long zzca;
  public String zzcb;
  public long zzd;
  public long zze;
  public Map<String, String> zzf;
  
  private zzv$zza() {}
  
  public zzv$zza(String paramString, zzb.zza paramzza)
  {
    zzcb = paramString;
    zzca = data.length;
    zza = zza;
    zzb = zzb;
    zzc = zzc;
    zzd = zzd;
    zze = zze;
    zzf = zzf;
  }
  
  public static zza zzf(InputStream paramInputStream)
    throws IOException
  {
    zza localzza = new zza();
    if (zzv.zzb(paramInputStream) != 538247942) {
      throw new IOException();
    }
    zzcb = zzv.zzd(paramInputStream);
    zza = zzv.zzd(paramInputStream);
    if (zza.equals("")) {
      zza = null;
    }
    zzb = zzv.zzc(paramInputStream);
    zzc = zzv.zzc(paramInputStream);
    zzd = zzv.zzc(paramInputStream);
    zze = zzv.zzc(paramInputStream);
    zzf = zzv.zze(paramInputStream);
    return localzza;
  }
  
  public boolean zza(OutputStream paramOutputStream)
  {
    try
    {
      zzv.zza(paramOutputStream, 538247942);
      zzv.zza(paramOutputStream, zzcb);
      if (zza == null) {}
      for (String str = "";; str = zza)
      {
        zzv.zza(paramOutputStream, str);
        zzv.zza(paramOutputStream, zzb);
        zzv.zza(paramOutputStream, zzc);
        zzv.zza(paramOutputStream, zzd);
        zzv.zza(paramOutputStream, zze);
        zzv.zza(zzf, paramOutputStream);
        paramOutputStream.flush();
        return true;
      }
      return false;
    }
    catch (IOException paramOutputStream)
    {
      zzs.zzb("%s", new Object[] { paramOutputStream.toString() });
    }
  }
  
  public zzb.zza zzb(byte[] paramArrayOfByte)
  {
    zzb.zza localzza = new zzb.zza();
    data = paramArrayOfByte;
    zza = zza;
    zzb = zzb;
    zzc = zzc;
    zzd = zzd;
    zze = zze;
    zzf = zzf;
    return localzza;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzv.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */