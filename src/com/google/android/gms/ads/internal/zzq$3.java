package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzkh;

class zzq$3
  implements Runnable
{
  zzq$3(zzq paramzzq, zze paramzze) {}
  
  public void run()
  {
    try
    {
      if (zzamv.zzajs.zzapj != null) {
        zzamv.zzajs.zzapj.zza(zzamx);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzq.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */