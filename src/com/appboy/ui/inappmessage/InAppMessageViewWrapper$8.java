package com.appboy.ui.inappmessage;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.appboy.enums.inappmessage.DismissType;
import com.appboy.models.IInAppMessage;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;

class InAppMessageViewWrapper$8
  implements Animation.AnimationListener
{
  InAppMessageViewWrapper$8(InAppMessageViewWrapper paramInAppMessageViewWrapper) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (InAppMessageViewWrapper.access$300(this$0).getDismissType() == DismissType.AUTO_DISMISS) {
      InAppMessageViewWrapper.access$700(this$0);
    }
    AppboyLogger.d(InAppMessageViewWrapper.access$000(), "In-app message animated into view.");
    InAppMessageViewWrapper.access$400(this$0).afterOpened(InAppMessageViewWrapper.access$100(this$0), InAppMessageViewWrapper.access$300(this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */