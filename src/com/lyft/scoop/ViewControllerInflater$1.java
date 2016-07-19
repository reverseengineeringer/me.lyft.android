package com.lyft.scoop;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

final class ViewControllerInflater$1
  implements View.OnAttachStateChangeListener
{
  ViewControllerInflater$1(ViewController paramViewController, View paramView) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    val$viewController.attach(val$view);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    val$viewController.detach(val$view);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ViewControllerInflater.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */