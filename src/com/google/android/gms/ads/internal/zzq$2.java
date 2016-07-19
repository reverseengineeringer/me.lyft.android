package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzkh;

class zzq$2
  implements Runnable
{
  zzq$2(zzq paramzzq, zzd paramzzd) {}
  
  public void run()
  {
    try
    {
      if (zzamv.zzajs.zzapi != null) {
        zzamv.zzajs.zzapi.zza(zzamw);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzq.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */