package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

class zzad$4
  implements Runnable
{
  zzad$4(zzad paramzzad, String paramString, EventParcel paramEventParcel) {}
  
  public void run()
  {
    zzm localzzm = zzad.zzc(ans);
    if (localzzm == null)
    {
      ans.zzbsz().zzbtr().log("Discarding data. Failed to send event to service");
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(aee))
        {
          localzzm.zza(amT, ans.zzbsr().zzlw(ans.zzbsz().zzbtz()));
          zzad.zzd(ans);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        ans.zzbsz().zzbtr().zzj("Failed to send event to AppMeasurementService", localRemoteException);
        return;
      }
      localRemoteException.zza(amT, aee, ans.zzbsz().zzbtz());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzad.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */