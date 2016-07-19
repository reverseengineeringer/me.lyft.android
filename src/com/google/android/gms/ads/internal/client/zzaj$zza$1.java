package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzaj$zza$1
  implements Runnable
{
  zzaj$zza$1(zzaj.zza paramzza) {}
  
  public void run()
  {
    if (zzaj.zza(zzawt.zzaws) != null) {}
    try
    {
      zzaj.zza(zzawt.zzaws).onAdFailedToLoad(1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not notify onAdFailedToLoad event.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzaj.zza.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */