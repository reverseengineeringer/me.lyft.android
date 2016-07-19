package com.google.android.gms.internal;

class zzgh$1
  implements Runnable
{
  zzgh$1(zzgh paramzzgh, zzgg paramzzgg) {}
  
  public void run()
  {
    synchronized (zzgh.zza(zzboo))
    {
      if (zzgh.zzb(zzboo) != -2) {
        return;
      }
      zzgh.zza(zzboo, zzgh.zzc(zzboo));
      if (zzgh.zzd(zzboo) == null)
      {
        zzboo.zzy(4);
        return;
      }
    }
    if ((zzgh.zze(zzboo)) && (!zzgh.zza(zzboo, 1)))
    {
      String str = zzgh.zzf(zzboo);
      zzkh.zzcy(String.valueOf(str).length() + 56 + "Ignoring adapter " + str + " as delayed impression is not supported");
      zzboo.zzy(2);
      return;
    }
    zzbon.zza(zzboo);
    zzgh.zza(zzboo, zzbon);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgh.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */