package com.appboy.push;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Action.Builder;
import android.support.v4.app.NotificationCompat.Builder;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.support.AppboyImageUtils;
import com.appboy.support.AppboyLogger;
import com.appboy.support.IntentUtils;
import com.appboy.support.PackageUtils;
import com.appboy.support.PermissionUtils;
import com.appboy.support.StringUtils;

public class AppboyNotificationActionUtils
{
  public static final String DEFAULT_LOCAL_STORAGE_FOLDER = "Shared Photos";
  public static final String IMAGE_MIME_TYPE = "image/*";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyNotificationActionUtils.class.getName() });
  public static final String TEXT_MIME_TYPE = "text/plain";
  
  @TargetApi(16)
  private static void addNotificationAction(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = new Bundle(paramBundle);
    String str = getActionFieldAtIndex(paramInt, paramBundle, "ab_a*_a");
    localBundle.putInt("appboy_action_index", paramInt);
    localBundle.putString("appboy_action_type", str);
    localBundle.putString("appboy_action_id", getActionFieldAtIndex(paramInt, paramBundle, "ab_a*_id"));
    localBundle.putString("appboy_action_uri", getActionFieldAtIndex(paramInt, paramBundle, "ab_a*_uri"));
    localBundle.putBoolean("appboy_is_custom_action", isCustomActionType(str));
    str = getActionFieldAtIndex(paramInt, paramBundle, "ab_a*_ic");
    localBundle.putString("appboy_action_icon", getActionFieldAtIndex(paramInt, paramBundle, "ab_a*_ic"));
    Object localObject = new Intent("com.appboy.action.APPBOY_ACTION_CLICKED").setClass(paramContext, AppboyNotificationUtils.getNotificationReceiverClass());
    ((Intent)localObject).putExtras(localBundle);
    paramBundle = getActionFieldAtIndex(paramInt, paramBundle, "ab_a*_t");
    localObject = PendingIntent.getBroadcast(paramContext, IntentUtils.getRequestCode(), (Intent)localObject, 134217728);
    paramContext = new NotificationCompat.Action.Builder(getIconDrawableResourceId(paramContext, str), paramBundle, (PendingIntent)localObject);
    paramContext.addExtras(new Bundle(localBundle));
    paramBuilder.addAction(paramContext.build());
  }
  
  @TargetApi(16)
  public static void addNotificationActions(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    try
    {
      AppboyLogger.w(TAG, String.format("Notification extras were null. Doing nothing.", new Object[0]));
      return;
    }
    catch (Exception paramContext)
    {
      int i;
      AppboyLogger.e(TAG, "Caught exception while adding notification action buttons.", paramContext);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = 0;
      while (!StringUtils.isNullOrBlank(getActionFieldAtIndex(i, paramBundle, "ab_a*_a")))
      {
        addNotificationAction(paramContext, paramBuilder, paramBundle, i);
        i += 1;
      }
    }
  }
  
  static boolean canShareImage(Context paramContext, Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("appboy_image_url")) && (PermissionUtils.hasPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"));
  }
  
  private static Intent createShareActionIntent(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getExtras();
    paramIntent = new Intent("android.intent.action.SEND");
    paramIntent.putExtra("android.intent.extra.SUBJECT", ((Bundle)localObject1).getString("t"));
    paramIntent.putExtra("android.intent.extra.TEXT", ((Bundle)localObject1).getString("a"));
    Object localObject2 = ((Bundle)localObject1).getBundle("extra");
    if (canShareImage(paramContext, (Bundle)localObject2))
    {
      localObject1 = Long.toString(System.currentTimeMillis());
      localObject2 = AppboyImageUtils.getBitmap(Uri.parse(((Bundle)localObject2).getString("appboy_image_url")));
      paramContext = AppboyImageUtils.storePushBitmapInExternalStorage(paramContext.getApplicationContext(), (Bitmap)localObject2, (String)localObject1, "Shared Photos");
      paramIntent.setType("image/*");
      paramIntent.putExtra("android.intent.extra.STREAM", paramContext);
      paramIntent.addFlags(1);
    }
    for (;;)
    {
      paramIntent.setFlags(268435456);
      return paramIntent;
      paramIntent.setType("text/plain");
    }
  }
  
  static String getActionFieldAtIndex(int paramInt, Bundle paramBundle, String paramString)
  {
    paramString = paramBundle.getString(paramString.replace("*", String.valueOf(paramInt)));
    paramBundle = paramString;
    if (paramString == null) {
      paramBundle = "";
    }
    return paramBundle;
  }
  
  static int getIconDrawableResourceId(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    while (StringUtils.isNullOrBlank(paramString)) {
      return 0;
    }
    return paramContext.getResources().getIdentifier(paramString, "drawable", PackageUtils.getResourcePackageName(paramContext));
  }
  
  @TargetApi(16)
  public static void handleNotificationActionClicked(Context paramContext, Intent paramIntent)
  {
    String str;
    int i;
    for (;;)
    {
      try
      {
        str = paramIntent.getStringExtra("appboy_action_type");
        if (StringUtils.isNullOrBlank(str))
        {
          AppboyLogger.w(TAG, String.format("Notification action button type was blank or null.  Doing nothing.", new Object[0]));
          return;
        }
        i = paramIntent.getIntExtra("nid", -1);
        if (!str.equals("ab_none")) {
          logNotificationActionClicked(paramContext, paramIntent);
        }
        if ((!str.equals("ab_uri")) && (!str.equals("ab_open"))) {
          break;
        }
        AppboyNotificationUtils.cancelNotification(paramContext, i);
        paramContext.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        if ((str.equals("ab_uri")) && (paramIntent.getExtras().containsKey("appboy_action_uri")))
        {
          paramIntent.putExtra("uri", paramIntent.getStringExtra("appboy_action_uri"));
          AppboyNotificationUtils.sendNotificationOpenedBroadcast(paramContext, paramIntent);
          return;
        }
      }
      catch (Exception paramContext)
      {
        AppboyLogger.e(TAG, "Caught exception while handling notification action button click.", paramContext);
        return;
      }
      paramIntent.removeExtra("uri");
    }
    if (str.equals("ab_share"))
    {
      AppboyNotificationUtils.cancelNotification(paramContext, i);
      paramContext.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
      handleShareActionClicked(paramContext, paramIntent);
      return;
    }
    if (str.equals("ab_none"))
    {
      AppboyNotificationUtils.cancelNotification(paramContext, i);
      return;
    }
    AppboyLogger.i(TAG, String.format("Custom notification action button clicked. Doing nothing and passing on data to client receiver.", new Object[0]));
    AppboyNotificationUtils.sendNotificationOpenedBroadcast(paramContext, paramIntent);
  }
  
  private static void handleShareActionClicked(Context paramContext, Intent paramIntent)
  {
    new ShareTask(paramContext).execute(new Intent[] { paramIntent });
  }
  
  static boolean isCustomActionType(String paramString)
  {
    if (paramString.equals("ab_uri")) {}
    while ((paramString.equals("ab_open")) || (paramString.equals("ab_none")) || (paramString.equals("ab_share"))) {
      return false;
    }
    return true;
  }
  
  private static void logNotificationActionClicked(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("cid");
    paramIntent = paramIntent.getStringExtra("appboy_action_id");
    if (StringUtils.isNullOrBlank(str))
    {
      AppboyLogger.i(TAG, String.format("No campaign Id associated with this notification.  Not logging push action click to Appboy.", new Object[0]));
      return;
    }
    if (StringUtils.isNullOrBlank(paramIntent))
    {
      AppboyLogger.i(TAG, String.format("No action button Id associated with this notification action.  Not logging push action click to Appboy.", new Object[0]));
      return;
    }
    AppboyLogger.i(TAG, String.format("Logging push action click to Appboy. Campaign Id: " + str + " Action Button Id: " + paramIntent, new Object[0]));
    Appboy.getInstance(paramContext).logPushNotificationActionClicked(str, paramIntent);
  }
  
  private static class ShareTask
    extends AsyncTask<Intent, Integer, Intent>
  {
    private final Context mContext;
    
    public ShareTask(Context paramContext)
    {
      mContext = paramContext;
    }
    
    protected Intent doInBackground(Intent... paramVarArgs)
    {
      if (mContext != null) {
        return AppboyNotificationActionUtils.createShareActionIntent(mContext, paramVarArgs[0]);
      }
      return null;
    }
    
    protected void onPostExecute(Intent paramIntent)
    {
      if (mContext != null)
      {
        if (paramIntent != null) {
          mContext.startActivity(paramIntent);
        }
      }
      else {
        return;
      }
      AppboyLogger.w(AppboyNotificationActionUtils.TAG, "Null share intent received.  Not starting share intent.");
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.push.AppboyNotificationActionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */