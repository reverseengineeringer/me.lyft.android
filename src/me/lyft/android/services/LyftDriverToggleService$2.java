package me.lyft.android.services;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.widgets.SimpleAnimationListener;
import rx.functions.Action0;

class LyftDriverToggleService$2
  implements Action0
{
  LyftDriverToggleService$2(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  public void call()
  {
    LyftDriverToggleService.access$100(this$0).setVisibility(0);
    LyftDriverToggleService.access$200(this$0).setVisibility(0);
    LyftDriverToggleService.access$300(this$0).setVisibility(0);
    LyftDriverToggleService.access$400(this$0).setVisibility(0);
    if (LyftDriverToggleService.access$500(this$0) != 128) {
      LyftDriverToggleService.access$600(this$0, LyftDriverToggleService.access$100(this$0), LyftDriverToggleService.access$500(this$0), 128);
    }
    if (LyftDriverToggleService.access$700(this$0) != null) {
      LyftDriverToggleService.access$700(this$0).cancel();
    }
    if ((LyftDriverToggleService.access$400(this$0).getVisibility() == 0) && (LyftDriverToggleService.access$800(this$0).getAlpha() > 0.0F)) {
      LyftDriverToggleService.access$702(this$0, LyftDriverToggleService.access$400(this$0).animate().alpha(0.0F).setDuration(325L).setListener(new SimpleAnimationListener()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          LyftDriverToggleService.access$400(this$0).setVisibility(4);
        }
      }));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */