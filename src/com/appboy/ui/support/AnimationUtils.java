package com.appboy.ui.support;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

public class AnimationUtils
{
  private static Interpolator sAccelerateInterpolator = new AccelerateInterpolator();
  private static Interpolator sDecelerateInterpolator = new DecelerateInterpolator();
  
  public static Animation createHorizontalAnimation(float paramFloat1, float paramFloat2, long paramLong, boolean paramBoolean)
  {
    return setAnimationParams(new TranslateAnimation(1, paramFloat1, 1, paramFloat2, 2, 0.0F, 2, 0.0F), paramLong, paramBoolean);
  }
  
  public static Animation createVerticalAnimation(float paramFloat1, float paramFloat2, long paramLong, boolean paramBoolean)
  {
    return setAnimationParams(new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, paramFloat1, 1, paramFloat2), paramLong, paramBoolean);
  }
  
  public static Animation setAnimationParams(Animation paramAnimation, long paramLong, boolean paramBoolean)
  {
    paramAnimation.setDuration(paramLong);
    if (paramBoolean)
    {
      paramAnimation.setInterpolator(sAccelerateInterpolator);
      return paramAnimation;
    }
    paramAnimation.setInterpolator(sDecelerateInterpolator);
    return paramAnimation;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.support.AnimationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */