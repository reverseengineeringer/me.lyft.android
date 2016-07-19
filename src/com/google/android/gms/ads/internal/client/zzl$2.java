package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;

class zzl$2
  extends zzl.zza<zzu>
{
  zzl$2(zzl paramzzl, Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString)
  {
    super(paramzzl, null);
  }
  
  public zzu zza(zzx paramzzx)
    throws RemoteException
  {
    return paramzzx.createSearchAdManager(com.google.android.gms.dynamic.zze.zzae(zzaky), zzavf, zzakw, 9256000);
  }
  
  public zzu zzim()
  {
    zzu localzzu = zzl.zzb(zzavh).zza(zzaky, zzavf, zzakw, null, 3);
    if (localzzu != null) {
      return localzzu;
    }
    zzl.zza(zzavh, zzaky, "search");
    return new zzak();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzl.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */