package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzx.zza;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdw;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzji;

@zzir
@Keep
@DynamiteApi
public class ClientApi
  extends zzx.zza
{
  public zzs createAdLoaderBuilder(com.google.android.gms.dynamic.zzd paramzzd, String paramString, zzgn paramzzgn, int paramInt)
  {
    paramzzd = (Context)com.google.android.gms.dynamic.zze.zzad(paramzzd);
    if (paramzzd.getClassLoader() == ClientApi.class.getClassLoader()) {}
    for (boolean bool = true;; bool = false) {
      return new zzk(paramzzd, paramString, paramzzgn, new VersionInfoParcel(9256000, paramInt, bool), zzd.zzel());
    }
  }
  
  public zzhm createAdOverlay(com.google.android.gms.dynamic.zzd paramzzd)
  {
    return new com.google.android.gms.ads.internal.overlay.zzd((Activity)com.google.android.gms.dynamic.zze.zzad(paramzzd));
  }
  
  public zzu createBannerAdManager(com.google.android.gms.dynamic.zzd paramzzd, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn, int paramInt)
    throws RemoteException
  {
    paramzzd = (Context)com.google.android.gms.dynamic.zze.zzad(paramzzd);
    if (paramzzd.getClassLoader() == ClientApi.class.getClassLoader()) {}
    for (boolean bool = true;; bool = false) {
      return new zzf(paramzzd, paramAdSizeParcel, paramString, paramzzgn, new VersionInfoParcel(9256000, paramInt, bool), zzd.zzel());
    }
  }
  
  public zzht createInAppPurchaseManager(com.google.android.gms.dynamic.zzd paramzzd)
  {
    return new com.google.android.gms.ads.internal.purchase.zze((Activity)com.google.android.gms.dynamic.zze.zzad(paramzzd));
  }
  
  public zzu createInterstitialAdManager(com.google.android.gms.dynamic.zzd paramzzd, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn, int paramInt)
    throws RemoteException
  {
    paramzzd = (Context)com.google.android.gms.dynamic.zze.zzad(paramzzd);
    zzdc.initialize(paramzzd);
    boolean bool;
    VersionInfoParcel localVersionInfoParcel;
    if (paramzzd.getClassLoader() == ClientApi.class.getClassLoader())
    {
      bool = true;
      localVersionInfoParcel = new VersionInfoParcel(9256000, paramInt, bool);
      bool = "reward_mb".equals(zzaup);
      if (((bool) || (!((Boolean)zzdc.zzbac.get()).booleanValue())) && ((!bool) || (!((Boolean)zzdc.zzbad.get()).booleanValue()))) {
        break label124;
      }
    }
    label124:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label130;
      }
      return new zzfr(paramzzd, paramString, paramzzgn, localVersionInfoParcel, zzd.zzel());
      bool = false;
      break;
    }
    label130:
    return new zzl(paramzzd, paramAdSizeParcel, paramString, paramzzgn, localVersionInfoParcel, zzd.zzel());
  }
  
  public zzdw createNativeAdViewDelegate(com.google.android.gms.dynamic.zzd paramzzd1, com.google.android.gms.dynamic.zzd paramzzd2)
  {
    return new com.google.android.gms.ads.internal.formats.zzk((FrameLayout)com.google.android.gms.dynamic.zze.zzad(paramzzd1), (FrameLayout)com.google.android.gms.dynamic.zze.zzad(paramzzd2));
  }
  
  public zzb createRewardedVideoAd(com.google.android.gms.dynamic.zzd paramzzd, zzgn paramzzgn, int paramInt)
  {
    paramzzd = (Context)com.google.android.gms.dynamic.zze.zzad(paramzzd);
    if (paramzzd.getClassLoader() == ClientApi.class.getClassLoader()) {}
    for (boolean bool = true;; bool = false)
    {
      VersionInfoParcel localVersionInfoParcel = new VersionInfoParcel(9256000, paramInt, bool);
      return new zzji(paramzzd, zzd.zzel(), paramzzgn, localVersionInfoParcel);
    }
  }
  
  public zzu createSearchAdManager(com.google.android.gms.dynamic.zzd paramzzd, AdSizeParcel paramAdSizeParcel, String paramString, int paramInt)
    throws RemoteException
  {
    paramzzd = (Context)com.google.android.gms.dynamic.zze.zzad(paramzzd);
    if (paramzzd.getClassLoader() == ClientApi.class.getClassLoader()) {}
    for (boolean bool = true;; bool = false) {
      return new zzt(paramzzd, paramAdSizeParcel, paramString, new VersionInfoParcel(9256000, paramInt, bool));
    }
  }
  
  public zzz getMobileAdsSettingsManager(com.google.android.gms.dynamic.zzd paramzzd)
  {
    return null;
  }
  
  public zzz getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.zzd paramzzd, int paramInt)
  {
    paramzzd = (Context)com.google.android.gms.dynamic.zze.zzad(paramzzd);
    if (paramzzd.getClassLoader() == ClientApi.class.getClassLoader()) {}
    for (boolean bool = true;; bool = false) {
      return zzo.zza(paramzzd, new VersionInfoParcel(9256000, paramInt, bool));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.ClientApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */