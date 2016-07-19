package me.lyft.android.services;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.view.View;

class LyftDriverToggleService$10
  implements ValueAnimator.AnimatorUpdateListener
{
  LyftDriverToggleService$10(LyftDriverToggleService paramLyftDriverToggleService, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      LyftDriverToggleService.access$502(this$0, ((Integer)paramValueAnimator).intValue());
      val$view.getBackground().setAlpha(LyftDriverToggleService.access$500(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */