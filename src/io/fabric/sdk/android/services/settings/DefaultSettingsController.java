package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsController
  implements SettingsController
{
  private final CachedSettingsIo cachedSettingsIo;
  private final CurrentTimeProvider currentTimeProvider;
  private final Kit kit;
  private final PreferenceStore preferenceStore;
  private final SettingsJsonTransform settingsJsonTransform;
  private final SettingsRequest settingsRequest;
  private final SettingsSpiCall settingsSpiCall;
  
  public DefaultSettingsController(Kit paramKit, SettingsRequest paramSettingsRequest, CurrentTimeProvider paramCurrentTimeProvider, SettingsJsonTransform paramSettingsJsonTransform, CachedSettingsIo paramCachedSettingsIo, SettingsSpiCall paramSettingsSpiCall)
  {
    kit = paramKit;
    settingsRequest = paramSettingsRequest;
    currentTimeProvider = paramCurrentTimeProvider;
    settingsJsonTransform = paramSettingsJsonTransform;
    cachedSettingsIo = paramCachedSettingsIo;
    settingsSpiCall = paramSettingsSpiCall;
    preferenceStore = new PreferenceStoreImpl(kit);
  }
  
  private SettingsData getCachedSettingsData(SettingsCacheBehavior paramSettingsCacheBehavior)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(paramSettingsCacheBehavior)) {
        break label206;
      }
      localObject1 = localObject2;
      JSONObject localJSONObject = cachedSettingsIo.readCachedSettings();
      if (localJSONObject == null) {
        break label190;
      }
      localObject1 = localObject2;
      SettingsData localSettingsData = settingsJsonTransform.buildFromJson(currentTimeProvider, localJSONObject);
      if (localSettingsData != null)
      {
        localObject1 = localObject2;
        logSettings(localJSONObject, "Loaded cached settings: ");
        localObject1 = localObject2;
        long l = currentTimeProvider.getCurrentTimeMillis();
        localObject1 = localObject2;
        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(paramSettingsCacheBehavior))
        {
          localObject1 = localObject2;
          if (localSettingsData.isExpired(l)) {}
        }
        else
        {
          paramSettingsCacheBehavior = localSettingsData;
          localObject1 = paramSettingsCacheBehavior;
          Fabric.getLogger().d("Fabric", "Returning cached settings.");
          return paramSettingsCacheBehavior;
        }
        localObject1 = localObject2;
        Fabric.getLogger().d("Fabric", "Cached settings have expired.");
        return null;
      }
    }
    catch (Exception paramSettingsCacheBehavior)
    {
      Fabric.getLogger().e("Fabric", "Failed to get cached settings", paramSettingsCacheBehavior);
      return (SettingsData)localObject1;
    }
    localObject1 = localObject2;
    Fabric.getLogger().e("Fabric", "Failed to transform cached settings data.", null);
    return null;
    label190:
    localObject1 = localObject2;
    Fabric.getLogger().d("Fabric", "No cached settings data found.");
    label206:
    return null;
  }
  
  private void logSettings(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    Fabric.getLogger().d("Fabric", paramString + paramJSONObject.toString());
  }
  
  boolean buildInstanceIdentifierChanged()
  {
    return !getStoredBuildInstanceIdentifier().equals(getBuildInstanceIdentifierFromContext());
  }
  
  String getBuildInstanceIdentifierFromContext()
  {
    return CommonUtils.createInstanceIdFrom(new String[] { CommonUtils.resolveBuildId(kit.getContext()) });
  }
  
  String getStoredBuildInstanceIdentifier()
  {
    return preferenceStore.get().getString("existing_instance_identifier", "");
  }
  
  public SettingsData loadSettingsData()
  {
    return loadSettingsData(SettingsCacheBehavior.USE_CACHE);
  }
  
  public SettingsData loadSettingsData(SettingsCacheBehavior paramSettingsCacheBehavior)
  {
    Object localObject3 = null;
    JSONObject localJSONObject = null;
    Object localObject2 = localJSONObject;
    Object localObject1 = localObject3;
    try
    {
      if (!Fabric.isDebuggable())
      {
        localObject2 = localJSONObject;
        localObject1 = localObject3;
        if (!buildInstanceIdentifierChanged())
        {
          localObject1 = localObject3;
          localObject2 = getCachedSettingsData(paramSettingsCacheBehavior);
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        localJSONObject = settingsSpiCall.invoke(settingsRequest);
        localObject1 = localObject2;
        if (localJSONObject != null)
        {
          localObject1 = localObject2;
          paramSettingsCacheBehavior = settingsJsonTransform.buildFromJson(currentTimeProvider, localJSONObject);
          localObject1 = paramSettingsCacheBehavior;
          cachedSettingsIo.writeCachedSettings(expiresAtMillis, localJSONObject);
          localObject1 = paramSettingsCacheBehavior;
          logSettings(localJSONObject, "Loaded settings: ");
          localObject1 = paramSettingsCacheBehavior;
          setStoredBuildInstanceIdentifier(getBuildInstanceIdentifierFromContext());
          localObject1 = paramSettingsCacheBehavior;
        }
      }
      paramSettingsCacheBehavior = (SettingsCacheBehavior)localObject1;
      if (localObject1 == null) {
        paramSettingsCacheBehavior = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
      }
      return paramSettingsCacheBehavior;
    }
    catch (Exception paramSettingsCacheBehavior)
    {
      Fabric.getLogger().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", paramSettingsCacheBehavior);
    }
    return (SettingsData)localObject1;
  }
  
  @SuppressLint({"CommitPrefEdits"})
  boolean setStoredBuildInstanceIdentifier(String paramString)
  {
    SharedPreferences.Editor localEditor = preferenceStore.edit();
    localEditor.putString("existing_instance_identifier", paramString);
    return preferenceStore.save(localEditor);
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.DefaultSettingsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */