package com.crashlytics.android.core;

import java.util.concurrent.Callable;

class CrashlyticsCore$4
  implements Callable<Boolean>
{
  CrashlyticsCore$4(CrashlyticsCore paramCrashlyticsCore) {}
  
  public Boolean call()
    throws Exception
  {
    return Boolean.valueOf(CrashlyticsCore.access$100(this$0).isPresent());
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */