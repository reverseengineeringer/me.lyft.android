package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzaf;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public final class InterstitialAd
{
  private final zzaf zzaij;
  
  public InterstitialAd(Context paramContext)
  {
    zzaij = new zzaf(paramContext);
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    zzaij.zza(paramAdRequest.zzdd());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzaij.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zza))) {
      zzaij.zza((zza)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    zzaij.zza(null);
  }
  
  public void setAdUnitId(String paramString)
  {
    zzaij.setAdUnitId(paramString);
  }
  
  public void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    zzaij.setRewardedVideoAdListener(paramRewardedVideoAdListener);
  }
  
  public void show()
  {
    zzaij.show();
  }
  
  public void zzd(boolean paramBoolean)
  {
    zzaij.zzd(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.InterstitialAd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */