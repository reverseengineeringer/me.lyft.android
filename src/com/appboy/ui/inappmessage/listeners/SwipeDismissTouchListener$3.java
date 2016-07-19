package com.appboy.ui.inappmessage.listeners;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class SwipeDismissTouchListener$3
  implements ValueAnimator.AnimatorUpdateListener
{
  SwipeDismissTouchListener$3(SwipeDismissTouchListener paramSwipeDismissTouchListener, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    val$lp.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    SwipeDismissTouchListener.access$000(this$0).setLayoutParams(val$lp);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.SwipeDismissTouchListener.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */