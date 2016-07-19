package io.fabric.sdk.android.services.settings;

public abstract interface SettingsController
{
  public abstract SettingsData loadSettingsData();
  
  public abstract SettingsData loadSettingsData(SettingsCacheBehavior paramSettingsCacheBehavior);
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.SettingsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */