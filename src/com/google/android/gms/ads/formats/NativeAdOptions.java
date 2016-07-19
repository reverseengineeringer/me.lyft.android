package com.google.android.gms.ads.formats;

import com.google.android.gms.internal.zzir;

@zzir
public final class NativeAdOptions
{
  private final boolean zzaiv;
  private final int zzaiw;
  private final boolean zzaix;
  private final int zzaiy;
  
  private NativeAdOptions(Builder paramBuilder)
  {
    zzaiv = Builder.zza(paramBuilder);
    zzaiw = Builder.zzb(paramBuilder);
    zzaix = Builder.zzc(paramBuilder);
    zzaiy = Builder.zzd(paramBuilder);
  }
  
  public int getAdChoicesPlacement()
  {
    return zzaiy;
  }
  
  public int getImageOrientation()
  {
    return zzaiw;
  }
  
  public boolean shouldRequestMultipleImages()
  {
    return zzaix;
  }
  
  public boolean shouldReturnUrlsForImageAssets()
  {
    return zzaiv;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */