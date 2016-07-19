package com.crashlytics.android.core;

import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;

class CrashlyticsCore$1
  extends PriorityCallable<Void>
{
  CrashlyticsCore$1(CrashlyticsCore paramCrashlyticsCore) {}
  
  public Void call()
    throws Exception
  {
    return this$0.doInBackground();
  }
  
  public Priority getPriority()
  {
    return Priority.IMMEDIATE;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */