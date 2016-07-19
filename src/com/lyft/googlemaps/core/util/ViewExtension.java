package com.lyft.googlemaps.core.util;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.lyft.googlemaps.core.callback.Callback0;

public class ViewExtension
{
  public static void onViewLoaded(View paramView, final Callback0 paramCallback0)
  {
    ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
    if ((paramView.getWidth() != 0) && (paramView.getHeight() != 0)) {
      paramCallback0.call();
    }
    while (!localViewTreeObserver.isAlive()) {
      return;
    }
    localViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        ViewExtension.removeOnGlobalLayoutListener(val$view.getViewTreeObserver(), this);
        paramCallback0.call();
      }
    });
  }
  
  private static void removeOnGlobalLayoutListener(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
      return;
    }
    paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.util.ViewExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */