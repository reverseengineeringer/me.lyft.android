package io.fabric.sdk.android.services.settings;

public class FeaturesSettingsData
{
  public final boolean collectAnalytics;
  public final boolean collectLoggedException;
  public final boolean collectReports;
  public final boolean promptEnabled;
  
  public FeaturesSettingsData(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    promptEnabled = paramBoolean1;
    collectLoggedException = paramBoolean2;
    collectReports = paramBoolean3;
    collectAnalytics = paramBoolean4;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.FeaturesSettingsData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */