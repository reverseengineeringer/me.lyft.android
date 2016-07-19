package io.fabric.sdk.android.services.settings;

import org.json.JSONObject;

public abstract interface CachedSettingsIo
{
  public abstract JSONObject readCachedSettings();
  
  public abstract void writeCachedSettings(long paramLong, JSONObject paramJSONObject);
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.CachedSettingsIo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */