package com.appboy.ui.inappmessage;

import com.appboy.models.IInAppMessage;
import com.appboy.support.AppboyLogger;

class AppboyAsyncInAppMessageDisplayer$1
  implements Runnable
{
  AppboyAsyncInAppMessageDisplayer$1(AppboyAsyncInAppMessageDisplayer paramAppboyAsyncInAppMessageDisplayer, IInAppMessage paramIInAppMessage) {}
  
  public void run()
  {
    AppboyLogger.d(AppboyAsyncInAppMessageDisplayer.access$000(), "Displaying in-app message.");
    AppboyInAppMessageManager.getInstance().displayInAppMessage(val$inAppMessage);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyAsyncInAppMessageDisplayer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */