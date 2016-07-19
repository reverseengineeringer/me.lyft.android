package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler$11
  implements Callable<Boolean>
{
  CrashlyticsUncaughtExceptionHandler$11(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler) {}
  
  public Boolean call()
    throws Exception
  {
    if (CrashlyticsUncaughtExceptionHandler.access$200(this$0).get())
    {
      Fabric.getLogger().d("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
      return Boolean.FALSE;
    }
    Fabric.getLogger().d("CrashlyticsCore", "Finalizing previously open sessions.");
    SessionEventData localSessionEventData = CrashlyticsUncaughtExceptionHandler.access$800(this$0).getExternalCrashEventData();
    if (localSessionEventData != null) {
      CrashlyticsUncaughtExceptionHandler.access$900(this$0, localSessionEventData);
    }
    CrashlyticsUncaughtExceptionHandler.access$1000(this$0, true);
    Fabric.getLogger().d("CrashlyticsCore", "Closed all previously open sessions");
    return Boolean.TRUE;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */