package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

public class TimeBasedFileRollOverRunnable
  implements Runnable
{
  private final Context context;
  private final FileRollOverManager fileRollOverManager;
  
  public TimeBasedFileRollOverRunnable(Context paramContext, FileRollOverManager paramFileRollOverManager)
  {
    context = paramContext;
    fileRollOverManager = paramFileRollOverManager;
  }
  
  public void run()
  {
    try
    {
      CommonUtils.logControlled(context, "Performing time based file roll over.");
      if (!fileRollOverManager.rollFileOver()) {
        fileRollOverManager.cancelTimeBasedFileRollOver();
      }
      return;
    }
    catch (Exception localException)
    {
      CommonUtils.logControlledError(context, "Failed to roll over file", localException);
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */