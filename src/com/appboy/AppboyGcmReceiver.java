package com.appboy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.push.AppboyNotificationActionUtils;
import com.appboy.push.AppboyNotificationUtils;
import com.appboy.support.AppboyLogger;

public final class AppboyGcmReceiver
  extends BroadcastReceiver
{
  public static final String CAMPAIGN_ID_KEY = "cid";
  private static final String GCM_DELETED_MESSAGES_KEY = "deleted_messages";
  private static final String GCM_ERROR_KEY = "error";
  private static final String GCM_MESSAGE_TYPE_KEY = "message_type";
  private static final String GCM_NUMBER_OF_MESSAGES_DELETED_KEY = "total_deleted";
  private static final String GCM_RECEIVE_INTENT_ACTION = "com.google.android.c2dm.intent.RECEIVE";
  private static final String GCM_REGISTRATION_ID_KEY = "registration_id";
  private static final String GCM_REGISTRATION_INTENT_ACTION = "com.google.android.c2dm.intent.REGISTRATION";
  private static final String GCM_UNREGISTERED_KEY = "unregistered";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyGcmReceiver.class.getName() });
  
  boolean handleAppboyGcmMessage(Context paramContext, Intent paramIntent)
  {
    NotificationManagerCompat localNotificationManagerCompat = NotificationManagerCompat.from(paramContext);
    int i;
    if ("deleted_messages".equals(paramIntent.getStringExtra("message_type")))
    {
      i = paramIntent.getIntExtra("total_deleted", -1);
      if (i == -1) {
        Log.e(TAG, String.format("Unable to parse GCM message. Intent: %s", new Object[] { paramIntent.toString() }));
      }
      for (;;)
      {
        return false;
        AppboyLogger.i(TAG, String.format("GCM deleted %d messages. Fetch them from Appboy.", new Object[] { Integer.valueOf(i) }));
      }
    }
    Bundle localBundle1 = paramIntent.getExtras();
    Bundle localBundle2 = AppboyNotificationUtils.getAppboyExtrasWithoutPreprocessing(localBundle1);
    localBundle1.putBundle("extra", localBundle2);
    if (AppboyNotificationUtils.isNotificationMessage(paramIntent))
    {
      i = AppboyNotificationUtils.getNotificationId(localBundle1);
      localBundle1.putInt("nid", i);
      paramIntent = new XmlAppConfigurationProvider(paramContext);
      IAppboyNotificationFactory localIAppboyNotificationFactory = AppboyNotificationUtils.getActiveNotificationFactory();
      try
      {
        paramIntent = localIAppboyNotificationFactory.createNotification(paramIntent, paramContext, localBundle1, localBundle2);
        if (paramIntent == null) {
          return false;
        }
      }
      catch (Exception paramContext)
      {
        Log.e(TAG, "Failed to create notification.", paramContext);
        return false;
      }
      localNotificationManagerCompat.notify("appboy_notification", i, paramIntent);
      AppboyNotificationUtils.sendPushMessageReceivedBroadcast(paramContext, localBundle1);
      AppboyNotificationUtils.wakeScreenIfHasPermission(paramContext, localBundle1);
      if ((localBundle1 != null) && (localBundle1.containsKey("nd")))
      {
        int j = Integer.parseInt(localBundle1.getString("nd"));
        AppboyNotificationUtils.setNotificationDurationAlarm(paramContext, getClass(), i, j);
      }
      return true;
    }
    AppboyNotificationUtils.sendPushMessageReceivedBroadcast(paramContext, localBundle1);
    return false;
  }
  
  void handleAppboyGcmReceiveIntent(Context paramContext, Intent paramIntent)
  {
    if (AppboyNotificationUtils.isAppboyPushMessage(paramIntent)) {
      new HandleAppboyGcmMessageTask(paramContext, paramIntent);
    }
  }
  
  boolean handleRegistrationEventIfEnabled(XmlAppConfigurationProvider paramXmlAppConfigurationProvider, Context paramContext, Intent paramIntent)
  {
    if (paramXmlAppConfigurationProvider.isGcmMessagingRegistrationEnabled())
    {
      handleRegistrationIntent(paramContext, paramIntent);
      return true;
    }
    return false;
  }
  
  boolean handleRegistrationIntent(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("error");
    String str2 = paramIntent.getStringExtra("registration_id");
    if (str1 != null) {
      if ("SERVICE_NOT_AVAILABLE".equals(str1)) {
        Log.e(TAG, "Unable to connect to the GCM registration server. Try again later.");
      }
    }
    for (;;)
    {
      return true;
      if ("ACCOUNT_MISSING".equals(str1))
      {
        Log.e(TAG, "No Google account found on the phone. For pre-3.0 devices, a Google account is required on the device.");
      }
      else if ("AUTHENTICATION_FAILED".equals(str1))
      {
        Log.e(TAG, "Unable to authenticate Google account. For Android versions <4.0.4, a valid Google Play account is required for Google Cloud Messaging to function. This phone will be unable to receive Google Cloud Messages until the user logs in with a valid Google Play account or upgrades the operating system on this device.");
      }
      else if ("INVALID_SENDER".equals(str1))
      {
        Log.e(TAG, "One or multiple of the sender IDs provided are invalid.");
      }
      else if ("PHONE_REGISTRATION_ERROR".equals(str1))
      {
        Log.e(TAG, "Device does not support GCM.");
      }
      else if ("INVALID_PARAMETERS".equals(str1))
      {
        Log.e(TAG, "The request sent by the device does not contain the expected parameters. This phone does not currently support GCM.");
      }
      else
      {
        AppboyLogger.w(TAG, String.format("Received an unrecognised GCM registration error type. Ignoring. Error: %s", new Object[] { str1 }));
        continue;
        if (str2 != null)
        {
          Appboy.getInstance(paramContext).registerAppboyPushMessages(str2);
        }
        else
        {
          if (!paramIntent.hasExtra("unregistered")) {
            break;
          }
          Appboy.getInstance(paramContext).unregisterAppboyPushMessages();
        }
      }
    }
    AppboyLogger.w(TAG, "The GCM registration message is missing error information, registration id, and unregistration confirmation. Ignoring.");
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppboyLogger.i(TAG, String.format("Received broadcast message. Message: %s", new Object[] { paramIntent.toString() }));
    String str = paramIntent.getAction();
    if ("com.google.android.c2dm.intent.REGISTRATION".equals(str))
    {
      handleRegistrationEventIfEnabled(new XmlAppConfigurationProvider(paramContext), paramContext, paramIntent);
      return;
    }
    if ("com.google.android.c2dm.intent.RECEIVE".equals(str))
    {
      handleAppboyGcmReceiveIntent(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.CANCEL_NOTIFICATION".equals(str))
    {
      AppboyNotificationUtils.handleCancelNotificationAction(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.APPBOY_ACTION_CLICKED".equals(str))
    {
      AppboyNotificationActionUtils.handleNotificationActionClicked(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.APPBOY_PUSH_CLICKED".equals(str))
    {
      AppboyNotificationUtils.handleNotificationOpened(paramContext, paramIntent);
      return;
    }
    AppboyLogger.w(TAG, String.format("The GCM receiver received a message not sent from Appboy. Ignoring the message.", new Object[0]));
  }
  
  public class HandleAppboyGcmMessageTask
    extends AsyncTask<Void, Void, Void>
  {
    private final Context context;
    private final Intent intent;
    
    public HandleAppboyGcmMessageTask(Context paramContext, Intent paramIntent)
    {
      context = paramContext;
      intent = paramIntent;
      execute(new Void[0]);
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      handleAppboyGcmMessage(context, intent);
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.AppboyGcmReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */