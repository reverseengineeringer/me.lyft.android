package com.appboy.ui.inappmessage.listeners;

import com.appboy.models.IInAppMessage;
import com.appboy.models.MessageButton;
import com.appboy.ui.inappmessage.InAppMessageCloser;
import com.appboy.ui.inappmessage.InAppMessageOperation;

public class AppboyDefaultInAppMessageManagerListener
  implements IInAppMessageManagerListener
{
  public InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage paramIInAppMessage)
  {
    return InAppMessageOperation.DISPLAY_NOW;
  }
  
  public boolean onInAppMessageButtonClicked(MessageButton paramMessageButton, InAppMessageCloser paramInAppMessageCloser)
  {
    return false;
  }
  
  public boolean onInAppMessageClicked(IInAppMessage paramIInAppMessage, InAppMessageCloser paramInAppMessageCloser)
  {
    return false;
  }
  
  public void onInAppMessageDismissed(IInAppMessage paramIInAppMessage) {}
  
  @Deprecated
  public boolean onInAppMessageReceived(IInAppMessage paramIInAppMessage)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyDefaultInAppMessageManagerListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */