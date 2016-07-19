package com.google.ads.mediation;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

class AbstractAdViewAdapter$1
  implements RewardedVideoAdListener
{
  AbstractAdViewAdapter$1(AbstractAdViewAdapter paramAbstractAdViewAdapter) {}
  
  public void onRewarded(RewardItem paramRewardItem)
  {
    AbstractAdViewAdapter.zza(zzfi).onRewarded(zzfi, paramRewardItem);
  }
  
  public void onRewardedVideoAdClosed()
  {
    AbstractAdViewAdapter.zza(zzfi).onAdClosed(zzfi);
    AbstractAdViewAdapter.zza(zzfi, null);
  }
  
  public void onRewardedVideoAdFailedToLoad(int paramInt)
  {
    AbstractAdViewAdapter.zza(zzfi).onAdFailedToLoad(zzfi, paramInt);
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    AbstractAdViewAdapter.zza(zzfi).onAdLeftApplication(zzfi);
  }
  
  public void onRewardedVideoAdLoaded()
  {
    AbstractAdViewAdapter.zza(zzfi).onAdLoaded(zzfi);
  }
  
  public void onRewardedVideoAdOpened()
  {
    AbstractAdViewAdapter.zza(zzfi).onAdOpened(zzfi);
  }
  
  public void onRewardedVideoStarted()
  {
    AbstractAdViewAdapter.zza(zzfi).onVideoStarted(zzfi);
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */