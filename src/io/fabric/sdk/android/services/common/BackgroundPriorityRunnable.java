package io.fabric.sdk.android.services.common;

import android.os.Process;

public abstract class BackgroundPriorityRunnable
  implements Runnable
{
  protected abstract void onRun();
  
  public final void run()
  {
    Process.setThreadPriority(10);
    onRun();
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.BackgroundPriorityRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */