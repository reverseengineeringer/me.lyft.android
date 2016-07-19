package com.appboy.ui.inappmessage;

import android.view.View;
import com.appboy.models.IInAppMessage;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.appboy.ui.inappmessage.listeners.SwipeDismissTouchListener.DismissCallbacks;

class InAppMessageViewWrapper$6
  implements SwipeDismissTouchListener.DismissCallbacks
{
  InAppMessageViewWrapper$6(InAppMessageViewWrapper paramInAppMessageViewWrapper) {}
  
  public boolean canDismiss(Object paramObject)
  {
    return true;
  }
  
  public void onDismiss(View paramView, Object paramObject)
  {
    InAppMessageViewWrapper.access$400(this$0).onDismissed(InAppMessageViewWrapper.access$100(this$0), InAppMessageViewWrapper.access$300(this$0));
    InAppMessageViewWrapper.access$300(this$0).setAnimateOut(false);
    this$0.close();
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */