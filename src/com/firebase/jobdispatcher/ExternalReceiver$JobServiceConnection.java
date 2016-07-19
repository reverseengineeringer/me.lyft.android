package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

class ExternalReceiver$JobServiceConnection
  implements ServiceConnection
{
  private JobService.LocalBinder binder;
  private boolean isBound = false;
  private final SimpleArrayMap<JobParameters, Integer> jobSpecs = new SimpleArrayMap(1);
  private final Message message;
  
  private ExternalReceiver$JobServiceConnection(JobParameters paramJobParameters, Message paramMessage)
  {
    message = paramMessage;
    jobSpecs.put(paramJobParameters, Integer.valueOf(1));
  }
  
  public void onJobFinished(JobParameters paramJobParameters)
  {
    synchronized (jobSpecs)
    {
      jobSpecs.remove(paramJobParameters);
      return;
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (!(paramIBinder instanceof JobService.LocalBinder))
    {
      Log.w("FJD.ExternalReceiver", "Unknown service connected");
      return;
    }
    isBound = true;
    binder = ((JobService.LocalBinder)paramIBinder);
    paramIBinder = binder.getService();
    paramComponentName = jobSpecs;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < jobSpecs.size())
        {
          JobParameters localJobParameters = (JobParameters)jobSpecs.keyAt(i);
          if (((Integer)jobSpecs.get(localJobParameters)).intValue() == 1)
          {
            Message localMessage = Message.obtain(message);
            obj = localJobParameters;
            paramIBinder.start(localJobParameters, localMessage);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    binder = null;
    isBound = false;
  }
  
  public boolean shouldDie()
  {
    synchronized (jobSpecs)
    {
      boolean bool = jobSpecs.isEmpty();
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.ExternalReceiver.JobServiceConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */