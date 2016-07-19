package me.lyft.android.application.features;

import me.lyft.android.infrastructure.lyft.features.FeatureFlag;
import me.lyft.android.infrastructure.lyft.features.FeatureFlagOverride;

public abstract interface IFeatureFlagOverrideStorage
{
  public abstract void clear();
  
  public abstract FeatureFlagOverride getFlag(FeatureFlag paramFeatureFlag);
  
  public abstract void removeFlag(String paramString);
  
  public abstract void saveFlag(String paramString, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.IFeatureFlagOverrideStorage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */