package me.lyft.android.services;

import android.animation.Animator;
import android.widget.ImageView;
import com.lyft.widgets.SimpleAnimationListener;

class LyftDriverToggleService$LyftToggleTouchListener$3
  extends SimpleAnimationListener
{
  LyftDriverToggleService$LyftToggleTouchListener$3(LyftDriverToggleService.LyftToggleTouchListener paramLyftToggleTouchListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    LyftDriverToggleService.access$800(this$1.this$0).setEnabled(true);
    LyftDriverToggleService.LyftToggleTouchListener.access$2300(this$1, false);
    LyftDriverToggleService.LyftToggleTouchListener.access$2400(this$1, false);
    if (LyftDriverToggleService.LyftToggleTouchListener.access$2500(this$1))
    {
      LyftDriverToggleService.LyftToggleTouchListener.access$2502(this$1, false);
      LyftDriverToggleService.access$2600(this$1.this$0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    LyftDriverToggleService.access$800(this$1.this$0).setEnabled(false);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.LyftToggleTouchListener.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */