package com.appboy.ui.inappmessage.listeners;

import com.appboy.models.IInAppMessage;
import com.appboy.models.MessageButton;
import com.appboy.ui.inappmessage.InAppMessageCloser;
import com.appboy.ui.inappmessage.InAppMessageOperation;

public abstract interface IInAppMessageManagerListener
{
  public abstract InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage paramIInAppMessage);
  
  public abstract boolean onInAppMessageButtonClicked(MessageButton paramMessageButton, InAppMessageCloser paramInAppMessageCloser);
  
  public abstract boolean onInAppMessageClicked(IInAppMessage paramIInAppMessage, InAppMessageCloser paramInAppMessageCloser);
  
  public abstract void onInAppMessageDismissed(IInAppMessage paramIInAppMessage);
  
  @Deprecated
  public abstract boolean onInAppMessageReceived(IInAppMessage paramIInAppMessage);
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.IInAppMessageManagerListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */