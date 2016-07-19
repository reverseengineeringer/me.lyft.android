package com.appboy.ui.inappmessage.listeners;

import android.os.Bundle;
import com.appboy.models.IInAppMessage;

public class AppboyDefaultHtmlInAppMessageActionListener
  implements IHtmlInAppMessageActionListener
{
  public void onCloseClicked(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle) {}
  
  public boolean onCustomEventFired(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    return false;
  }
  
  public boolean onNewsfeedClicked(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    return false;
  }
  
  public boolean onOtherUrlAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyDefaultHtmlInAppMessageActionListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */