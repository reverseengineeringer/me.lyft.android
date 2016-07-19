package com.appboy.ui.inappmessage.listeners;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class SwipeDismissTouchListener$1
  extends AnimatorListenerAdapter
{
  SwipeDismissTouchListener$1(SwipeDismissTouchListener paramSwipeDismissTouchListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this$0.performDismiss();
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.SwipeDismissTouchListener.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */