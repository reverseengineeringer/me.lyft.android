package com.appboy.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Style;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.appboy.Constants;
import com.appboy.support.AppboyImageUtils;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;

public class AppboyNotificationStyleFactory
{
  public static final int BIG_PICTURE_STYLE_IMAGE_HEIGHT = 192;
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyNotificationStyleFactory.class.getName() });
  
  @TargetApi(16)
  public static NotificationCompat.Style getBigNotificationStyle(Context paramContext, Bundle paramBundle1, Bundle paramBundle2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBundle2 != null)
    {
      localObject1 = localObject2;
      if (paramBundle2.containsKey("appboy_image_url")) {
        localObject1 = getBigPictureNotificationStyle(paramContext, paramBundle1, paramBundle2);
      }
    }
    paramContext = (Context)localObject1;
    if (localObject1 == null)
    {
      AppboyLogger.d(TAG, "Rendering push notification with BigTextStyle");
      paramContext = getBigTextNotificationStyle(paramBundle1);
    }
    return paramContext;
  }
  
  @TargetApi(16)
  public static NotificationCompat.BigPictureStyle getBigPictureNotificationStyle(Context paramContext, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle2 == null) || (!paramBundle2.containsKey("appboy_image_url"))) {
      return null;
    }
    paramBundle2 = paramBundle2.getString("appboy_image_url");
    if (StringUtils.isNullOrBlank(paramBundle2)) {
      return null;
    }
    Bitmap localBitmap = AppboyImageUtils.getBitmap(Uri.parse(paramBundle2));
    if (localBitmap == null) {
      return null;
    }
    paramBundle2 = localBitmap;
    try
    {
      int k;
      int i;
      if (localBitmap.getWidth() > localBitmap.getHeight())
      {
        paramContext = (WindowManager)paramContext.getSystemService("window");
        paramBundle2 = new DisplayMetrics();
        paramContext.getDefaultDisplay().getMetrics(paramBundle2);
        k = AppboyImageUtils.getPixelsFromDensityAndDp(densityDpi, 192);
        int j = k * 2;
        i = j;
        if (j > widthPixels) {
          i = widthPixels;
        }
      }
      try
      {
        paramBundle2 = Bitmap.createScaledBitmap(localBitmap, i, k, true);
        if (paramBundle2 == null)
        {
          AppboyLogger.i(TAG, "Bitmap download failed for push notification. No image will be included with the notification.");
          return null;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          AppboyLogger.e(TAG, "Failed to scale image bitmap, using original.", paramContext);
          paramBundle2 = localBitmap;
        }
      }
      paramContext = new NotificationCompat.BigPictureStyle();
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(TAG, "Failed to create Big Picture Style.", paramContext);
      return null;
    }
    paramContext.bigPicture(paramBundle2);
    setBigPictureSummaryAndTitle(paramContext, paramBundle1);
    return paramContext;
  }
  
  public static NotificationCompat.BigTextStyle getBigTextNotificationStyle(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
      localBigTextStyle.bigText(paramBundle.getString("a"));
      String str1 = null;
      String str2 = null;
      if (paramBundle.containsKey("ab_bs")) {
        str1 = paramBundle.getString("ab_bs");
      }
      if (paramBundle.containsKey("ab_bt")) {
        str2 = paramBundle.getString("ab_bt");
      }
      if (str1 != null) {
        localBigTextStyle.setSummaryText(str1);
      }
      if (str2 != null) {
        localBigTextStyle.setBigContentTitle(str2);
      }
      return localBigTextStyle;
    }
    return null;
  }
  
  static void setBigPictureSummaryAndTitle(NotificationCompat.BigPictureStyle paramBigPictureStyle, Bundle paramBundle)
  {
    String str1 = null;
    String str2 = null;
    if (paramBundle.containsKey("ab_bs")) {
      str1 = paramBundle.getString("ab_bs");
    }
    if (paramBundle.containsKey("ab_bt")) {
      str2 = paramBundle.getString("ab_bt");
    }
    if (str1 != null) {
      paramBigPictureStyle.setSummaryText(str1);
    }
    if (str2 != null) {
      paramBigPictureStyle.setBigContentTitle(str2);
    }
    if ((paramBundle.getString("s") == null) && (str1 == null)) {
      paramBigPictureStyle.setSummaryText(paramBundle.getString("a"));
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.push.AppboyNotificationStyleFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */