package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.Callable;

class CrashlyticsCore$3
  implements Callable<Boolean>
{
  CrashlyticsCore$3(CrashlyticsCore paramCrashlyticsCore) {}
  
  public Boolean call()
    throws Exception
  {
    try
    {
      boolean bool = CrashlyticsCore.access$100(this$0).remove();
      Fabric.getLogger().d("CrashlyticsCore", "Initialization marker file removed: " + bool);
      return Boolean.valueOf(bool);
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", localException);
    }
    return Boolean.valueOf(false);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */