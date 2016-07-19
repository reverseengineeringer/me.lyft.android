package com.crashlytics.android.core;

import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.Settings.SettingsAccess;
import io.fabric.sdk.android.services.settings.SettingsData;

class CrashlyticsCore$5
  implements Settings.SettingsAccess<Boolean>
{
  CrashlyticsCore$5(CrashlyticsCore paramCrashlyticsCore) {}
  
  public Boolean usingSettings(SettingsData paramSettingsData)
  {
    boolean bool = false;
    if (featuresData.promptEnabled)
    {
      if (!this$0.shouldSendReportsWithoutPrompting()) {
        bool = true;
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(false);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */