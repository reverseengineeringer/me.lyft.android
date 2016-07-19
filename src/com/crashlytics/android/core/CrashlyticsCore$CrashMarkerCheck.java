package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.Callable;

final class CrashlyticsCore$CrashMarkerCheck
  implements Callable<Boolean>
{
  private final CrashlyticsFileMarker crashMarker;
  
  public CrashlyticsCore$CrashMarkerCheck(CrashlyticsFileMarker paramCrashlyticsFileMarker)
  {
    crashMarker = paramCrashlyticsFileMarker;
  }
  
  public Boolean call()
    throws Exception
  {
    if (!crashMarker.isPresent()) {
      return Boolean.FALSE;
    }
    Fabric.getLogger().d("CrashlyticsCore", "Found previous crash marker.");
    crashMarker.remove();
    return Boolean.TRUE;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.CrashMarkerCheck
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */