package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class AsyncTask$InternalHandler
  extends Handler
{
  public AsyncTask$InternalHandler()
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    AsyncTask.AsyncTaskResult localAsyncTaskResult = (AsyncTask.AsyncTaskResult)obj;
    switch (what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.access$500(task, data[0]);
      return;
    }
    task.onProgressUpdate(data);
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.AsyncTask.InternalHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */