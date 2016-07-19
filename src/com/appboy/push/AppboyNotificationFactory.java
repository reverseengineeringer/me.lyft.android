package com.appboy.push;

import android.app.Notification;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.appboy.IAppboyNotificationFactory;
import com.appboy.configuration.XmlAppConfigurationProvider;

public class AppboyNotificationFactory
  implements IAppboyNotificationFactory
{
  private static volatile AppboyNotificationFactory sInstance = null;
  
  public static AppboyNotificationFactory getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new AppboyNotificationFactory();
      }
      return sInstance;
    }
    finally {}
  }
  
  public Notification createNotification(XmlAppConfigurationProvider paramXmlAppConfigurationProvider, Context paramContext, Bundle paramBundle1, Bundle paramBundle2)
  {
    boolean bool1 = true;
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext).setAutoCancel(true);
    AppboyNotificationUtils.setTitleIfPresent(localBuilder, paramBundle1);
    AppboyNotificationUtils.setContentIfPresent(localBuilder, paramBundle1);
    AppboyNotificationUtils.setTickerIfPresent(localBuilder, paramBundle1);
    AppboyNotificationUtils.setContentIntentIfPresent(paramContext, localBuilder, paramBundle1);
    int i = AppboyNotificationUtils.setSmallIcon(paramXmlAppConfigurationProvider, localBuilder);
    boolean bool2 = AppboyNotificationUtils.setLargeIconIfPresentAndSupported(paramContext, paramXmlAppConfigurationProvider, localBuilder, paramBundle1);
    AppboyNotificationUtils.setSoundIfPresentAndSupported(localBuilder, paramBundle1);
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 16))
    {
      if (!bool2) {}
      for (;;)
      {
        RemoteViews localRemoteViews = AppboyNotificationRemoteViewsUtils.createMultiLineContentNotificationView(paramContext, paramBundle1, i, bool1);
        if (localRemoteViews == null) {
          break;
        }
        localBuilder.setContent(localRemoteViews);
        return localBuilder.build();
        bool1 = false;
      }
    }
    AppboyNotificationUtils.setSummaryTextIfPresentAndSupported(localBuilder, paramBundle1);
    AppboyNotificationUtils.setPriorityIfPresentAndSupported(localBuilder, paramBundle1);
    AppboyNotificationUtils.setStyleIfSupported(paramContext, localBuilder, paramBundle1, paramBundle2);
    AppboyNotificationActionUtils.addNotificationActions(paramContext, localBuilder, paramBundle1);
    AppboyNotificationUtils.setAccentColorIfPresentAndSupported(paramXmlAppConfigurationProvider, localBuilder, paramBundle1);
    AppboyNotificationUtils.setCategoryIfPresentAndSupported(localBuilder, paramBundle1);
    AppboyNotificationUtils.setVisibilityIfPresentAndSupported(localBuilder, paramBundle1);
    AppboyNotificationUtils.setPublicVersionIfPresentAndSupported(paramContext, paramXmlAppConfigurationProvider, localBuilder, paramBundle1);
    AppboyWearableNotificationUtils.setWearableNotificationFeaturesIfPresentAndSupported(paramContext, localBuilder, paramBundle1);
    return localBuilder.build();
  }
}

/* Location:
 * Qualified Name:     com.appboy.push.AppboyNotificationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */