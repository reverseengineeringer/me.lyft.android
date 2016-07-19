package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgn;

class zzl$4
  extends zzl.zza<zzs>
{
  zzl$4(zzl paramzzl, Context paramContext, String paramString, zzgn paramzzgn)
  {
    super(paramzzl, null);
  }
  
  public zzs zzc(zzx paramzzx)
    throws RemoteException
  {
    return paramzzx.createAdLoaderBuilder(zze.zzae(zzaky), zzakw, zzavg, 9256000);
  }
  
  public zzs zzio()
  {
    zzs localzzs = zzl.zzc(zzavh).zza(zzaky, zzakw, zzavg);
    if (localzzs != null) {
      return localzzs;
    }
    zzl.zza(zzavh, zzaky, "native_ad");
    return new zzaj();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzl.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */