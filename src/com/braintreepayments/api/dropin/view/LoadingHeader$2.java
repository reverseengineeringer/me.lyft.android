package com.braintreepayments.api.dropin.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class LoadingHeader$2
  implements Animation.AnimationListener
{
  LoadingHeader$2(LoadingHeader paramLoadingHeader) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoadingHeader.access$100(this$0).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.view.LoadingHeader.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */