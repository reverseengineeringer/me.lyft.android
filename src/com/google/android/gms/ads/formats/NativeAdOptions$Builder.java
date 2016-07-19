package com.google.android.gms.ads.formats;

public final class NativeAdOptions$Builder
{
  private boolean zzaiv = false;
  private int zzaiw = 0;
  private boolean zzaix = false;
  private int zzaiy = 1;
  
  public NativeAdOptions build()
  {
    return new NativeAdOptions(this, null);
  }
  
  public Builder setImageOrientation(int paramInt)
  {
    zzaiw = paramInt;
    return this;
  }
  
  public Builder setRequestMultipleImages(boolean paramBoolean)
  {
    zzaix = paramBoolean;
    return this;
  }
  
  public Builder setReturnUrlsForImageAssets(boolean paramBoolean)
  {
    zzaiv = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdOptions.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */