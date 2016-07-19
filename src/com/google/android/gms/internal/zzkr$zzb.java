package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class zzkr$zzb<T>
  extends zzk<InputStream>
{
  private final zzm.zzb<T> zzcg;
  private final zzkr.zza<T> zzcmn;
  
  public zzkr$zzb(String paramString, final zzkr.zza<T> paramzza, zzm.zzb<T> paramzzb)
  {
    super(0, paramString, new zzm.zza()
    {
      public void zze(zzr paramAnonymouszzr)
      {
        zzb(paramzza.zzqv());
      }
    });
    zzcmn = paramzza;
    zzcg = paramzzb;
  }
  
  protected zzm<InputStream> zza(zzi paramzzi)
  {
    return zzm.zza(new ByteArrayInputStream(data), zzx.zzb(paramzzi));
  }
  
  protected void zzj(InputStream paramInputStream)
  {
    zzcg.zzb(zzcmn.zzh(paramInputStream));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkr.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */