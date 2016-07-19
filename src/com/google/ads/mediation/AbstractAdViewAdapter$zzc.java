package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationBannerListener;

final class AbstractAdViewAdapter$zzc
  extends AdListener
  implements zza
{
  final AbstractAdViewAdapter zzfl;
  final MediationBannerListener zzfm;
  
  public AbstractAdViewAdapter$zzc(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationBannerListener paramMediationBannerListener)
  {
    zzfl = paramAbstractAdViewAdapter;
    zzfm = paramMediationBannerListener;
  }
  
  public void onAdClicked()
  {
    zzfm.onAdClicked(zzfl);
  }
  
  public void onAdClosed()
  {
    zzfm.onAdClosed(zzfl);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzfm.onAdFailedToLoad(zzfl, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzfm.onAdLeftApplication(zzfl);
  }
  
  public void onAdLoaded()
  {
    zzfm.onAdLoaded(zzfl);
  }
  
  public void onAdOpened()
  {
    zzfm.onAdOpened(zzfl);
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */