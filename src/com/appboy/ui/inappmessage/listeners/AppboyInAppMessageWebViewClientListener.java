package com.appboy.ui.inappmessage.listeners;

import android.os.Bundle;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.IAppboyNavigator;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageHtmlFull;
import com.appboy.models.outgoing.AppboyProperties;
import com.appboy.push.AppboyNotificationUtils;
import com.appboy.support.AppboyLogger;
import com.appboy.support.BundleUtils;
import com.appboy.support.StringUtils;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import java.util.Iterator;
import java.util.Set;

public class AppboyInAppMessageWebViewClientListener
  implements IInAppMessageWebViewClientListener
{
  private static final String HTML_IAM_CUSTOM_EVENT_NAME_KEY = "name";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyInAppMessageWebViewClientListener.class.getName() });
  
  private AppboyInAppMessageManager getInAppMessageManager()
  {
    return AppboyInAppMessageManager.getInstance();
  }
  
  private void logHtmlInAppMessageClick(IInAppMessage paramIInAppMessage, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("abButtonId")))
    {
      ((InAppMessageHtmlFull)paramIInAppMessage).logButtonClick(paramBundle.getString("abButtonId"));
      return;
    }
    paramIInAppMessage.logClick();
  }
  
  static String parseCustomEventNameFromQueryBundle(Bundle paramBundle)
  {
    return paramBundle.getString("name");
  }
  
  static AppboyProperties parsePropertiesFromQueryBundle(Bundle paramBundle)
  {
    AppboyProperties localAppboyProperties = new AppboyProperties();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!str1.equals("name"))
      {
        String str2 = AppboyNotificationUtils.bundleOptString(paramBundle, str1, null);
        if (!StringUtils.isNullOrBlank(str2)) {
          localAppboyProperties.addProperty(str1, str2);
        }
      }
    }
    return localAppboyProperties;
  }
  
  public void onCloseAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    AppboyLogger.d(TAG, "IInAppMessageWebViewClientListener.onCloseAction called.");
    logHtmlInAppMessageClick(paramIInAppMessage, paramBundle);
    getInAppMessageManager().hideCurrentInAppMessage(true, true);
    getInAppMessageManager().getHtmlInAppMessageActionListener().onCloseClicked(paramIInAppMessage, paramString, paramBundle);
  }
  
  public void onCustomEventAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    AppboyLogger.d(TAG, "IInAppMessageWebViewClientListener.onCustomEventAction called.");
    if (getInAppMessageManager().getActivity() == null) {}
    do
    {
      AppboyLogger.w(TAG, "Can't perform custom event action because the activity is null.");
      do
      {
        return;
      } while (getInAppMessageManager().getHtmlInAppMessageActionListener().onCustomEventFired(paramIInAppMessage, paramString, paramBundle));
      paramIInAppMessage = parseCustomEventNameFromQueryBundle(paramBundle);
    } while (StringUtils.isNullOrBlank(paramIInAppMessage));
    paramString = parsePropertiesFromQueryBundle(paramBundle);
    Appboy.getInstance(getInAppMessageManager().getActivity()).logCustomEvent(paramIInAppMessage, paramString);
  }
  
  public void onNewsfeedAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    AppboyLogger.d(TAG, "IInAppMessageWebViewClientListener.onNewsfeedAction called.");
    if (getInAppMessageManager().getActivity() == null) {
      AppboyLogger.w(TAG, "Can't perform news feed action because the cached activity is null.");
    }
    do
    {
      return;
      logHtmlInAppMessageClick(paramIInAppMessage, paramBundle);
    } while (getInAppMessageManager().getHtmlInAppMessageActionListener().onNewsfeedClicked(paramIInAppMessage, paramString, paramBundle));
    getInAppMessageManager().hideCurrentInAppMessage(false);
    paramIInAppMessage = BundleUtils.mapToBundle(paramIInAppMessage.getExtras());
    paramIInAppMessage.putAll(paramBundle);
    getInAppMessageManager().getAppboyNavigator().gotoNewsFeed(getInAppMessageManager().getActivity(), paramIInAppMessage);
  }
  
  public void onOtherUrlAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    AppboyLogger.d(TAG, "IInAppMessageWebViewClientListener.onOtherUrlAction called.");
    if (getInAppMessageManager().getActivity() == null) {
      AppboyLogger.w(TAG, "Can't perform other url action because the cached activity is null.");
    }
    for (;;)
    {
      return;
      logHtmlInAppMessageClick(paramIInAppMessage, paramBundle);
      if (!getInAppMessageManager().getHtmlInAppMessageActionListener().onOtherUrlAction(paramIInAppMessage, paramString, paramBundle))
      {
        getInAppMessageManager().hideCurrentInAppMessage(false);
        boolean bool = false;
        if (paramBundle.containsKey("abExternalOpen")) {
          bool = Boolean.parseBoolean(paramBundle.getString("abExternalOpen"));
        }
        if (bool)
        {
          paramIInAppMessage = BundleUtils.mapToBundle(paramIInAppMessage.getExtras());
          paramIInAppMessage.putAll(paramBundle);
        }
        for (paramIInAppMessage = ActionFactory.createViewUriAction(paramString, paramIInAppMessage); paramIInAppMessage != null; paramIInAppMessage = ActionFactory.createUriAction(getInAppMessageManager().getActivity(), paramString))
        {
          paramIInAppMessage.execute(getInAppMessageManager().getActivity());
          return;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyInAppMessageWebViewClientListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */