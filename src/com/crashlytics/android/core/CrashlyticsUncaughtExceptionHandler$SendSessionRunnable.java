package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;

final class CrashlyticsUncaughtExceptionHandler$SendSessionRunnable
  implements Runnable
{
  private final CrashlyticsCore crashlyticsCore;
  private final File fileToSend;
  
  public CrashlyticsUncaughtExceptionHandler$SendSessionRunnable(CrashlyticsCore paramCrashlyticsCore, File paramFile)
  {
    crashlyticsCore = paramCrashlyticsCore;
    fileToSend = paramFile;
  }
  
  public void run()
  {
    if (!CommonUtils.canTryConnection(crashlyticsCore.getContext())) {}
    Object localObject;
    do
    {
      return;
      Fabric.getLogger().d("CrashlyticsCore", "Attempting to send crash report at time of crash...");
      localObject = Settings.getInstance().awaitSettingsData();
      localObject = crashlyticsCore.getCreateReportSpiCall((SettingsData)localObject);
    } while (localObject == null);
    new ReportUploader((CreateReportSpiCall)localObject).forceUpload(new SessionReport(fileToSend, CrashlyticsUncaughtExceptionHandler.access$1300()));
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.SendSessionRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */