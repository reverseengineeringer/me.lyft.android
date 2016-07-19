package com.appboy.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public class AppboyDataSyncService
  extends IntentService
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyDataSyncService.class.getName() });
  
  public AppboyDataSyncService()
  {
    super(AppboyDataSyncService.class.getName());
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Process.setThreadPriority(10);
    if (paramIntent == null)
    {
      AppboyLogger.w(a, "AppboyDataSyncService received null intent, doing nothing.");
      return;
    }
    paramIntent = paramIntent.getAction();
    if (paramIntent == null)
    {
      AppboyLogger.w(a, "AppboyDataSyncService received intent with null action, doing nothing.");
      return;
    }
    if (paramIntent.contains(getApplicationContext().getPackageName() + ".REQUEST_DATA_SYNC"))
    {
      paramIntent = a;
      Appboy.getInstance(getApplicationContext()).requestImmediateDataFlush();
      return;
    }
    AppboyLogger.w(a, "AppboyDataSyncService received unknown intent, doing nothing.");
  }
}

/* Location:
 * Qualified Name:     com.appboy.services.AppboyDataSyncService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */