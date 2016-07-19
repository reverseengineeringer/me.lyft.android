package com.appboy.ui.inappmessage;

import com.appboy.events.IEventSubscriber;
import com.appboy.events.InAppMessageEvent;
import com.appboy.ui.inappmessage.listeners.IInAppMessageManagerListener;

class AppboyInAppMessageManager$2
  implements IEventSubscriber<InAppMessageEvent>
{
  AppboyInAppMessageManager$2(AppboyInAppMessageManager paramAppboyInAppMessageManager) {}
  
  public void trigger(InAppMessageEvent paramInAppMessageEvent)
  {
    if (this$0.getInAppMessageManagerListener().onInAppMessageReceived(paramInAppMessageEvent.getInAppMessage())) {
      return;
    }
    this$0.addInAppMessage(paramInAppMessageEvent.getInAppMessage());
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyInAppMessageManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */