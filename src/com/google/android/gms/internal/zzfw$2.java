package com.google.android.gms.internal;

class zzfw$2
  implements zzle.zzc<zzft>
{
  zzfw$2(zzfw paramzzfw, zzfw.zzd paramzzd) {}
  
  public void zza(zzft arg1)
  {
    synchronized (zzfw.zzc(zzbmc))
    {
      zzfw.zza(zzbmc, 0);
      if ((zzfw.zzg(zzbmc) != null) && (zzbmj != zzfw.zzg(zzbmc)))
      {
        zzkh.v("New JS engine is loaded, marking previous one as destroyable.");
        zzfw.zzg(zzbmc).zzmf();
      }
      zzfw.zza(zzbmc, zzbmj);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */