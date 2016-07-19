package com.crashlytics.android.core;

import android.util.Log;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;

class BuildIdValidator
{
  private final String buildId;
  private final boolean requiringBuildId;
  
  public BuildIdValidator(String paramString, boolean paramBoolean)
  {
    buildId = paramString;
    requiringBuildId = paramBoolean;
  }
  
  protected String getMessage(String paramString1, String paramString2)
  {
    return "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
  }
  
  public void validate(String paramString1, String paramString2)
  {
    if ((CommonUtils.isNullOrEmpty(buildId)) && (requiringBuildId))
    {
      paramString1 = getMessage(paramString1, paramString2);
      Log.e("CrashlyticsCore", ".");
      Log.e("CrashlyticsCore", ".     |  | ");
      Log.e("CrashlyticsCore", ".     |  |");
      Log.e("CrashlyticsCore", ".     |  |");
      Log.e("CrashlyticsCore", ".   \\ |  | /");
      Log.e("CrashlyticsCore", ".    \\    /");
      Log.e("CrashlyticsCore", ".     \\  /");
      Log.e("CrashlyticsCore", ".      \\/");
      Log.e("CrashlyticsCore", ".");
      Log.e("CrashlyticsCore", paramString1);
      Log.e("CrashlyticsCore", ".");
      Log.e("CrashlyticsCore", ".      /\\");
      Log.e("CrashlyticsCore", ".     /  \\");
      Log.e("CrashlyticsCore", ".    /    \\");
      Log.e("CrashlyticsCore", ".   / |  | \\");
      Log.e("CrashlyticsCore", ".     |  |");
      Log.e("CrashlyticsCore", ".     |  |");
      Log.e("CrashlyticsCore", ".     |  |");
      Log.e("CrashlyticsCore", ".");
      throw new CrashlyticsMissingDependencyException(paramString1);
    }
    if (!requiringBuildId) {
      Fabric.getLogger().d("CrashlyticsCore", "Configured not to require a build ID.");
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.BuildIdValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */