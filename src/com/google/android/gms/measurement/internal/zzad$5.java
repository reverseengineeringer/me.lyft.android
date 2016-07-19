package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

class zzad$5
  implements Runnable
{
  zzad$5(zzad paramzzad, UserAttributeParcel paramUserAttributeParcel) {}
  
  public void run()
  {
    zzm localzzm = zzad.zzc(ans);
    if (localzzm == null)
    {
      ans.zzbsz().zzbtr().log("Discarding data. Failed to set user attribute");
      return;
    }
    try
    {
      localzzm.zza(amV, ans.zzbsr().zzlw(ans.zzbsz().zzbtz()));
      zzad.zzd(ans);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ans.zzbsz().zzbtr().zzj("Failed to send attribute to AppMeasurementService", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzad.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */