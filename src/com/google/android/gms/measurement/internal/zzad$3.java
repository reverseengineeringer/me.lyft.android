package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

class zzad$3
  implements Runnable
{
  zzad$3(zzad paramzzad) {}
  
  public void run()
  {
    zzm localzzm = zzad.zzc(ans);
    if (localzzm == null)
    {
      ans.zzbsz().zzbtr().log("Failed to send measurementEnabled to service");
      return;
    }
    try
    {
      localzzm.zzb(ans.zzbsr().zzlw(ans.zzbsz().zzbtz()));
      zzad.zzd(ans);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ans.zzbsz().zzbtr().zzj("Failed to send measurementEnabled to AppMeasurementService", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzad.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */