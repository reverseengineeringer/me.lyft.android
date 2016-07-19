package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.Callable;

class CrashlyticsExecutorServiceWrapper$2
  implements Callable<T>
{
  CrashlyticsExecutorServiceWrapper$2(CrashlyticsExecutorServiceWrapper paramCrashlyticsExecutorServiceWrapper, Callable paramCallable) {}
  
  public T call()
    throws Exception
  {
    try
    {
      Object localObject = val$callable.call();
      return (T)localObject;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Failed to execute task.", localException);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsExecutorServiceWrapper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */