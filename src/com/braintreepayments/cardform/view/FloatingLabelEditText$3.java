package com.braintreepayments.cardform.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class FloatingLabelEditText$3
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatingLabelEditText$3(FloatingLabelEditText paramFloatingLabelEditText) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    FloatingLabelEditText.access$202(this$0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this$0.invalidate();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.FloatingLabelEditText.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */