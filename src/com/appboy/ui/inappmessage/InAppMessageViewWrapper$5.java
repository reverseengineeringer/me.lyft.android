package com.appboy.ui.inappmessage;

import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;

class InAppMessageViewWrapper$5
  implements Runnable
{
  InAppMessageViewWrapper$5(InAppMessageViewWrapper paramInAppMessageViewWrapper) {}
  
  public void run()
  {
    InAppMessageViewWrapper.access$400(this$0).onDismissed(InAppMessageViewWrapper.access$100(this$0), InAppMessageViewWrapper.access$300(this$0));
    this$0.close();
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */