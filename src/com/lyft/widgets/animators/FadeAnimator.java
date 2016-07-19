package com.lyft.widgets.animators;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class FadeAnimator
{
  public static void fadeIn(View paramView)
  {
    if (paramView.getVisibility() == 0) {
      return;
    }
    paramView.setVisibility(0);
    getFadeInAnimator(paramView).start();
  }
  
  public static void fadeOut(View paramView)
  {
    if (paramView.getVisibility() == 8) {
      return;
    }
    final ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator(1.5F));
    localObjectAnimator.start();
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        val$view.setVisibility(8);
        localObjectAnimator.removeAllListeners();
      }
    });
  }
  
  public static ObjectAnimator getFadeInAnimator(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F, 1.0F });
    paramView.setDuration(250L);
    paramView.setInterpolator(new AccelerateInterpolator(1.5F));
    return paramView;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.animators.FadeAnimator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */