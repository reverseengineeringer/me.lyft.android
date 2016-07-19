package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

final class ExecutorUtils$2
  extends BackgroundPriorityRunnable
{
  ExecutorUtils$2(String paramString, ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {}
  
  public void onRun()
  {
    try
    {
      Fabric.getLogger().d("Fabric", "Executing shutdown hook for " + val$serviceName);
      val$service.shutdown();
      if (!val$service.awaitTermination(val$terminationTimeout, val$timeUnit))
      {
        Fabric.getLogger().d("Fabric", val$serviceName + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
        val$service.shutdownNow();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Fabric.getLogger().d("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[] { val$serviceName }));
      val$service.shutdownNow();
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.ExecutorUtils.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */