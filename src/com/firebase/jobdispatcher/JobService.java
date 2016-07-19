package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class JobService
  extends Service
{
  static final String ACTION_EXECUTE = "com.firebase.jobdispatcher.ACTION_EXECUTE";
  public static final int RESULT_FAIL_NORETRY = 2;
  public static final int RESULT_FAIL_RETRY = 1;
  public static final int RESULT_SUCCESS = 0;
  static final String TAG = "FJD.JobService";
  private LocalBinder binder = new LocalBinder();
  private final SimpleArrayMap<String, JobCallback> runningJobs = new SimpleArrayMap(1);
  
  protected final void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final void jobFinished(JobParameters paramJobParameters, boolean paramBoolean)
  {
    if (paramJobParameters == null)
    {
      Log.e("FJD.JobService", "jobFinished called with a null JobParameters");
      return;
    }
    for (;;)
    {
      synchronized (runningJobs)
      {
        paramJobParameters = (JobCallback)runningJobs.remove(paramJobParameters.getTag());
        if (paramJobParameters == null) {
          break;
        }
        if (paramBoolean)
        {
          i = 1;
          paramJobParameters.sendResult(i);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return binder;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public final void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
  }
  
  public final void onStart(Intent paramIntent, int paramInt) {}
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    stopSelf(paramInt2);
    return 2;
  }
  
  public abstract boolean onStartJob(JobParameters paramJobParameters);
  
  public abstract boolean onStopJob(JobParameters paramJobParameters);
  
  public final void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    for (;;)
    {
      int i;
      synchronized (runningJobs)
      {
        i = runningJobs.size() - 1;
        if (i >= 0)
        {
          JobCallback localJobCallback = (JobCallback)runningJobs.get(runningJobs.keyAt(i));
          if (localJobCallback != null)
          {
            if (!onStopJob(jobParameters)) {
              break label93;
            }
            j = 1;
            localJobCallback.sendResult(j);
          }
        }
        else
        {
          return super.onUnbind(paramIntent);
        }
      }
      i -= 1;
      continue;
      label93:
      int j = 2;
    }
  }
  
  final void start(JobParameters paramJobParameters, Message arg2)
  {
    synchronized (runningJobs)
    {
      runningJobs.put(paramJobParameters.getTag(), new JobCallback(paramJobParameters, ???, null));
      if (onStartJob(paramJobParameters)) {}
    }
    synchronized (runningJobs)
    {
      ((JobCallback)runningJobs.remove(paramJobParameters.getTag())).sendResult(0);
      return;
      paramJobParameters = finally;
      throw paramJobParameters;
    }
  }
  
  private static final class JobCallback
  {
    public final JobParameters jobParameters;
    public final Message message;
    
    private JobCallback(JobParameters paramJobParameters, Message paramMessage)
    {
      jobParameters = paramJobParameters;
      message = paramMessage;
    }
    
    void sendResult(int paramInt)
    {
      message.arg1 = paramInt;
      message.sendToTarget();
    }
  }
  
  class LocalBinder
    extends Binder
  {
    LocalBinder() {}
    
    JobService getService()
    {
      return JobService.this;
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.JobService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */