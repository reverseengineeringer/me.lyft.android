package com.crashlytics.android.core;

import java.util.Map;
import java.util.concurrent.Callable;

class CrashlyticsUncaughtExceptionHandler$9
  implements Callable<Void>
{
  CrashlyticsUncaughtExceptionHandler$9(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler, Map paramMap) {}
  
  public Void call()
    throws Exception
  {
    String str = CrashlyticsUncaughtExceptionHandler.access$500(this$0);
    new MetaDataStore(CrashlyticsUncaughtExceptionHandler.access$600(this$0)).writeKeyData(str, val$keyData);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */