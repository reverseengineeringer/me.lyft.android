package com.google.android.gms.measurement.internal;

class zzad$zza$3
  implements Runnable
{
  zzad$zza$3(zzad.zza paramzza, zzm paramzzm) {}
  
  public void run()
  {
    synchronized (anx)
    {
      zzad.zza.zza(anx, false);
      if (!anx.ans.isConnected())
      {
        anx.ans.zzbsz().zzbtx().log("Connected to remote service");
        zzad.zza(anx.ans, any);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzad.zza.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */