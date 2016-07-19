package me.lyft.android.application.features;

import java.util.List;
import me.lyft.android.infrastructure.lyft.features.FeatureFlag;
import me.lyft.android.infrastructure.lyft.features.FeatureFlagOverride;

public class FeatureFlagsOverrideManager
  implements IFeatureFlagsOverrideManager
{
  private IFeatureFlagOverrideStorage featureFlagStorage;
  
  public FeatureFlagsOverrideManager(IFeatureFlagOverrideStorage paramIFeatureFlagOverrideStorage)
  {
    featureFlagStorage = paramIFeatureFlagOverrideStorage;
  }
  
  public List<FeatureFlag> getFlags()
  {
    return Features.FEATURE_FLAGS;
  }
  
  public boolean hasManualOverride(FeatureFlag paramFeatureFlag)
  {
    return !featureFlagStorage.getFlag(paramFeatureFlag).equals(FeatureFlagOverride.UNSET);
  }
  
  public void overrideFlag(FeatureFlag paramFeatureFlag, boolean paramBoolean)
  {
    featureFlagStorage.saveFlag(paramFeatureFlag.getKey(), paramBoolean);
  }
  
  public void resetAllOverrides()
  {
    featureFlagStorage.clear();
  }
  
  public void resetFlag(FeatureFlag paramFeatureFlag)
  {
    featureFlagStorage.removeFlag(paramFeatureFlag.getKey());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.FeatureFlagsOverrideManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */