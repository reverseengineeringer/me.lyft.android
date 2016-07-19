package me.lyft.android.services;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager;

class LyftDriverToggleService$LyftToggleTouchListener$2
  implements ValueAnimator.AnimatorUpdateListener
{
  LyftDriverToggleService$LyftToggleTouchListener$2(LyftDriverToggleService.LyftToggleTouchListener paramLyftToggleTouchListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    access$1700this$1.this$0).y = paramValueAnimator.intValue();
    LyftDriverToggleService.access$1900(this$1.this$0).updateViewLayout(LyftDriverToggleService.access$1800(this$1.this$0), LyftDriverToggleService.access$1700(this$1.this$0));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.LyftToggleTouchListener.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */