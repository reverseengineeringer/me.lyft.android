package com.lyft.googlemaps.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;

public class MetricsUtils
{
  private final Context context;
  
  private MetricsUtils(Context paramContext)
  {
    context = paramContext;
  }
  
  public static MetricsUtils fromView(View paramView)
  {
    return new MetricsUtils(paramView.getContext());
  }
  
  public float pixelsToDp(float paramFloat)
  {
    return paramFloat / context.getResources().getDisplayMetrics().density;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.util.MetricsUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */