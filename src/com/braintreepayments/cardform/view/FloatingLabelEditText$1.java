package com.braintreepayments.cardform.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class FloatingLabelEditText$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatingLabelEditText$1(FloatingLabelEditText paramFloatingLabelEditText) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    FloatingLabelEditText.access$002(this$0, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this$0.invalidate();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.FloatingLabelEditText.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */