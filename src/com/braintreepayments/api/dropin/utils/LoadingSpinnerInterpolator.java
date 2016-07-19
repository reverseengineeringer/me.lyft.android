package com.braintreepayments.api.dropin.utils;

import android.view.animation.Interpolator;

public class LoadingSpinnerInterpolator
  implements Interpolator
{
  private static final float A_X = 1.8699999F;
  private static final float A_Y = -1.865F;
  private static final float B_X = -2.8049998F;
  private static final float B_Y = 2.73F;
  private static final float C_X = 1.935F;
  private static final float C_Y = 0.135F;
  private static final float END_X = 0.355F;
  private static final float END_Y = 1.0F;
  private static final float START_X = 0.645F;
  private static final float START_Y = 0.045F;
  
  private float getBezierCoordinateX(float paramFloat)
  {
    return (1.935F + (-2.8049998F + 1.8699999F * paramFloat) * paramFloat) * paramFloat;
  }
  
  private float getXDerivate(float paramFloat)
  {
    return 1.935F + (-5.6099997F + 5.6099997F * paramFloat) * paramFloat;
  }
  
  private float getXForTime(float paramFloat)
  {
    float f1 = paramFloat;
    int i = 1;
    for (;;)
    {
      float f2;
      if (i < 14)
      {
        f2 = getBezierCoordinateX(f1) - paramFloat;
        if (Math.abs(f2) >= 0.001D) {}
      }
      else
      {
        return f1;
      }
      f1 -= f2 / getXDerivate(f1);
      i += 1;
    }
  }
  
  protected float getBezierCoordinateY(float paramFloat)
  {
    return (0.135F + (2.73F + -1.865F * paramFloat) * paramFloat) * paramFloat;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return getBezierCoordinateY(getXForTime(paramFloat));
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.utils.LoadingSpinnerInterpolator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */