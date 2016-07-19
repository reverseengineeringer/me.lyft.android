package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@zzir
public final class zzgu
  extends zzgo.zza
{
  private final MediationAdapter zzbpm;
  private zzgv zzbpn;
  
  public zzgu(MediationAdapter paramMediationAdapter)
  {
    zzbpm = paramMediationAdapter;
  }
  
  private Bundle zza(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    Object localObject = String.valueOf(paramString1);
    if (((String)localObject).length() != 0) {
      localObject = "Server parameters: ".concat((String)localObject);
    }
    for (;;)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzcy((String)localObject);
      try
      {
        localObject = new Bundle();
        if (paramString1 == null) {
          break;
        }
        paramString1 = new JSONObject(paramString1);
        localObject = new Bundle();
        Iterator localIterator = paramString1.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((Bundle)localObject).putString(str, paramString1.getString(str));
        }
        localObject = new String("Server parameters: ");
      }
      catch (Throwable paramString1)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get Server Parameters Bundle.", paramString1);
        throw new RemoteException();
      }
    }
    if ((zzbpm instanceof AdMobAdapter))
    {
      ((Bundle)localObject).putString("adJson", paramString2);
      ((Bundle)localObject).putInt("tagForChildDirectedTreatment", paramInt);
    }
    return (Bundle)localObject;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      zzbpm.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    if (!(zzbpm instanceof zzlx))
    {
      String str = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ".concat(str);; str = new String("MediationAdapter is not a v2 MediationInterstitialAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(str);
        return new Bundle();
      }
    }
    return ((zzlx)zzbpm).getInterstitialAdapterInfo();
  }
  
  public zzd getView()
    throws RemoteException
  {
    Object localObject;
    if (!(zzbpm instanceof MediationBannerAdapter))
    {
      localObject = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (((String)localObject).length() != 0) {}
      for (localObject = "MediationAdapter is not a MediationBannerAdapter: ".concat((String)localObject);; localObject = new String("MediationAdapter is not a MediationBannerAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy((String)localObject);
        throw new RemoteException();
      }
    }
    try
    {
      localObject = zze.zzae(((MediationBannerAdapter)zzbpm).getBannerView());
      return (zzd)localObject;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
    throws RemoteException
  {
    if (!(zzbpm instanceof MediationRewardedVideoAdAdapter))
    {
      String str = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(str);; str = new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(str);
        throw new RemoteException();
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzcw("Check if adapter is initialized.");
    try
    {
      boolean bool = ((MediationRewardedVideoAdAdapter)zzbpm).isInitialized();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not check if adapter is initialized.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      zzbpm.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      zzbpm.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(zzbpm instanceof MediationInterstitialAdapter))
    {
      String str = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a MediationInterstitialAdapter: ".concat(str);; str = new String("MediationAdapter is not a MediationInterstitialAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(str);
        throw new RemoteException();
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzcw("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)zzbpm).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo()
    throws RemoteException
  {
    if (!(zzbpm instanceof MediationRewardedVideoAdAdapter))
    {
      String str = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(str);; str = new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(str);
        throw new RemoteException();
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzcw("Show rewarded video ad from adapter.");
    try
    {
      ((MediationRewardedVideoAdAdapter)zzbpm).showVideo();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show rewarded video ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void zza(AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2)
    throws RemoteException
  {
    if (!(zzbpm instanceof MediationRewardedVideoAdAdapter))
    {
      paramAdRequestParcel = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (paramAdRequestParcel.length() != 0) {}
      for (paramAdRequestParcel = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(paramAdRequestParcel);; paramAdRequestParcel = new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(paramAdRequestParcel);
        throw new RemoteException();
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzcw("Requesting rewarded video ad from adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)zzbpm;
        if (zzatm == null) {
          break label227;
        }
        localObject1 = new HashSet(zzatm);
        Object localObject2;
        if (zzatk == -1L)
        {
          localObject2 = null;
          localObject2 = new zzgt((Date)localObject2, zzatl, (Set)localObject1, zzats, zzatn, zzato, zzatz);
          if (zzatu != null)
          {
            localObject1 = zzatu.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.loadAd((MediationAdRequest)localObject2, zza(paramString1, zzato, paramString2), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzatk);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramAdRequestParcel)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not load rewarded video ad from adapter.", paramAdRequestParcel);
        throw new RemoteException();
      }
      continue;
      label227:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, com.google.android.gms.ads.internal.reward.mediation.client.zza paramzza, String paramString2)
    throws RemoteException
  {
    if (!(zzbpm instanceof MediationRewardedVideoAdAdapter))
    {
      paramzzd = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (paramzzd.length() != 0) {}
      for (paramzzd = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(paramzzd);; paramzzd = new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(paramzzd);
        throw new RemoteException();
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzcw("Initialize rewarded video adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)zzbpm;
        if (zzatm == null) {
          break label246;
        }
        localObject1 = new HashSet(zzatm);
        Object localObject2;
        if (zzatk == -1L)
        {
          localObject2 = null;
          localObject2 = new zzgt((Date)localObject2, zzatl, (Set)localObject1, zzats, zzatn, zzato, zzatz);
          if (zzatu != null)
          {
            localObject1 = zzatu.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.initialize((Context)zze.zzad(paramzzd), (MediationAdRequest)localObject2, paramString1, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(paramzza), zza(paramString2, zzato, null), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzatk);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not initialize rewarded video adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label246:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString, zzgp paramzzgp)
    throws RemoteException
  {
    zza(paramzzd, paramAdRequestParcel, paramString, null, paramzzgp);
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzgp paramzzgp)
    throws RemoteException
  {
    if (!(zzbpm instanceof MediationInterstitialAdapter))
    {
      paramzzd = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (paramzzd.length() != 0) {}
      for (paramzzd = "MediationAdapter is not a MediationInterstitialAdapter: ".concat(paramzzd);; paramzzd = new String("MediationAdapter is not a MediationInterstitialAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(paramzzd);
        throw new RemoteException();
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzcw("Requesting interstitial ad from adapter.");
    for (;;)
    {
      try
      {
        MediationInterstitialAdapter localMediationInterstitialAdapter = (MediationInterstitialAdapter)zzbpm;
        if (zzatm == null) {
          break label246;
        }
        localObject1 = new HashSet(zzatm);
        Object localObject2;
        if (zzatk == -1L)
        {
          localObject2 = null;
          localObject2 = new zzgt((Date)localObject2, zzatl, (Set)localObject1, zzats, zzatn, zzato, zzatz);
          if (zzatu != null)
          {
            localObject1 = zzatu.getBundle(localMediationInterstitialAdapter.getClass().getName());
            localMediationInterstitialAdapter.requestInterstitialAd((Context)zze.zzad(paramzzd), new zzgv(paramzzgp), zza(paramString1, zzato, paramString2), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzatk);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label246:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzgp paramzzgp, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
    throws RemoteException
  {
    if (!(zzbpm instanceof MediationNativeAdapter))
    {
      paramzzd = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (paramzzd.length() != 0) {}
      for (paramzzd = "MediationAdapter is not a MediationNativeAdapter: ".concat(paramzzd);; paramzzd = new String("MediationAdapter is not a MediationNativeAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(paramzzd);
        throw new RemoteException();
      }
    }
    for (;;)
    {
      try
      {
        MediationNativeAdapter localMediationNativeAdapter = (MediationNativeAdapter)zzbpm;
        if (zzatm == null) {
          break label254;
        }
        localHashSet = new HashSet(zzatm);
        Date localDate;
        if (zzatk == -1L)
        {
          localDate = null;
          paramList = new zzgy(localDate, zzatl, localHashSet, zzats, zzatn, zzato, paramNativeAdOptionsParcel, paramList, zzatz);
          if (zzatu != null)
          {
            paramNativeAdOptionsParcel = zzatu.getBundle(localMediationNativeAdapter.getClass().getName());
            zzbpn = new zzgv(paramzzgp);
            localMediationNativeAdapter.requestNativeAd((Context)zze.zzad(paramzzd), zzbpn, zza(paramString1, zzato, paramString2), paramList, paramNativeAdOptionsParcel);
          }
        }
        else
        {
          localDate = new Date(zzatk);
          continue;
        }
        paramNativeAdOptionsParcel = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request native ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label254:
      HashSet localHashSet = null;
    }
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, zzgp paramzzgp)
    throws RemoteException
  {
    zza(paramzzd, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramzzgp);
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzgp paramzzgp)
    throws RemoteException
  {
    if (!(zzbpm instanceof MediationBannerAdapter))
    {
      paramzzd = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (paramzzd.length() != 0) {}
      for (paramzzd = "MediationAdapter is not a MediationBannerAdapter: ".concat(paramzzd);; paramzzd = new String("MediationAdapter is not a MediationBannerAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(paramzzd);
        throw new RemoteException();
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzcw("Requesting banner ad from adapter.");
    for (;;)
    {
      try
      {
        MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)zzbpm;
        if (zzatm == null) {
          break label262;
        }
        localObject1 = new HashSet(zzatm);
        Object localObject2;
        if (zzatk == -1L)
        {
          localObject2 = null;
          localObject2 = new zzgt((Date)localObject2, zzatl, (Set)localObject1, zzats, zzatn, zzato, zzatz);
          if (zzatu != null)
          {
            localObject1 = zzatu.getBundle(localMediationBannerAdapter.getClass().getName());
            localMediationBannerAdapter.requestBannerAd((Context)zze.zzad(paramzzd), new zzgv(paramzzgp), zza(paramString1, zzato, paramString2), com.google.android.gms.ads.zza.zza(width, height, zzaup), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzatk);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label262:
      Object localObject1 = null;
    }
  }
  
  public void zzc(AdRequestParcel paramAdRequestParcel, String paramString)
    throws RemoteException
  {
    zza(paramAdRequestParcel, paramString, null);
  }
  
  public void zzj(zzd paramzzd)
    throws RemoteException
  {
    try
    {
      paramzzd = (Context)zze.zzad(paramzzd);
      ((OnContextChangedListener)zzbpm).onContextChanged(paramzzd);
      return;
    }
    catch (Throwable paramzzd)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zza("Could not inform adapter of changed context", paramzzd);
    }
  }
  
  public zzgr zzmq()
  {
    NativeAdMapper localNativeAdMapper = zzbpn.zzmu();
    if ((localNativeAdMapper instanceof NativeAppInstallAdMapper)) {
      return new zzgw((NativeAppInstallAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public zzgs zzmr()
  {
    NativeAdMapper localNativeAdMapper = zzbpn.zzmu();
    if ((localNativeAdMapper instanceof NativeContentAdMapper)) {
      return new zzgx((NativeContentAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public Bundle zzms()
  {
    if (!(zzbpm instanceof zzlw))
    {
      String str = String.valueOf(zzbpm.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a v2 MediationBannerAdapter: ".concat(str);; str = new String("MediationAdapter is not a v2 MediationBannerAdapter: "))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(str);
        return new Bundle();
      }
    }
    return ((zzlw)zzbpm).zzms();
  }
  
  public Bundle zzmt()
  {
    return new Bundle();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */