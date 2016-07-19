package com.appboy.ui.inappmessage;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.appboy.ui.support.ViewUtils;

class InAppMessageViewWrapper$9
  implements Animation.AnimationListener
{
  InAppMessageViewWrapper$9(InAppMessageViewWrapper paramInAppMessageViewWrapper) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    InAppMessageViewWrapper.access$100(this$0).clearAnimation();
    InAppMessageViewWrapper.access$100(this$0).setVisibility(8);
    ViewUtils.removeViewFromParent(InAppMessageViewWrapper.access$100(this$0));
    InAppMessageViewWrapper.access$400(this$0).afterClosed(InAppMessageViewWrapper.access$300(this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */