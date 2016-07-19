package com.lyft.scoop.transitions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.lyft.scoop.TransitionListener;

class FadeTransition$1
  extends AnimatorListenerAdapter
{
  FadeTransition$1(FadeTransition paramFadeTransition, ViewGroup paramViewGroup, View paramView, TransitionListener paramTransitionListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    val$root.removeView(val$from);
    val$transitionListener.onTransitionCompleted();
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.transitions.FadeTransition.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */