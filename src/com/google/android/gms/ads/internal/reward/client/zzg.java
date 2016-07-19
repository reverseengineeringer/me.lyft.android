package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzir;

@zzir
public class zzg
  extends zzd.zza
{
  private final RewardedVideoAdListener zzfh;
  
  public zzg(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    zzfh = paramRewardedVideoAdListener;
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (zzfh != null) {
      zzfh.onRewardedVideoAdClosed();
    }
  }
  
  public void onRewardedVideoAdFailedToLoad(int paramInt)
  {
    if (zzfh != null) {
      zzfh.onRewardedVideoAdFailedToLoad(paramInt);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (zzfh != null) {
      zzfh.onRewardedVideoAdLeftApplication();
    }
  }
  
  public void onRewardedVideoAdLoaded()
  {
    if (zzfh != null) {
      zzfh.onRewardedVideoAdLoaded();
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    if (zzfh != null) {
      zzfh.onRewardedVideoAdOpened();
    }
  }
  
  public void onRewardedVideoStarted()
  {
    if (zzfh != null) {
      zzfh.onRewardedVideoStarted();
    }
  }
  
  public void zza(zza paramzza)
  {
    if (zzfh != null) {
      zzfh.onRewarded(new zze(paramzza));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.client.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */