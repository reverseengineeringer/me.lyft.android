package io.fabric.sdk.android.services.concurrency;

class AsyncTask$SerialExecutor$1
  implements Runnable
{
  AsyncTask$SerialExecutor$1(AsyncTask.SerialExecutor paramSerialExecutor, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      val$r.run();
      return;
    }
    finally
    {
      this$0.scheduleNext();
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.AsyncTask.SerialExecutor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */