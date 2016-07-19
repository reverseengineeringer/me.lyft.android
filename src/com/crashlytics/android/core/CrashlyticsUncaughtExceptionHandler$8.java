package com.crashlytics.android.core;

import java.util.concurrent.Callable;

class CrashlyticsUncaughtExceptionHandler$8
  implements Callable<Void>
{
  CrashlyticsUncaughtExceptionHandler$8(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler, String paramString1, String paramString2, String paramString3) {}
  
  public Void call()
    throws Exception
  {
    String str = CrashlyticsUncaughtExceptionHandler.access$500(this$0);
    new MetaDataStore(CrashlyticsUncaughtExceptionHandler.access$600(this$0)).writeUserData(str, new UserMetaData(val$userId, val$userName, val$userEmail));
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */