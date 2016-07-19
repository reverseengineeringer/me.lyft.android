package io.fabric.sdk.android.services.settings;

public class BetaSettingsData
{
  public final int updateSuspendDurationSeconds;
  public final String updateUrl;
  
  public BetaSettingsData(String paramString, int paramInt)
  {
    updateUrl = paramString;
    updateSuspendDurationSeconds = paramInt;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.BetaSettingsData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */