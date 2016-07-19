package com.leanplum.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class SizeUtil
{
  private static boolean a = false;
  public static int dp10 = 0;
  public static int dp100 = 0;
  public static int dp14 = 0;
  public static int dp16 = 0;
  public static int dp18 = 0;
  public static int dp2 = 0;
  public static int dp20 = 0;
  public static int dp200 = 0;
  public static int dp250 = 0;
  public static int dp30 = 0;
  public static int dp5 = 0;
  public static int dp50 = 0;
  public static int dp7 = 0;
  public static final int textSize0 = 20;
  public static final int textSize0_1 = 18;
  public static final int textSize0_2 = 16;
  public static final int textSize1 = 22;
  public static final int textSize2 = 24;
  
  public static int dpToPx(Context paramContext, int paramInt)
  {
    init(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return Math.round(xdpi / 160.0F * f);
  }
  
  public static int getStatusBarHeight(Activity paramActivity)
  {
    init(paramActivity);
    int i;
    if ((getWindowgetAttributesflags & 0x400) == 1024)
    {
      i = 1;
      if (i == 0) {
        break label37;
      }
    }
    label37:
    do
    {
      return 0;
      i = 0;
      break;
      i = paramActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
    } while (i <= 0);
    return paramActivity.getResources().getDimensionPixelSize(i);
  }
  
  public static void init(Context paramContext)
  {
    if (a) {
      return;
    }
    a = true;
    dp30 = dpToPx(paramContext, 30);
    dp5 = dpToPx(paramContext, 5);
    dp20 = dpToPx(paramContext, 20);
    dp10 = dpToPx(paramContext, 10);
    dp7 = dpToPx(paramContext, 7);
    dp18 = dpToPx(paramContext, 18);
    dp16 = dpToPx(paramContext, 16);
    dp14 = dpToPx(paramContext, 14);
    dp100 = dpToPx(paramContext, 100);
    dp200 = dpToPx(paramContext, 200);
    dp250 = dpToPx(paramContext, 250);
    dp2 = dpToPx(paramContext, 2);
    dp50 = dpToPx(paramContext, 50);
  }
  
  public static int pxToDp(Context paramContext, int paramInt)
  {
    init(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    return Math.round(paramInt / (xdpi / 160.0F));
  }
  
  public static int pxToSp(Context paramContext, int paramInt)
  {
    init(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    return (int)(paramInt / scaledDensity);
  }
  
  public static int spToPx(Context paramContext, int paramInt)
  {
    init(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(scaledDensity * f);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.utils.SizeUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */