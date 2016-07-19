package com.google.android.gms.ads.formats;

import java.util.List;

public abstract class NativeContentAd
  extends NativeAd
{
  public abstract CharSequence getAdvertiser();
  
  public abstract CharSequence getBody();
  
  public abstract CharSequence getCallToAction();
  
  public abstract CharSequence getHeadline();
  
  public abstract List<NativeAd.Image> getImages();
  
  public abstract NativeAd.Image getLogo();
  
  public static abstract interface OnContentAdLoadedListener
  {
    public abstract void onContentAdLoaded(NativeContentAd paramNativeContentAd);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.formats.NativeContentAd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */