package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

abstract class ExternalReceiver
  extends Service
{
  private ResponseHandler responseHandler = new ResponseHandler(this, null);
  private final SimpleArrayMap<String, JobServiceConnection> serviceConnections = new SimpleArrayMap();
  
  private Intent createBindIntent(JobParameters paramJobParameters)
  {
    Intent localIntent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
    localIntent.setClassName(this, paramJobParameters.getService());
    return localIntent;
  }
  
  private void onJobFinishedMessage(JobParameters paramJobParameters, int paramInt)
  {
    JobServiceConnection localJobServiceConnection;
    synchronized (serviceConnections)
    {
      localJobServiceConnection = (JobServiceConnection)serviceConnections.get(paramJobParameters.getService());
      localJobServiceConnection.onJobFinished(paramJobParameters);
      if (localJobServiceConnection.shouldDie()) {
        unbindService(localJobServiceConnection);
      }
    }
    synchronized (serviceConnections)
    {
      serviceConnections.remove(localJobServiceConnection);
      onJobFinished(paramJobParameters, paramInt);
      return;
      paramJobParameters = finally;
      throw paramJobParameters;
    }
  }
  
  protected final boolean executeJob(JobParameters paramJobParameters)
  {
    if (paramJobParameters == null) {
      return false;
    }
    JobServiceConnection localJobServiceConnection = new JobServiceConnection(paramJobParameters, responseHandler.obtainMessage(1), null);
    serviceConnections.put(paramJobParameters.getService(), localJobServiceConnection);
    bindService(createBindIntent(paramJobParameters), localJobServiceConnection, 1);
    return true;
  }
  
  protected abstract void onJobFinished(JobParameters paramJobParameters, int paramInt);
  
  private static class JobServiceConnection
    implements ServiceConnection
  {
    private JobService.LocalBinder binder;
    private boolean isBound = false;
    private final SimpleArrayMap<JobParameters, Integer> jobSpecs = new SimpleArrayMap(1);
    private final Message message;
    
    private JobServiceConnection(JobParameters paramJobParameters, Message paramMessage)
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
  
  private static class ResponseHandler
    extends Handler
  {
    private final ExternalReceiver receiver;
    
    private ResponseHandler(ExternalReceiver paramExternalReceiver)
    {
      receiver = paramExternalReceiver;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown message type received: " + what);
        return;
      }
      if ((obj instanceof JobParameters))
      {
        receiver.onJobFinishedMessage((JobParameters)obj, arg1);
        return;
      }
      Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown obj returned");
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.ExternalReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */