package com.appboy.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.RemoteViews;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.PackageUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppboyNotificationRemoteViewsUtils
{
  public static final String APPBOY_NOTIFICATION_CONTENT_ID = "com_appboy_notification_content";
  public static final String APPBOY_NOTIFICATION_ICON_ID = "com_appboy_notification_icon";
  public static final String APPBOY_NOTIFICATION_ID = "com_appboy_notification";
  public static final String APPBOY_NOTIFICATION_ID_NO_ICON = "com_appboy_notification_no_icon";
  public static final String APPBOY_NOTIFICATION_TIME_ID = "com_appboy_notification_time";
  public static final String APPBOY_NOTIFICATION_TITLE_ID = "com_appboy_notification_title";
  public static final String APPBOY_NOTIFICATION_TWELVE_HOUR_FORTMAT_ID = "com_appboy_notification_time_twelve_hour_format";
  public static final String APPBOY_NOTIFICATION_TWENTY_FOUR_HOUR_FORMAT_ID = "com_appboy_notification_time_twenty_four_hour_format";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyNotificationRemoteViewsUtils.class.getName() });
  
  @TargetApi(11)
  public static RemoteViews createMultiLineContentNotificationView(Context paramContext, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    String str3;
    String str4;
    String str1;
    if (paramBundle != null)
    {
      str3 = paramBundle.getString("t");
      str4 = paramBundle.getString("a");
      paramBundle = paramContext.getResources();
      str1 = PackageUtils.getResourcePackageName(paramContext);
      if (!paramBoolean) {
        break label222;
      }
    }
    int j;
    int k;
    int m;
    int n;
    String str2;
    label222:
    for (int i = paramBundle.getIdentifier("com_appboy_notification", "layout", str1);; i = paramBundle.getIdentifier("com_appboy_notification_no_icon", "layout", str1))
    {
      j = paramBundle.getIdentifier("com_appboy_notification_title", "id", str1);
      k = paramBundle.getIdentifier("com_appboy_notification_content", "id", str1);
      m = paramBundle.getIdentifier("com_appboy_notification_icon", "id", str1);
      n = paramBundle.getIdentifier("com_appboy_notification_time", "id", str1);
      int i1 = paramBundle.getIdentifier("com_appboy_notification_time_twenty_four_hour_format", "string", str1);
      int i2 = paramBundle.getIdentifier("com_appboy_notification_time_twelve_hour_format", "string", str1);
      str1 = AppboyNotificationUtils.getOptionalStringResource(paramBundle, i1, "HH:mm");
      str2 = AppboyNotificationUtils.getOptionalStringResource(paramBundle, i2, "h:mm a");
      if ((i != 0) && (j != 0) && (k != 0) && (m != 0) && (n != 0)) {
        break;
      }
      AppboyLogger.w(TAG, String.format("Couldn't find all resource IDs for custom notification view, extended view will not be used for push notifications. Received %d for layout, %d for title, %d for content, %d for icon, and %d for time.", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
      return null;
    }
    AppboyLogger.d(TAG, "Using RemoteViews for rendering of push notification.");
    try
    {
      paramBundle = new RemoteViews(PackageUtils.getResourcePackageName(paramContext), i);
      paramBundle.setTextViewText(j, str3);
      paramBundle.setTextViewText(k, str4);
      if (paramBoolean) {
        paramBundle.setImageViewResource(m, paramInt);
      }
      if (DateFormat.is24HourFormat(paramContext))
      {
        paramContext = str1;
        paramBundle.setTextViewText(n, new SimpleDateFormat(paramContext).format(new Date()));
        return paramBundle;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        AppboyLogger.e(TAG, String.format("Failed to initialize remote views with package %s", new Object[] { PackageUtils.getResourcePackageName(paramContext) }), paramBundle);
        try
        {
          paramBundle = new RemoteViews(paramContext.getPackageName(), i);
        }
        catch (Exception paramBundle)
        {
          AppboyLogger.e(TAG, String.format("Failed to initialize remote views with package %s", new Object[] { paramContext.getPackageName() }), paramBundle);
          return null;
        }
        paramContext = str2;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.push.AppboyNotificationRemoteViewsUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */