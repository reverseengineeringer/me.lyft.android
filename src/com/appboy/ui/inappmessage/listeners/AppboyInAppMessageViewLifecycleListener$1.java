package com.appboy.ui.inappmessage.listeners;

import android.app.Activity;
import com.appboy.support.AppboyFileUtils;
import com.appboy.support.WebContentUtils;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;

class AppboyInAppMessageViewLifecycleListener$1
  implements Runnable
{
  AppboyInAppMessageViewLifecycleListener$1(AppboyInAppMessageViewLifecycleListener paramAppboyInAppMessageViewLifecycleListener) {}
  
  public void run()
  {
    Activity localActivity = AppboyInAppMessageManager.getInstance().getActivity();
    if (localActivity != null) {
      AppboyFileUtils.deleteFileOrDirectory(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(localActivity));
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyInAppMessageViewLifecycleListener.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */