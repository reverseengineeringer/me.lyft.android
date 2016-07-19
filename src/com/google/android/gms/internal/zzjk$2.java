package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.dynamic.zze;

class zzjk$2
  implements Runnable
{
  zzjk$2(zzjk paramzzjk, zzgo paramzzgo, AdRequestParcel paramAdRequestParcel, zzjn paramzzjn) {}
  
  public void run()
  {
    try
    {
      zzchv.zza(zze.zzae(zzjk.zza(zzchw)), zzalo, null, zzchx, zzjk.zzb(zzchw));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      str = String.valueOf(zzjk.zzc(zzchw));
      if (str.length() == 0) {}
    }
    for (String str = "Fail to initialize adapter ".concat(str);; str = new String("Fail to initialize adapter "))
    {
      zzkh.zzd(str, localRemoteException);
      zzchw.zza(zzjk.zzc(zzchw), 0);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjk.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */