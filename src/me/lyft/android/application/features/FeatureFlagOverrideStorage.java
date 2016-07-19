package me.lyft.android.application.features;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import me.lyft.android.infrastructure.lyft.features.FeatureFlag;
import me.lyft.android.infrastructure.lyft.features.FeatureFlagOverride;

class FeatureFlagOverrideStorage
  implements IFeatureFlagOverrideStorage
{
  private final SharedPreferences preferences;
  
  public FeatureFlagOverrideStorage(Context paramContext)
  {
    preferences = paramContext.getSharedPreferences("flags", 0);
  }
  
  public void clear()
  {
    preferences.edit().clear().apply();
  }
  
  public FeatureFlagOverride getFlag(FeatureFlag paramFeatureFlag)
  {
    if (!preferences.contains(paramFeatureFlag.getKey())) {
      return FeatureFlagOverride.UNSET;
    }
    if (preferences.getBoolean(paramFeatureFlag.getKey(), false)) {
      return FeatureFlagOverride.ENABLED;
    }
    return FeatureFlagOverride.DISABLED;
  }
  
  public void removeFlag(String paramString)
  {
    preferences.edit().remove(paramString).apply();
  }
  
  public void saveFlag(String paramString, boolean paramBoolean)
  {
    preferences.edit().putBoolean(paramString, paramBoolean).apply();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.FeatureFlagOverrideStorage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */