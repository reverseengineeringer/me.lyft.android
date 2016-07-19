package com.leanplum.messagetemplates;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class e
  implements Animation.AnimationListener
{
  e(BaseMessageDialog paramBaseMessageDialog) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    new Handler().postDelayed(new f(this), 10L);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */