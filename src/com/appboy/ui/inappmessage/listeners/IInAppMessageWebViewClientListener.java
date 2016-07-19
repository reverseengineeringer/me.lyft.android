package com.appboy.ui.inappmessage.listeners;

import android.os.Bundle;
import com.appboy.models.IInAppMessage;

public abstract interface IInAppMessageWebViewClientListener
{
  public abstract void onCloseAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract void onCustomEventAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract void onNewsfeedAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract void onOtherUrlAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.IInAppMessageWebViewClientListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */