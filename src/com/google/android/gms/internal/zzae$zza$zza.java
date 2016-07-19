package com.google.android.gms.internal;

import java.io.IOException;

public final class zzae$zza$zza
  extends zzaow<zza>
{
  private static volatile zza[] zzem;
  public Long zzdf = null;
  public Long zzdg = null;
  
  public zzae$zza$zza()
  {
    bik = -1;
  }
  
  public static zza[] zzz()
  {
    if (zzem == null) {}
    synchronized (zzapa.bij)
    {
      if (zzem == null) {
        zzem = new zza[0];
      }
      return zzem;
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (zzdf != null) {
      paramzzaov.zzb(1, zzdf.longValue());
    }
    if (zzdg != null) {
      paramzzaov.zzb(2, zzdg.longValue());
    }
    super.zza(paramzzaov);
  }
  
  public zza zzd(zzaou paramzzaou)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzaou.J();
      switch (i)
      {
      default: 
        if (super.zza(paramzzaou, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        zzdf = Long.valueOf(paramzzaou.M());
        break;
      case 16: 
        zzdg = Long.valueOf(paramzzaou.M());
      }
    }
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (zzdf != null) {
      i = j + zzaov.zze(1, zzdf.longValue());
    }
    j = i;
    if (zzdg != null) {
      j = i + zzaov.zze(2, zzdg.longValue());
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzae.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */