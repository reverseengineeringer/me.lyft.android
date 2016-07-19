package com.braintreepayments.api.dropin.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class LoadingHeader$1
  implements Animation.AnimationListener
{
  LoadingHeader$1(LoadingHeader paramLoadingHeader) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    LoadingHeader.access$000(this$0).setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.view.LoadingHeader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */