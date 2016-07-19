package com.devicecollector.collectors;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import com.devicecollector.DataCollection;
import java.util.concurrent.TimeoutException;

public abstract class AbstractAsyncCollectorTask
  extends AsyncTask<Void, Void, DataCollection>
{
  protected Activity activity;
  protected DataCollection dc;
  protected Exception errorCause;
  protected SoftErrorCode errorCode;
  protected boolean finished;
  protected CollectorStatusListener lstnr;
  private long timeoutMs;
  protected CollectorEnum type;
  
  public AbstractAsyncCollectorTask(Activity paramActivity, CollectorStatusListener paramCollectorStatusListener, DataCollection paramDataCollection, CollectorEnum paramCollectorEnum, long paramLong)
  {
    activity = paramActivity;
    dc = paramDataCollection;
    lstnr = paramCollectorStatusListener;
    type = paramCollectorEnum;
    if (paramLong < 1000L)
    {
      setTimeoutMs(5000L);
      return;
    }
    setTimeoutMs(paramLong);
  }
  
  void debug(String paramString, Object... paramVarArgs)
  {
    Log.v(getClass().getSimpleName(), "[" + type + "]" + String.format(paramString, paramVarArgs));
  }
  
  protected DataCollection doInBackground(Void... paramVarArgs)
  {
    debug("Starting runner...", new Object[0]);
    if (!finished) {
      run();
    }
    return dc;
  }
  
  protected void endProcess(SoftErrorCode paramSoftErrorCode, Exception paramException)
  {
    debug("end process:" + paramSoftErrorCode, new Object[0]);
    finished = true;
    if (paramSoftErrorCode != null)
    {
      dc.addError(type, paramSoftErrorCode);
      errorCode = paramSoftErrorCode;
      errorCause = paramException;
    }
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public CollectorEnum getCollectorType()
  {
    return type;
  }
  
  public long getTimeoutMs()
  {
    return timeoutMs;
  }
  
  public boolean isFinished()
  {
    return finished;
  }
  
  void notifyListener()
  {
    debug("Notifying listener...", new Object[0]);
    if (lstnr != null)
    {
      if (errorCode != null) {
        break label46;
      }
      lstnr.onCollectorSuccess(type);
    }
    for (;;)
    {
      label46:
      try
      {
        notifyAll();
        return;
      }
      finally {}
      lstnr.onCollectorError(type, errorCode, errorCause);
    }
  }
  
  protected void onPostExecute(DataCollection paramDataCollection)
  {
    debug("Post Execute...", new Object[0]);
    notifyListener();
  }
  
  protected void onPreExecute()
  {
    debug("Pre Execute...", new Object[0]);
    if (lstnr != null) {
      lstnr.onCollectorStart(type);
    }
    finished = false;
  }
  
  protected abstract void run();
  
  public void setTimeoutMs(long paramLong)
  {
    timeoutMs = paramLong;
  }
  
  public void timeout()
  {
    if (!finished)
    {
      debug("Timed out. Cancelling...", new Object[0]);
      endProcess(SoftErrorCode.TIMEOUT, new TimeoutException("Timed out."));
      finished = true;
      cancel(true);
      notifyListener();
      return;
    }
    debug("No need to timeout, already finished", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.AbstractAsyncCollectorTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */