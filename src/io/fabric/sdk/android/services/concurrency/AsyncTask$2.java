package io.fabric.sdk.android.services.concurrency;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class AsyncTask$2
  extends AsyncTask.WorkerRunnable<Params, Result>
{
  AsyncTask$2(AsyncTask paramAsyncTask)
  {
    super(null);
  }
  
  public Result call()
    throws Exception
  {
    AsyncTask.access$200(this$0).set(true);
    Process.setThreadPriority(10);
    return (Result)AsyncTask.access$300(this$0, this$0.doInBackground(params));
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.AsyncTask.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */