package com.lyft.googlemaps.core.util;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.lyft.googlemaps.core.callback.Callback0;

final class ViewExtension$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ViewExtension$1(View paramView, Callback0 paramCallback0) {}
  
  public void onGlobalLayout()
  {
    ViewExtension.access$000(val$view.getViewTreeObserver(), this);
    val$callback.call();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.util.ViewExtension.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */