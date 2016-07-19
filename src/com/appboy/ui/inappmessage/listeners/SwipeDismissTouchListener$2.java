package com.appboy.ui.inappmessage.listeners;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class SwipeDismissTouchListener$2
  extends AnimatorListenerAdapter
{
  SwipeDismissTouchListener$2(SwipeDismissTouchListener paramSwipeDismissTouchListener, ViewGroup.LayoutParams paramLayoutParams, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SwipeDismissTouchListener.access$200(this$0).onDismiss(SwipeDismissTouchListener.access$000(this$0), SwipeDismissTouchListener.access$100(this$0));
    SwipeDismissTouchListener.access$000(this$0).setAlpha(1.0F);
    SwipeDismissTouchListener.access$000(this$0).setTranslationX(0.0F);
    val$lp.height = val$originalHeight;
    SwipeDismissTouchListener.access$000(this$0).setLayoutParams(val$lp);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.SwipeDismissTouchListener.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */