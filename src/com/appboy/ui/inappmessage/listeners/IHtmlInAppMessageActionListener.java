package com.appboy.ui.inappmessage.listeners;

import android.os.Bundle;
import com.appboy.models.IInAppMessage;

public abstract interface IHtmlInAppMessageActionListener
{
  public abstract void onCloseClicked(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract boolean onCustomEventFired(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract boolean onNewsfeedClicked(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract boolean onOtherUrlAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */