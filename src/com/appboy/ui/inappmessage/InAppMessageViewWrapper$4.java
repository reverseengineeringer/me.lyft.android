package com.appboy.ui.inappmessage;

import android.view.View;
import android.view.View.OnClickListener;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;

class InAppMessageViewWrapper$4
  implements View.OnClickListener
{
  InAppMessageViewWrapper$4(InAppMessageViewWrapper paramInAppMessageViewWrapper) {}
  
  public void onClick(View paramView)
  {
    InAppMessageViewWrapper.access$400(this$0).onDismissed(InAppMessageViewWrapper.access$100(this$0), InAppMessageViewWrapper.access$300(this$0));
    this$0.close();
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */