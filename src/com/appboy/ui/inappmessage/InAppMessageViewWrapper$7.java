package com.appboy.ui.inappmessage;

import android.view.View;
import com.appboy.enums.inappmessage.DismissType;
import com.appboy.models.IInAppMessage;
import com.appboy.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener.ITouchListener;

class InAppMessageViewWrapper$7
  implements TouchAwareSwipeDismissTouchListener.ITouchListener
{
  InAppMessageViewWrapper$7(InAppMessageViewWrapper paramInAppMessageViewWrapper) {}
  
  public void onTouchEnded()
  {
    if (InAppMessageViewWrapper.access$300(this$0).getDismissType() == DismissType.AUTO_DISMISS) {
      InAppMessageViewWrapper.access$700(this$0);
    }
  }
  
  public void onTouchStartedOrContinued()
  {
    InAppMessageViewWrapper.access$100(this$0).removeCallbacks(InAppMessageViewWrapper.access$600(this$0));
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */