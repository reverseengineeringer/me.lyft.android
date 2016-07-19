package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzle;

@zzir
public final class zzc
{
  public static zzkn zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzle<AdRequestInfoParcel> paramzzle, zza paramzza)
  {
    zza(paramContext, paramVersionInfoParcel, paramzzle, paramzza, new zzb()
    {
      public boolean zza(VersionInfoParcel paramAnonymousVersionInfoParcel)
      {
        return (zzcnq) || ((zzi.zzcl(zzc.this)) && (!((Boolean)zzdc.zzayx.get()).booleanValue()));
      }
    });
  }
  
  static zzkn zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzle<AdRequestInfoParcel> paramzzle, zza paramzza, zzb paramzzb)
  {
    if (paramzzb.zza(paramVersionInfoParcel)) {
      return zza(paramContext, paramzzle, paramzza);
    }
    return zzb(paramContext, paramVersionInfoParcel, paramzzle, paramzza);
  }
  
  private static zzkn zza(Context paramContext, zzle<AdRequestInfoParcel> paramzzle, zza paramzza)
  {
    zzkh.zzcw("Fetching ad response from local ad request service.");
    paramContext = new zzd.zza(paramContext, paramzzle, paramzza);
    paramzzle = (Void)paramContext.zzpz();
    return paramContext;
  }
  
  private static zzkn zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzle<AdRequestInfoParcel> paramzzle, zza paramzza)
  {
    zzkh.zzcw("Fetching ad response from remote ad request service.");
    if (!zzm.zziw().zzar(paramContext))
    {
      zzkh.zzcy("Failed to connect to remote ad request service.");
      return null;
    }
    return new zzd.zzb(paramContext, paramVersionInfoParcel, paramzzle, paramzza);
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(AdResponseParcel paramAdResponseParcel);
  }
  
  static abstract interface zzb
  {
    public abstract boolean zza(VersionInfoParcel paramVersionInfoParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */