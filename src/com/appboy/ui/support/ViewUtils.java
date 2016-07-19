package com.appboy.ui.support;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;

public class ViewUtils
{
  private static int sDisplayHeight;
  
  public static int getDisplayHeight(Activity paramActivity)
  {
    if (sDisplayHeight > 0) {
      return sDisplayHeight;
    }
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    if (Build.VERSION.SDK_INT <= 13)
    {
      sDisplayHeight = paramActivity.getHeight();
      return sDisplayHeight;
    }
    Point localPoint = new Point();
    paramActivity.getSize(localPoint);
    sDisplayHeight = y;
    return sDisplayHeight;
  }
  
  public static int getTopVisibleCoordinate(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    return top;
  }
  
  @TargetApi(16)
  public static void removeOnGlobalLayoutListenerSafe(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
      return;
    }
    paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public static void removeViewFromParent(View paramView)
  {
    if ((paramView != null) && ((paramView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.support.ViewUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */