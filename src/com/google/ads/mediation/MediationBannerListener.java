package com.google.ads.mediation;

import com.google.ads.AdRequest.ErrorCode;

@Deprecated
public abstract interface MediationBannerListener
{
  public abstract void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, AdRequest.ErrorCode paramErrorCode);
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.MediationBannerListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */