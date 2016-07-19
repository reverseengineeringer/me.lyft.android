package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzkh;

class zzc$1
  implements Runnable
{
  zzc$1(zzc paramzzc, zzf paramzzf, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      if (zzc.zza(zzbxb).zza(zzbxa.zzbxk, -1, val$intent))
      {
        zzc.zzc(zzbxb).zza(new zzg(zzc.zzb(zzbxb), zzbxa.zzbxl, true, -1, val$intent, zzbxa));
        return;
      }
      zzc.zzc(zzbxb).zza(new zzg(zzc.zzb(zzbxb), zzbxa.zzbxl, false, -1, val$intent, zzbxa));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzcy("Fail to verify and dispatch pending transaction");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */