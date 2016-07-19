package com.devicecollector;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import com.devicecollector.collectors.CollectorEnum;
import java.util.EnumSet;

public abstract class AbstractCollectorProcess
  extends AsyncTask<String, Void, Void>
{
  protected Activity activity;
  protected boolean finished = true;
  protected DeviceCollector.StatusListener lstnr;
  protected EnumSet<CollectorEnum> skipList;
  private long timeout = 10000L;
  private boolean timeoutOverridden = false;
  
  public AbstractCollectorProcess(Activity paramActivity, DeviceCollector.StatusListener paramStatusListener, EnumSet<CollectorEnum> paramEnumSet)
  {
    lstnr = paramStatusListener;
    activity = paramActivity;
    skipList = paramEnumSet;
    finished = false;
  }
  
  void debug(String paramString, Object... paramVarArgs)
  {
    String str = getClass().getSimpleName();
    Log.v(str, "[" + str + "]" + String.format(paramString, paramVarArgs));
  }
  
  protected abstract Void doInBackground(String... paramVarArgs);
  
  public long getTimeoutMs()
  {
    return timeout;
  }
  
  public boolean getTimeoutOverridden()
  {
    return timeoutOverridden;
  }
  
  public boolean isFinished()
  {
    return finished;
  }
  
  protected void onPreExecute()
  {
    if (lstnr != null) {
      lstnr.onCollectorStart();
    }
    finished = false;
  }
  
  public void setTimoutMs(long paramLong)
  {
    if (paramLong > 5000L)
    {
      timeout = paramLong;
      timeoutOverridden = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.AbstractCollectorProcess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */