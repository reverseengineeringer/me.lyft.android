package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzha$5
  implements Runnable
{
  zzha$5(zzha paramzzha, AdRequest.ErrorCode paramErrorCode) {}
  
  public void run()
  {
    try
    {
      zzha.zza(zzbpu).onAdFailedToLoad(zzhb.zza(zzbpv));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzha.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */