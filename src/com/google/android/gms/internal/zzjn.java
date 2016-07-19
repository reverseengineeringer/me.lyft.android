package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzir
public class zzjn
  extends zza.zza
{
  private zzjo zzchr;
  private zzjl zzchy;
  private zzjm zzchz;
  
  public zzjn(zzjm paramzzjm)
  {
    zzchz = paramzzjm;
  }
  
  public void zza(zzd paramzzd, RewardItemParcel paramRewardItemParcel)
  {
    if (zzchz != null) {
      zzchz.zzc(paramRewardItemParcel);
    }
  }
  
  public void zza(zzjl paramzzjl)
  {
    zzchy = paramzzjl;
  }
  
  public void zza(zzjo paramzzjo)
  {
    zzchr = paramzzjo;
  }
  
  public void zzb(zzd paramzzd, int paramInt)
  {
    if (zzchy != null) {
      zzchy.zzaw(paramInt);
    }
  }
  
  public void zzc(zzd paramzzd, int paramInt)
  {
    if (zzchr != null) {
      zzchr.zza(zze.zzad(paramzzd).getClass().getName(), paramInt);
    }
  }
  
  public void zzp(zzd paramzzd)
  {
    if (zzchy != null) {
      zzchy.zzrt();
    }
  }
  
  public void zzq(zzd paramzzd)
  {
    if (zzchr != null) {
      zzchr.zzch(zze.zzad(paramzzd).getClass().getName());
    }
  }
  
  public void zzr(zzd paramzzd)
  {
    if (zzchz != null) {
      zzchz.onRewardedVideoAdOpened();
    }
  }
  
  public void zzs(zzd paramzzd)
  {
    if (zzchz != null) {
      zzchz.onRewardedVideoStarted();
    }
  }
  
  public void zzt(zzd paramzzd)
  {
    if (zzchz != null) {
      zzchz.onRewardedVideoAdClosed();
    }
  }
  
  public void zzu(zzd paramzzd)
  {
    if (zzchz != null) {
      zzchz.zzrs();
    }
  }
  
  public void zzv(zzd paramzzd)
  {
    if (zzchz != null) {
      zzchz.onRewardedVideoAdLeftApplication();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */