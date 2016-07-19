package com.lyft.widgets.animators;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

final class FadeAnimator$1
  extends AnimatorListenerAdapter
{
  FadeAnimator$1(View paramView, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    val$view.setVisibility(8);
    val$animator.removeAllListeners();
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.animators.FadeAnimator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */