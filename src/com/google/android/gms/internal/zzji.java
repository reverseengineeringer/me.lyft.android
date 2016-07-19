package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zze;

@zzir
public class zzji
  extends zzb.zza
{
  private final Context mContext;
  private final Object zzail;
  private final VersionInfoParcel zzalm;
  private final zzjj zzchj;
  
  public zzji(Context paramContext, com.google.android.gms.ads.internal.zzd paramzzd, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel)
  {
    mContext = paramContext;
    zzalm = paramVersionInfoParcel;
    zzchj = new zzjj(paramContext, paramzzd, AdSizeParcel.zzii(), paramzzgn, paramVersionInfoParcel);
    zzail = new Object();
  }
  
  public void destroy()
  {
    zzh(null);
  }
  
  public boolean isLoaded()
  {
    synchronized (zzail)
    {
      boolean bool = zzchj.isLoaded();
      return bool;
    }
  }
  
  public void pause()
  {
    zzf(null);
  }
  
  public void resume()
  {
    zzg(null);
  }
  
  public void setUserId(String paramString)
  {
    zzkh.zzcy("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
  }
  
  public void show()
  {
    synchronized (zzail)
    {
      zzchj.zzrr();
      return;
    }
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    synchronized (zzail)
    {
      zzchj.zza(paramRewardedVideoAdRequestParcel);
      return;
    }
  }
  
  public void zza(com.google.android.gms.ads.internal.reward.client.zzd paramzzd)
  {
    synchronized (zzail)
    {
      zzchj.zza(paramzzd);
      return;
    }
  }
  
  public void zzf(com.google.android.gms.dynamic.zzd arg1)
  {
    synchronized (zzail)
    {
      zzchj.pause();
      return;
    }
  }
  
  public void zzg(com.google.android.gms.dynamic.zzd paramzzd)
  {
    Object localObject = zzail;
    if (paramzzd == null) {
      paramzzd = null;
    }
    for (;;)
    {
      if (paramzzd != null) {}
      try
      {
        zzchj.onContextChanged(paramzzd);
        zzchj.resume();
        return;
        paramzzd = (Context)zze.zzad(paramzzd);
      }
      catch (Exception paramzzd)
      {
        for (;;)
        {
          zzkh.zzd("Unable to extract updated context.", paramzzd);
        }
      }
      finally {}
    }
  }
  
  public void zzh(com.google.android.gms.dynamic.zzd arg1)
  {
    synchronized (zzail)
    {
      zzchj.destroy();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzji
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */