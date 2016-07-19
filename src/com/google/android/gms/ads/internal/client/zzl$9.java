package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhm;

class zzl$9
  extends zzl.zza<zzhm>
{
  zzl$9(zzl paramzzl, Activity paramActivity)
  {
    super(paramzzl, null);
  }
  
  public zzhm zzh(zzx paramzzx)
    throws RemoteException
  {
    return paramzzx.createAdOverlay(zze.zzae(val$activity));
  }
  
  public zzhm zzit()
  {
    zzhm localzzhm = zzl.zzh(zzavh).zzf(val$activity);
    if (localzzhm != null) {
      return localzzhm;
    }
    zzl.zza(zzavh, val$activity, "ad_overlay");
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzl.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */