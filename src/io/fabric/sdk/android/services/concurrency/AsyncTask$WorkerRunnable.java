package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.Callable;

abstract class AsyncTask$WorkerRunnable<Params, Result>
  implements Callable<Result>
{
  Params[] params;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.AsyncTask.WorkerRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */