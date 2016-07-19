package com.google.android.gms.ads.internal.request;

class zzb$1
  implements Runnable
{
  zzb$1(zzb paramzzb) {}
  
  public void run()
  {
    synchronized (zzb.zza(zzcal))
    {
      if (zzcal.zzcak == null) {
        return;
      }
      zzcal.onStop();
      zzb.zza(zzcal, 2, "Timed out waiting for ad response.");
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzb.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */