package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

class zzad$7
  implements Runnable
{
  zzad$7(zzad paramzzad) {}
  
  public void run()
  {
    zzm localzzm = zzad.zzc(ans);
    if (localzzm == null)
    {
      ans.zzbsz().zzbtr().log("Discarding data. Failed to send app launch");
      return;
    }
    try
    {
      localzzm.zza(ans.zzbsr().zzlw(ans.zzbsz().zzbtz()));
      zzad.zzd(ans);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ans.zzbsz().zzbtr().zzj("Failed to send app launch to AppMeasurementService", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzad.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */