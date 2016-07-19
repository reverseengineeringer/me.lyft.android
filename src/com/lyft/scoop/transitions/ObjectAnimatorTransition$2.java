package com.lyft.scoop.transitions;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class ObjectAnimatorTransition$2
  implements ViewTreeObserver.OnPreDrawListener
{
  ObjectAnimatorTransition$2(View paramView, ObjectAnimatorTransition.OnMeasuredCallback paramOnMeasuredCallback) {}
  
  public boolean onPreDraw()
  {
    ViewTreeObserver localViewTreeObserver = val$view.getViewTreeObserver();
    if (localViewTreeObserver.isAlive()) {
      localViewTreeObserver.removeOnPreDrawListener(this);
    }
    val$callback.onMeasured(val$view, val$view.getWidth(), val$view.getHeight());
    return true;
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.transitions.ObjectAnimatorTransition.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */