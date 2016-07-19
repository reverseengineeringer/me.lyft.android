package me.lyft.android.infrastructure.appboy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.appboy.push.AppboyNotificationUtils;
import javax.inject.Inject;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.studies.PushNotificationAnalytics;
import me.lyft.android.common.UriParser;
import me.lyft.android.infrastructure.gcm.IGcmIdService;
import me.lyft.android.logging.L;
import me.lyft.android.ui.MainActivity;

public class AppboyBroadcastReceiver
  extends BroadcastReceiver
{
  @Inject
  IGcmIdService gcmIdService;
  
  private Intent getLyftDeepLinkIntent(Context paramContext, Bundle paramBundle, String paramString)
  {
    paramContext = getStartMainActivityIntent(paramContext, paramBundle);
    if (paramString != null) {
      paramContext.setData(Uri.parse(paramString));
    }
    return paramContext;
  }
  
  private Bundle getPushExtrasBundle(Intent paramIntent)
  {
    Bundle localBundle2 = paramIntent.getBundleExtra("extra");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putString("cid", paramIntent.getStringExtra("cid"));
    return localBundle1;
  }
  
  private Intent getStartMainActivityIntent(Context paramContext, Bundle paramBundle)
  {
    paramContext = new Intent(paramContext, MainActivity.class);
    paramContext.setFlags(872415232);
    if (paramBundle != null) {
      paramContext.putExtras(paramBundle);
    }
    return paramContext;
  }
  
  private Intent getWebDeepLinkIntent(Bundle paramBundle, String paramString)
  {
    return new Intent("android.intent.action.VIEW", Uri.parse(paramString)).putExtras(paramBundle).setFlags(872415232);
  }
  
  private void handleNotificationOpened(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = getPushExtrasBundle(paramIntent);
    paramIntent = paramIntent.getStringExtra("uri");
    if ((paramIntent != null) && (UriParser.isWebUri(paramIntent)))
    {
      paramContext.startActivity(getWebDeepLinkIntent(localBundle, paramIntent));
      return;
    }
    paramContext.startActivity(getLyftDeepLinkIntent(paramContext, localBundle, paramIntent));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LyftApplication.from(paramContext).inject(this);
    String str2 = paramContext.getPackageName();
    String str1 = str2 + ".intent.APPBOY_PUSH_RECEIVED";
    str2 = str2 + ".intent.APPBOY_NOTIFICATION_OPENED";
    String str3 = paramIntent.getAction();
    L.d("AppboyBroadcastReceiver received an intent with action: " + str3, new Object[0]);
    if (str1.equals(str3))
    {
      L.d("AppboyBroadcastReceiver Received push notification.", new Object[0]);
      if (AppboyNotificationUtils.isNotificationMessage(paramIntent)) {
        PushNotificationAnalytics.trackAppboyPushDisplayed();
      }
      if (AppboyNotificationUtils.isUninstallTrackingPush(paramIntent.getExtras()))
      {
        L.d("AppboyBroadcastReceiver got uninstall tracking push", new Object[0]);
        PushNotificationAnalytics.trackAppboyUninstallTrackingPush();
      }
      return;
    }
    if (str2.equals(str3))
    {
      PushNotificationAnalytics.trackAppboyPushTapped(gcmIdService.getToken());
      handleNotificationOpened(paramContext, paramIntent);
      return;
    }
    L.d("AppboyBroadcastReceiver : " + String.format("Ignoring intent with unsupported action %s", new Object[] { str3 }), new Object[0]);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.AppboyBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */