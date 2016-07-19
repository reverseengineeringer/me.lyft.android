package io.fabric.sdk.android.services.settings;

import org.json.JSONObject;

public abstract interface SettingsSpiCall
{
  public abstract JSONObject invoke(SettingsRequest paramSettingsRequest);
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.SettingsSpiCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */