package com.google.ads.mediation;

import com.google.ads.AdRequest.ErrorCode;

@Deprecated
public abstract interface MediationInterstitialListener
{
  public abstract void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, AdRequest.ErrorCode paramErrorCode);
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.MediationInterstitialListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */