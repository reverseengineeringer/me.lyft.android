package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzir
public final class zzgz<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends zzgo.zza
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzbps;
  private final NETWORK_EXTRAS zzbpt;
  
  public zzgz(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    zzbps = paramMediationAdapter;
    zzbpt = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS zzb(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    if (paramString1 != null) {
      try
      {
        localObject = new JSONObject(paramString1);
        paramString2 = new HashMap(((JSONObject)localObject).length());
        Iterator localIterator = ((JSONObject)localObject).keys();
        for (;;)
        {
          paramString1 = paramString2;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString1 = (String)localIterator.next();
          paramString2.put(paramString1, ((JSONObject)localObject).getString(paramString1));
        }
        paramString1 = new HashMap(0);
      }
      catch (Throwable paramString1)
      {
        zzb.zzd("Could not get MediationServerParameters.", paramString1);
        throw new RemoteException();
      }
    }
    Object localObject = zzbps.getServerParametersType();
    paramString2 = null;
    if (localObject != null)
    {
      paramString2 = (MediationServerParameters)((Class)localObject).newInstance();
      paramString2.load(paramString1);
    }
    return paramString2;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      zzbps.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    return new Bundle();
  }
  
  public zzd getView()
    throws RemoteException
  {
    Object localObject;
    if (!(zzbps instanceof MediationBannerAdapter))
    {
      localObject = String.valueOf(zzbps.getClass().getCanonicalName());
      if (((String)localObject).length() != 0) {}
      for (localObject = "MediationAdapter is not a MediationBannerAdapter: ".concat((String)localObject);; localObject = new String("MediationAdapter is not a MediationBannerAdapter: "))
      {
        zzb.zzcy((String)localObject);
        throw new RemoteException();
      }
    }
    try
    {
      localObject = zze.zzae(((MediationBannerAdapter)zzbps).getBannerView());
      return (zzd)localObject;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
  {
    return true;
  }
  
  public void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void resume()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(zzbps instanceof MediationInterstitialAdapter))
    {
      String str = String.valueOf(zzbps.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a MediationInterstitialAdapter: ".concat(str);; str = new String("MediationAdapter is not a MediationInterstitialAdapter: "))
      {
        zzb.zzcy(str);
        throw new RemoteException();
      }
    }
    zzb.zzcw("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)zzbps).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo() {}
  
  public void zza(AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2) {}
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, zza paramzza, String paramString2)
    throws RemoteException
  {}
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString, zzgp paramzzgp)
    throws RemoteException
  {
    zza(paramzzd, paramAdRequestParcel, paramString, null, paramzzgp);
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzgp paramzzgp)
    throws RemoteException
  {
    if (!(zzbps instanceof MediationInterstitialAdapter))
    {
      paramzzd = String.valueOf(zzbps.getClass().getCanonicalName());
      if (paramzzd.length() != 0) {}
      for (paramzzd = "MediationAdapter is not a MediationInterstitialAdapter: ".concat(paramzzd);; paramzzd = new String("MediationAdapter is not a MediationInterstitialAdapter: "))
      {
        zzb.zzcy(paramzzd);
        throw new RemoteException();
      }
    }
    zzb.zzcw("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)zzbps).requestInterstitialAd(new zzha(paramzzgp), (Activity)zze.zzad(paramzzd), zzb(paramString1, zzato, paramString2), zzhb.zzp(paramAdRequestParcel), zzbpt);
      return;
    }
    catch (Throwable paramzzd)
    {
      zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
      throw new RemoteException();
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzgp paramzzgp, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList) {}
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, zzgp paramzzgp)
    throws RemoteException
  {
    zza(paramzzd, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramzzgp);
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzgp paramzzgp)
    throws RemoteException
  {
    if (!(zzbps instanceof MediationBannerAdapter))
    {
      paramzzd = String.valueOf(zzbps.getClass().getCanonicalName());
      if (paramzzd.length() != 0) {}
      for (paramzzd = "MediationAdapter is not a MediationBannerAdapter: ".concat(paramzzd);; paramzzd = new String("MediationAdapter is not a MediationBannerAdapter: "))
      {
        zzb.zzcy(paramzzd);
        throw new RemoteException();
      }
    }
    zzb.zzcw("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)zzbps).requestBannerAd(new zzha(paramzzgp), (Activity)zze.zzad(paramzzd), zzb(paramString1, zzato, paramString2), zzhb.zzc(paramAdSizeParcel), zzhb.zzp(paramAdRequestParcel), zzbpt);
      return;
    }
    catch (Throwable paramzzd)
    {
      zzb.zzd("Could not request banner ad from adapter.", paramzzd);
      throw new RemoteException();
    }
  }
  
  public void zzc(AdRequestParcel paramAdRequestParcel, String paramString) {}
  
  public void zzj(zzd paramzzd)
    throws RemoteException
  {}
  
  public zzgr zzmq()
  {
    return null;
  }
  
  public zzgs zzmr()
  {
    return null;
  }
  
  public Bundle zzms()
  {
    return new Bundle();
  }
  
  public Bundle zzmt()
  {
    return new Bundle();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */