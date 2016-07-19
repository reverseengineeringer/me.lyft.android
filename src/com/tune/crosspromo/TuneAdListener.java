package com.tune.crosspromo;

public abstract interface TuneAdListener
{
  public abstract void onAdClick(TuneAd paramTuneAd);
  
  public abstract void onAdLoad(TuneAd paramTuneAd);
  
  public abstract void onAdLoadFailed(TuneAd paramTuneAd, String paramString);
  
  public abstract void onAdShown(TuneAd paramTuneAd);
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */