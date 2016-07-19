package me.lyft.android.notifications;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.squareup.picasso.RequestCreator;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.studies.PushNotificationAnalytics;
import me.lyft.android.common.Strings;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.logging.L;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.MainActivity;

public class StatusBarNotificationsService
  extends ActivityService
  implements IStatusBarNotificationsService
{
  public static final String CAMPAIGN_ID_KEY = "campaign_id";
  private static final int LIGHTS_OFF_MILLIS = 1000;
  private static final int LIGHTS_ON_MILLIS = 300;
  private static final String NOTIFICATION_SOUND = "android.resource://me.lyft.android/raw/passenger_notification";
  public static final String PUSH_ID_KEY = "push_id";
  final IAppForegroundDetector appForegroundedDetector;
  final DeepLinkManager deepLinkManager;
  final ImageLoader imageLoader;
  final IJsonSerializer jsonSerializer;
  final NotificationManager notificationManager;
  final ILyftPreferences preferences;
  
  @Inject
  public StatusBarNotificationsService(ImageLoader paramImageLoader, NotificationManager paramNotificationManager, ILyftPreferences paramILyftPreferences, IAppForegroundDetector paramIAppForegroundDetector, IJsonSerializer paramIJsonSerializer, DeepLinkManager paramDeepLinkManager)
  {
    imageLoader = paramImageLoader;
    notificationManager = paramNotificationManager;
    preferences = paramILyftPreferences;
    appForegroundedDetector = paramIAppForegroundDetector;
    jsonSerializer = paramIJsonSerializer;
    deepLinkManager = paramDeepLinkManager;
  }
  
  private void addActions(NotificationCompat.Builder paramBuilder, Context paramContext, StatusBarNotification paramStatusBarNotification)
  {
    paramStatusBarNotification = paramStatusBarNotification.getActions().iterator();
    while (paramStatusBarNotification.hasNext())
    {
      QuickAction localQuickAction = (QuickAction)paramStatusBarNotification.next();
      if ((!Strings.isNullOrEmpty(localQuickAction.getDeeplink())) && (deepLinkManager.isSupportedDeepLink(localQuickAction.getDeeplink())))
      {
        Intent localIntent = new Intent(paramContext, MainActivity.class);
        localIntent.setFlags(536870912);
        localIntent.setData(Uri.parse(localQuickAction.getDeeplink()));
        int i = localQuickAction.getDeeplink().hashCode();
        paramBuilder.addAction(0, localQuickAction.getButtonText(), PendingIntent.getActivity(paramContext, i, localIntent, 134217728));
      }
    }
  }
  
  private void addBaseNotificationParams(NotificationCompat.Builder paramBuilder, Context paramContext, StatusBarNotification paramStatusBarNotification)
  {
    paramBuilder.setDefaults(2).setSmallIcon(2130838362).setColor(paramContext.getResources().getColor(2131493004)).setContentTitle(paramStatusBarNotification.getTitle()).setContentText(paramStatusBarNotification.getMessage()).setAutoCancel(true).setLights(paramContext.getResources().getColor(2131493023), 300, 1000).setSound(Uri.parse("android.resource://me.lyft.android/raw/passenger_notification"));
  }
  
  private void addBigTextStyle(NotificationCompat.Builder paramBuilder, Context paramContext, StatusBarNotification paramStatusBarNotification)
  {
    NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
    localBigTextStyle.setBigContentTitle(paramStatusBarNotification.getBigTitle());
    localBigTextStyle.bigText(paramStatusBarNotification.getBigMessage());
    paramBuilder.setStyle(localBigTextStyle);
    if (!Strings.isNullOrEmpty(paramStatusBarNotification.getBigImageUrl())) {}
    try
    {
      paramBuilder.setLargeIcon(imageLoader.load(paramStatusBarNotification.getBigImageUrl()).resize((int)paramContext.getResources().getDimension(17104901), (int)paramContext.getResources().getDimension(17104902)).centerInside().get());
      return;
    }
    catch (IOException paramBuilder)
    {
      L.w(paramBuilder, "StatusBarNotificationsService: unable to load image", new Object[0]);
    }
  }
  
  private void addPendingIntent(NotificationCompat.Builder paramBuilder, Context paramContext, StatusBarNotification paramStatusBarNotification)
  {
    Intent localIntent = new Intent(paramContext, MainActivity.class);
    if (!Strings.isNullOrEmpty(paramStatusBarNotification.getDeepLink())) {
      localIntent.setData(Uri.parse(paramStatusBarNotification.getDeepLink()));
    }
    localIntent.putExtra("push_id", paramStatusBarNotification.getPushId());
    localIntent.putExtra("campaign_id", paramStatusBarNotification.getCampaignId());
    localIntent.setFlags(536870912);
    paramBuilder.setContentIntent(PendingIntent.getActivity(paramContext, 0, localIntent, 134217728));
  }
  
  private boolean messageExpired(StatusBarNotification paramStatusBarNotification)
  {
    return paramStatusBarNotification.getTimestamp() < preferences.getLastPushTimestamp();
  }
  
  private void saveMessageTime(StatusBarNotification paramStatusBarNotification)
  {
    preferences.setLastPushTimestamp(paramStatusBarNotification.getTimestamp());
  }
  
  public void hideMessage(Map<String, String> paramMap)
  {
    paramMap = StatusBarNotificationMapper.createStatusBarNotification(paramMap, jsonSerializer);
    if (messageExpired(paramMap)) {
      return;
    }
    saveMessageTime(paramMap);
    notificationManager.cancel(2);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    notificationManager.cancel(2);
  }
  
  public void showMessage(Context paramContext, Map<String, String> paramMap)
  {
    paramMap = StatusBarNotificationMapper.createStatusBarNotification(paramMap, jsonSerializer);
    if (messageExpired(paramMap)) {}
    do
    {
      return;
      saveMessageTime(paramMap);
    } while (appForegroundedDetector.isForegrounded());
    try
    {
      NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
      addBaseNotificationParams(localBuilder, paramContext, paramMap);
      addPendingIntent(localBuilder, paramContext, paramMap);
      addBigTextStyle(localBuilder, paramContext, paramMap);
      addActions(localBuilder, paramContext, paramMap);
      localBuilder.setVisibility(1);
      notificationManager.cancel(2);
      notificationManager.notify(2, localBuilder.build());
      PushNotificationAnalytics.trackPushDisplayed(paramMap.getPushId(), paramMap.getCampaignId());
      return;
    }
    catch (Exception paramContext)
    {
      L.e(paramContext, "handleMessageEvent", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.notifications.StatusBarNotificationsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */