package com.appboy;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.push.AppboyNotificationActionUtils;
import com.appboy.push.AppboyNotificationUtils;
import com.appboy.support.AppboyLogger;

public final class AppboyAdmReceiver
  extends BroadcastReceiver
{
  private static final String ADM_DELETED_MESSAGES_KEY = "deleted_messages";
  private static final String ADM_ERROR_KEY = "error";
  private static final String ADM_MESSAGE_TYPE_KEY = "message_type";
  private static final String ADM_NUMBER_OF_MESSAGES_DELETED_KEY = "total_deleted";
  private static final String ADM_RECEIVE_INTENT_ACTION = "com.amazon.device.messaging.intent.RECEIVE";
  private static final String ADM_REGISTRATION_ID_KEY = "registration_id";
  private static final String ADM_REGISTRATION_INTENT_ACTION = "com.amazon.device.messaging.intent.REGISTRATION";
  private static final String ADM_UNREGISTERED_KEY = "unregistered";
  public static final String CAMPAIGN_ID_KEY = "cid";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyAdmReceiver.class.getName() });
  
  boolean handleAppboyAdmMessage(Context paramContext, Intent paramIntent)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    int i;
    if ("deleted_messages".equals(paramIntent.getStringExtra("message_type")))
    {
      i = paramIntent.getIntExtra("total_deleted", -1);
      if (i == -1) {
        AppboyLogger.e(TAG, String.format("Unable to parse ADM message. Intent: %s", new Object[] { paramIntent.toString() }));
      }
      for (;;)
      {
        return false;
        AppboyLogger.i(TAG, String.format("ADM deleted %d messages. Fetch them from Appboy.", new Object[] { Integer.valueOf(i) }));
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
        AppboyLogger.e(TAG, "Failed to create notification.", paramContext);
        return false;
      }
      localNotificationManager.notify("appboy_notification", i, paramIntent);
      AppboyNotificationUtils.sendPushMessageReceivedBroadcast(paramContext, localBundle1);
      AppboyNotificationUtils.wakeScreenIfHasPermission(paramContext, localBundle1);
      if (localBundle1.containsKey("nd"))
      {
        int j = Integer.parseInt(localBundle1.getString("nd"));
        AppboyNotificationUtils.setNotificationDurationAlarm(paramContext, getClass(), i, j);
      }
      return true;
    }
    AppboyNotificationUtils.sendPushMessageReceivedBroadcast(paramContext, localBundle1);
    return false;
  }
  
  void handleAppboyAdmReceiveIntent(Context paramContext, Intent paramIntent)
  {
    if (AppboyNotificationUtils.isAppboyPushMessage(paramIntent)) {
      new HandleAppboyAdmMessageTask(paramContext, paramIntent);
    }
  }
  
  boolean handleRegistrationEventIfEnabled(XmlAppConfigurationProvider paramXmlAppConfigurationProvider, Context paramContext, Intent paramIntent)
  {
    AppboyLogger.i(TAG, String.format("Received ADM registration. Message: %s", new Object[] { paramIntent.toString() }));
    if (paramXmlAppConfigurationProvider.isAdmMessagingRegistrationEnabled())
    {
      AppboyLogger.d(TAG, "ADM enabled in appboy.xml. Continuing to process ADM registration intent.");
      handleRegistrationIntent(paramContext, paramIntent);
      return true;
    }
    AppboyLogger.w(TAG, "ADM not enabled in appboy.xml. Ignoring ADM registration intent. Note: you must set com_appboy_push_adm_messaging_registration_enabled to true in your appboy.xml to enable ADM.");
    return false;
  }
  
  boolean handleRegistrationIntent(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("error");
    String str2 = paramIntent.getStringExtra("registration_id");
    paramIntent = paramIntent.getStringExtra("unregistered");
    if (str1 != null) {
      AppboyLogger.e(TAG, "Error during ADM registration: " + str1);
    }
    for (;;)
    {
      return true;
      if (str2 != null)
      {
        AppboyLogger.i(TAG, "Registering for ADM messages with registrationId: " + str2);
        Appboy.getInstance(paramContext).registerAppboyPushMessages(str2);
      }
      else
      {
        if (paramIntent == null) {
          break;
        }
        AppboyLogger.i(TAG, "Unregistering from ADM: " + paramIntent);
        Appboy.getInstance(paramContext).unregisterAppboyPushMessages();
      }
    }
    AppboyLogger.w(TAG, "The ADM registration intent is missing error information, registration id, and unregistration confirmation. Ignoring.");
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppboyLogger.i(TAG, String.format("Received broadcast message. Message: %s", new Object[] { paramIntent.toString() }));
    String str = paramIntent.getAction();
    if ("com.amazon.device.messaging.intent.REGISTRATION".equals(str))
    {
      handleRegistrationEventIfEnabled(new XmlAppConfigurationProvider(paramContext), paramContext, paramIntent);
      return;
    }
    if ("com.amazon.device.messaging.intent.RECEIVE".equals(str))
    {
      handleAppboyAdmReceiveIntent(paramContext, paramIntent);
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
    AppboyLogger.w(TAG, String.format("The ADM receiver received a message not sent from Appboy. Ignoring the message.", new Object[0]));
  }
  
  public class HandleAppboyAdmMessageTask
    extends AsyncTask<Void, Void, Void>
  {
    private final Context context;
    private final Intent intent;
    
    public HandleAppboyAdmMessageTask(Context paramContext, Intent paramIntent)
    {
      context = paramContext;
      intent = paramIntent;
      execute(new Void[0]);
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      handleAppboyAdmMessage(context, intent);
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.AppboyAdmReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */