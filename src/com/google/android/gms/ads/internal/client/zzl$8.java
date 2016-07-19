package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhy;

class zzl$8
  extends zzl.zza<zzht>
{
  zzl$8(zzl paramzzl, Activity paramActivity)
  {
    super(paramzzl, null);
  }
  
  public zzht zzg(zzx paramzzx)
    throws RemoteException
  {
    return paramzzx.createInAppPurchaseManager(zze.zzae(val$activity));
  }
  
  public zzht zzis()
  {
    zzht localzzht = zzl.zzg(zzavh).zzg(val$activity);
    if (localzzht != null) {
      return localzzht;
    }
    zzl.zza(zzavh, val$activity, "iap");
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzl.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */