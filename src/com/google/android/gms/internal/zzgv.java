package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzab;

@zzir
public final class zzgv
  implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener
{
  private final zzgp zzbpo;
  private NativeAdMapper zzbpp;
  
  public zzgv(zzgp paramzzgp)
  {
    zzbpo = paramzzgp;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzab.zzhj("onAdClicked must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdClicked.");
    try
    {
      zzbpo.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzab.zzhj("onAdClicked must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdClicked.");
    try
    {
      zzbpo.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzab.zzhj("onAdClicked must be called on the main UI thread.");
    paramMediationNativeAdapter = zzmu();
    if (paramMediationNativeAdapter == null)
    {
      zzb.zzcy("Could not call onAdClicked since NativeAdMapper is null.");
      return;
    }
    if (!paramMediationNativeAdapter.getOverrideClickHandling())
    {
      zzb.zzcw("Could not call onAdClicked since setOverrideClickHandling is not set to true");
      return;
    }
    zzb.zzcw("Adapter called onAdClicked.");
    try
    {
      zzbpo.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzab.zzhj("onAdClosed must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdClosed.");
    try
    {
      zzbpo.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzab.zzhj("onAdClosed must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdClosed.");
    try
    {
      zzbpo.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzab.zzhj("onAdClosed must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdClosed.");
    try
    {
      zzbpo.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    zzab.zzhj("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzcw(55 + "Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      zzbpo.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    zzab.zzhj("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzcw(55 + "Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      zzbpo.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt)
  {
    zzab.zzhj("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzcw(55 + "Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      zzbpo.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzab.zzhj("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdLeftApplication.");
    try
    {
      zzbpo.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzab.zzhj("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdLeftApplication.");
    try
    {
      zzbpo.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzab.zzhj("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdLeftApplication.");
    try
    {
      zzbpo.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzab.zzhj("onAdLoaded must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdLoaded.");
    try
    {
      zzbpo.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzab.zzhj("onAdLoaded must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdLoaded.");
    try
    {
      zzbpo.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper)
  {
    zzab.zzhj("onAdLoaded must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdLoaded.");
    zzbpp = paramNativeAdMapper;
    try
    {
      zzbpo.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzab.zzhj("onAdOpened must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdOpened.");
    try
    {
      zzbpo.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzab.zzhj("onAdOpened must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdOpened.");
    try
    {
      zzbpo.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzab.zzhj("onAdOpened must be called on the main UI thread.");
    zzb.zzcw("Adapter called onAdOpened.");
    try
    {
      zzbpo.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationNativeAdapter);
    }
  }
  
  public NativeAdMapper zzmu()
  {
    return zzbpp;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */