package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzak$1
  implements Runnable
{
  zzak$1(zzak paramzzak) {}
  
  public void run()
  {
    if (zzak.zza(zzawu) != null) {}
    try
    {
      zzak.zza(zzawu).onAdFailedToLoad(1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not notify onAdFailedToLoad event.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzak.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */