package com.appboy.ui.inappmessage;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.appboy.models.IInAppMessage;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.appboy.ui.inappmessage.listeners.SimpleSwipeDismissTouchListener;
import com.appboy.ui.support.AnimationUtils;

class InAppMessageViewWrapper$10
  extends SimpleSwipeDismissTouchListener
{
  private final long sSwipeAnimationDurationMillis = 400L;
  
  InAppMessageViewWrapper$10(InAppMessageViewWrapper paramInAppMessageViewWrapper, Context paramContext)
  {
    super(paramContext);
  }
  
  private void animateAndClose(Animation paramAnimation)
  {
    InAppMessageViewWrapper.access$400(this$0).onDismissed(InAppMessageViewWrapper.access$100(this$0), InAppMessageViewWrapper.access$300(this$0));
    InAppMessageViewWrapper.access$100(this$0).clearAnimation();
    InAppMessageViewWrapper.access$100(this$0).setAnimation(paramAnimation);
    paramAnimation.startNow();
    InAppMessageViewWrapper.access$100(this$0).invalidate();
    InAppMessageViewWrapper.access$300(this$0).setAnimateOut(false);
    this$0.close();
  }
  
  public void onSwipeLeft()
  {
    animateAndClose(AnimationUtils.createHorizontalAnimation(0.0F, -1.0F, 400L, false));
  }
  
  public void onSwipeRight()
  {
    animateAndClose(AnimationUtils.createHorizontalAnimation(0.0F, 1.0F, 400L, false));
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */