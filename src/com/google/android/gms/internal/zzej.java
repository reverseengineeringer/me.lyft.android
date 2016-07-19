package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzir
public class zzej
  extends zzee.zza
{
  private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzbhm;
  
  public zzej(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    zzbhm = paramOnAppInstallAdLoadedListener;
  }
  
  public void zza(zzdy paramzzdy)
  {
    zzbhm.onAppInstallAdLoaded(zzb(paramzzdy));
  }
  
  zzdz zzb(zzdy paramzzdy)
  {
    return new zzdz(paramzzdy);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzej
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */