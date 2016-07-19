package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.Callable;

class CrashlyticsCore$2
  implements Callable<Void>
{
  CrashlyticsCore$2(CrashlyticsCore paramCrashlyticsCore) {}
  
  public Void call()
    throws Exception
  {
    CrashlyticsCore.access$100(this$0).create();
    Fabric.getLogger().d("CrashlyticsCore", "Initialization marker file created.");
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */