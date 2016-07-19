package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzgn;

class zzl$1
  extends zzl.zza<zzu>
{
  zzl$1(zzl paramzzl, Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn)
  {
    super(paramzzl, null);
  }
  
  public zzu zza(zzx paramzzx)
    throws RemoteException
  {
    return paramzzx.createBannerAdManager(com.google.android.gms.dynamic.zze.zzae(zzaky), zzavf, zzakw, zzavg, 9256000);
  }
  
  public zzu zzim()
  {
    zzu localzzu = zzl.zzb(zzavh).zza(zzaky, zzavf, zzakw, zzavg, 1);
    if (localzzu != null) {
      return localzzu;
    }
    zzl.zza(zzavh, zzaky, "banner");
    return new zzak();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */