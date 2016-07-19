package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

final class AbstractAdViewAdapter$zzd
  extends AdListener
  implements zza
{
  final AbstractAdViewAdapter zzfl;
  final MediationInterstitialListener zzfn;
  
  public AbstractAdViewAdapter$zzd(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationInterstitialListener paramMediationInterstitialListener)
  {
    zzfl = paramAbstractAdViewAdapter;
    zzfn = paramMediationInterstitialListener;
  }
  
  public void onAdClicked()
  {
    zzfn.onAdClicked(zzfl);
  }
  
  public void onAdClosed()
  {
    zzfn.onAdClosed(zzfl);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzfn.onAdFailedToLoad(zzfl, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzfn.onAdLeftApplication(zzfl);
  }
  
  public void onAdLoaded()
  {
    zzfn.onAdLoaded(zzfl);
  }
  
  public void onAdOpened()
  {
    zzfn.onAdOpened(zzfl);
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */