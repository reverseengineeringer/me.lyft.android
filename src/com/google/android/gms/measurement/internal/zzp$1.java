package com.google.android.gms.measurement.internal;

class zzp$1
  implements Runnable
{
  zzp$1(zzp paramzzp, String paramString) {}
  
  public void run()
  {
    zzt localzzt = akX.aja.zzbta();
    if ((!localzzt.isInitialized()) || (localzzt.zzbvh()))
    {
      akX.zzo(6, "Persisted config not initialized . Not logging error/warn.");
      return;
    }
    alu.zzew(akW);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzp.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */