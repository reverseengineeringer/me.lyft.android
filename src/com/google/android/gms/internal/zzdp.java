package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzir
public final class zzdp
  extends zzdo.zza
{
  private final OnCustomRenderedAdLoadedListener zzawg;
  
  public zzdp(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zzawg = paramOnCustomRenderedAdLoadedListener;
  }
  
  public void zza(zzdn paramzzdn)
  {
    zzawg.onCustomRenderedAdLoaded(new zzdm(paramzzdn));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */