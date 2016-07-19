package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public abstract interface zzb
{
  public abstract void initialize();
  
  public abstract zza zza(String paramString);
  
  public abstract void zza(String paramString, zza paramzza);
  
  public static class zza
  {
    public byte[] data;
    public String zza;
    public long zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public Map<String, String> zzf = Collections.emptyMap();
    
    public boolean zza()
    {
      return zzd < System.currentTimeMillis();
    }
    
    public boolean zzb()
    {
      return zze < System.currentTimeMillis();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */