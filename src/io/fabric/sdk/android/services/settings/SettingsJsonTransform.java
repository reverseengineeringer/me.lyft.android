package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

public abstract interface SettingsJsonTransform
{
  public abstract SettingsData buildFromJson(CurrentTimeProvider paramCurrentTimeProvider, JSONObject paramJSONObject)
    throws JSONException;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.SettingsJsonTransform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */