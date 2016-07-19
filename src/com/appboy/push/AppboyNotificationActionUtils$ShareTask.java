package com.appboy.push;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.appboy.support.AppboyLogger;

class AppboyNotificationActionUtils$ShareTask
  extends AsyncTask<Intent, Integer, Intent>
{
  private final Context mContext;
  
  public AppboyNotificationActionUtils$ShareTask(Context paramContext)
  {
    mContext = paramContext;
  }
  
  protected Intent doInBackground(Intent... paramVarArgs)
  {
    if (mContext != null) {
      return AppboyNotificationActionUtils.access$000(mContext, paramVarArgs[0]);
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
    AppboyLogger.w(AppboyNotificationActionUtils.access$100(), "Null share intent received.  Not starting share intent.");
  }
}

/* Location:
 * Qualified Name:     com.appboy.push.AppboyNotificationActionUtils.ShareTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */