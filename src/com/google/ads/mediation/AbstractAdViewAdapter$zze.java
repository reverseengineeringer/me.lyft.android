package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationNativeListener;

final class AbstractAdViewAdapter$zze
  extends AdListener
  implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, zza
{
  final AbstractAdViewAdapter zzfl;
  final MediationNativeListener zzfo;
  
  public AbstractAdViewAdapter$zze(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationNativeListener paramMediationNativeListener)
  {
    zzfl = paramAbstractAdViewAdapter;
    zzfo = paramMediationNativeListener;
  }
  
  public void onAdClicked()
  {
    zzfo.onAdClicked(zzfl);
  }
  
  public void onAdClosed()
  {
    zzfo.onAdClosed(zzfl);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzfo.onAdFailedToLoad(zzfl, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzfo.onAdLeftApplication(zzfl);
  }
  
  public void onAdLoaded() {}
  
  public void onAdOpened()
  {
    zzfo.onAdOpened(zzfl);
  }
  
  public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
  {
    zzfo.onAdLoaded(zzfl, new AbstractAdViewAdapter.zza(paramNativeAppInstallAd));
  }
  
  public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
  {
    zzfo.onAdLoaded(zzfl, new AbstractAdViewAdapter.zzb(paramNativeContentAd));
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */