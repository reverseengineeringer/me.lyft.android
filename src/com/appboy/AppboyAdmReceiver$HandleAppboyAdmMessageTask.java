package com.appboy;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class AppboyAdmReceiver$HandleAppboyAdmMessageTask
  extends AsyncTask<Void, Void, Void>
{
  private final Context context;
  private final Intent intent;
  
  public AppboyAdmReceiver$HandleAppboyAdmMessageTask(AppboyAdmReceiver paramAppboyAdmReceiver, Context paramContext, Intent paramIntent)
  {
    context = paramContext;
    intent = paramIntent;
    execute(new Void[0]);
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    this$0.handleAppboyAdmMessage(context, intent);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.appboy.AppboyAdmReceiver.HandleAppboyAdmMessageTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */