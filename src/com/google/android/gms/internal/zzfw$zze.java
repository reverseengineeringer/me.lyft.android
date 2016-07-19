package com.google.android.gms.internal;

public class zzfw$zze
  extends zzlf<zzfx>
{
  private zzfw.zzc zzbmv;
  
  public zzfw$zze(zzfw.zzc paramzzc)
  {
    zzbmv = paramzzc;
  }
  
  public void finalize()
  {
    zzbmv.release();
    zzbmv = null;
  }
  
  public int getStatus()
  {
    return zzbmv.getStatus();
  }
  
  public void reject()
  {
    zzbmv.reject();
  }
  
  public void zza(zzle.zzc<zzfx> paramzzc, zzle.zza paramzza)
  {
    zzbmv.zza(paramzzc, paramzza);
  }
  
  public void zzf(zzfx paramzzfx)
  {
    zzbmv.zzg(paramzzfx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */