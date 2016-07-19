package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

@zzir
public class zzek
  extends zzef.zza
{
  private final NativeContentAd.OnContentAdLoadedListener zzbhn;
  
  public zzek(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
  {
    zzbhn = paramOnContentAdLoadedListener;
  }
  
  public void zza(zzea paramzzea)
  {
    zzbhn.onContentAdLoaded(zzb(paramzzea));
  }
  
  zzeb zzb(zzea paramzzea)
  {
    return new zzeb(paramzzea);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzek
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */