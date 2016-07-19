package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public final class GooglePlayDriver
  implements Driver
{
  private final boolean mAvailable = true;
  private final Context mContext;
  private final PendingIntent mToken;
  private final JobValidator mValidator;
  private final GooglePlayJobWriter mWriter;
  
  public GooglePlayDriver(Context paramContext)
  {
    mContext = paramContext;
    mToken = PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0);
    mWriter = new GooglePlayJobWriter();
    mValidator = new DefaultJobValidator(paramContext);
  }
  
  private Intent createScheduleRequest(JobParameters paramJobParameters)
  {
    Intent localIntent = createSchedulerIntent("SCHEDULE_TASK");
    localIntent.putExtras(mWriter.writeToBundle(paramJobParameters, localIntent.getExtras()));
    return localIntent;
  }
  
  private Intent createSchedulerIntent(String paramString)
  {
    Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
    localIntent.setPackage("com.google.android.gms");
    localIntent.putExtra("scheduler_action", paramString);
    localIntent.putExtra("app", mToken);
    return localIntent;
  }
  
  public JobValidator getValidator()
  {
    return mValidator;
  }
  
  public boolean isAvailable()
  {
    return true;
  }
  
  public int schedule(Job paramJob)
  {
    mContext.sendBroadcast(createScheduleRequest(paramJob));
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.GooglePlayDriver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */