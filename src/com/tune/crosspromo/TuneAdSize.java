package com.tune.crosspromo;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class TuneAdSize
{
  public static final TuneAdSize BANNER = new TuneAdSize(320, 50);
  public static final TuneAdSize SMART_BANNER = new TuneAdSize(-1, -2);
  private final int height;
  private final int width;
  
  public TuneAdSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1)) {
      throw new IllegalArgumentException("Invalid width for MATAdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2)) {
      throw new IllegalArgumentException("Invalid height for MATAdSize: " + paramInt2);
    }
    width = paramInt1;
    height = paramInt2;
  }
  
  private int getSmartBannerHeight(Context paramContext, int paramInt)
  {
    paramInt = (int)(paramInt / getResourcesgetDisplayMetricsdensity);
    if (paramInt <= 400) {
      return (int)(32.0F * getResourcesgetDisplayMetricsdensity);
    }
    if (paramInt <= 720) {
      return (int)(50.0F * getResourcesgetDisplayMetricsdensity);
    }
    return (int)(90.0F * getResourcesgetDisplayMetricsdensity);
  }
  
  public int getHeightPixels(Context paramContext)
  {
    if (height == -2) {
      return getSmartBannerHeight(paramContext, getResourcesgetDisplayMetricsheightPixels);
    }
    return (int)(height * getResourcesgetDisplayMetricsdensity);
  }
  
  public int getWidthPixels(Context paramContext)
  {
    if (width == -1) {
      return getResourcesgetDisplayMetricswidthPixels;
    }
    return (int)(width * getResourcesgetDisplayMetricsdensity);
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdSize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */