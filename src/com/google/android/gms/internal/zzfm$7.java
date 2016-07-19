package com.google.android.gms.internal;

import android.os.RemoteException;

class zzfm$7
  implements Runnable
{
  zzfm$7(zzfm paramzzfm, zzfm.zza paramzza, zzfn paramzzfn) {}
  
  public void run()
  {
    try
    {
      zzbkj.zzb(zzbkk);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzd("Could not propagate interstitial ad event.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */