package com.appboy.push;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.WearableExtender;
import com.appboy.Constants;
import com.appboy.support.AppboyImageUtils;
import com.appboy.support.AppboyLogger;

public class AppboyWearableNotificationUtils
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyWearableNotificationUtils.class.getName() });
  
  private static boolean isWearExtraPagePresentInBundle(Bundle paramBundle, int paramInt)
  {
    String str1 = "ab_we_t" + paramInt;
    String str2 = "ab_we_c" + paramInt;
    return (paramBundle.containsKey(str1)) && (paramBundle.containsKey(str2));
  }
  
  public static void setWearableNotificationFeaturesIfPresentAndSupported(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    NotificationCompat.WearableExtender localWearableExtender;
    Object localObject;
    int i;
    if (paramBundle != null)
    {
      localWearableExtender = new NotificationCompat.WearableExtender();
      if (paramBundle.containsKey("ab_wi")) {
        localWearableExtender.setHintHideIcon(Boolean.valueOf(Boolean.parseBoolean(paramBundle.getString("ab_wi"))).booleanValue());
      }
      if (paramBundle.containsKey("ab_wb"))
      {
        localObject = AppboyImageUtils.getBitmap(Uri.parse(paramBundle.getString("ab_wb")));
        if (localObject != null) {
          localWearableExtender.setBackground((Bitmap)localObject);
        }
      }
      i = 0;
    }
    for (;;)
    {
      String str;
      if (isWearExtraPagePresentInBundle(paramBundle, i))
      {
        localObject = paramBundle.getString("ab_we_t" + i);
        str = paramBundle.getString("ab_we_c" + i);
        if ((str == null) || (localObject == null)) {
          AppboyLogger.d(TAG, String.format("The title or content of extra page %s was null. Adding no further extra pages.", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        paramBuilder.extend(localWearableExtender);
        return;
      }
      NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
      localBigTextStyle.bigText(str);
      localWearableExtender.addPage(new NotificationCompat.Builder(paramContext).setContentTitle((CharSequence)localObject).setStyle(localBigTextStyle).build());
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.push.AppboyWearableNotificationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */