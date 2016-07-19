package com.appboy.ui.inappmessage;

import com.appboy.models.IInAppMessage;

class AppboyInAppMessageManager$1
  implements Runnable
{
  AppboyInAppMessageManager$1(AppboyInAppMessageManager paramAppboyInAppMessageManager, IInAppMessage paramIInAppMessage) {}
  
  public void run()
  {
    new AppboyAsyncInAppMessageDisplayer().execute(new IInAppMessage[] { val$inAppMessage });
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyInAppMessageManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */