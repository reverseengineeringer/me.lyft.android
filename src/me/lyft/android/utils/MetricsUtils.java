package me.lyft.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;

public class MetricsUtils
{
  final Context context;
  
  public MetricsUtils(Context paramContext)
  {
    context = paramContext;
  }
  
  public static MetricsUtils fromContext(Context paramContext)
  {
    return new MetricsUtils(paramContext);
  }
  
  public static MetricsUtils fromView(View paramView)
  {
    return fromContext(paramView.getContext());
  }
  
  public int dpToPixels(float paramFloat)
  {
    return (int)(paramFloat * context.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public float pixelsToDp(float paramFloat)
  {
    return paramFloat / context.getResources().getDisplayMetrics().density;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.utils.MetricsUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */