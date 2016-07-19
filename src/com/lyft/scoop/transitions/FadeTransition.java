package com.lyft.scoop.transitions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.lyft.scoop.TransitionListener;

@TargetApi(15)
public class FadeTransition
  extends ObjectAnimatorTransition
{
  public static final long DEFAULT_FADE_TIME = 250L;
  private final long fadeTime;
  private final Interpolator interpolator;
  
  public FadeTransition()
  {
    fadeTime = 250L;
    interpolator = new LinearInterpolator();
  }
  
  public FadeTransition(long paramLong, Interpolator paramInterpolator)
  {
    fadeTime = paramLong;
    interpolator = paramInterpolator;
  }
  
  private Animator createAnimator(View paramView1, View paramView2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (paramView1 != null)
    {
      paramView1 = ObjectAnimator.ofFloat(paramView1, View.ALPHA, new float[] { 1.0F, 0.0F }).setDuration(fadeTime);
      paramView1.setInterpolator(interpolator);
      localAnimatorSet.play(paramView1);
    }
    if (paramView2 != null)
    {
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.ALPHA, new float[] { 0.0F, 1.0F }).setDuration(fadeTime);
      paramView1.setInterpolator(interpolator);
      localAnimatorSet.play(paramView1);
    }
    return localAnimatorSet;
  }
  
  public void performTranslate(final ViewGroup paramViewGroup, final View paramView1, View paramView2, final TransitionListener paramTransitionListener)
  {
    paramView2 = createAnimator(paramView1, paramView2);
    paramView2.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramViewGroup.removeView(paramView1);
        paramTransitionListener.onTransitionCompleted();
      }
    });
    paramView2.start();
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.transitions.FadeTransition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */