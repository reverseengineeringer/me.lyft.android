package me.lyft.android.application.features;

import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.infrastructure.lyft.features.FeatureFlag;
import me.lyft.android.infrastructure.lyft.features.FeatureFlagOverride;

public class FeaturesProvider
  implements IFeaturesProvider
{
  private final IConstantsProvider constantsProvider;
  private final IFeatureFlagOverrideStorage featureFlagOverrideStorage;
  
  public FeaturesProvider(IConstantsProvider paramIConstantsProvider, IFeatureFlagOverrideStorage paramIFeatureFlagOverrideStorage)
  {
    constantsProvider = paramIConstantsProvider;
    featureFlagOverrideStorage = paramIFeatureFlagOverrideStorage;
  }
  
  public boolean isEnabled(FeatureFlag paramFeatureFlag)
  {
    FeatureFlagOverride localFeatureFlagOverride = featureFlagOverrideStorage.getFlag(paramFeatureFlag);
    if (localFeatureFlagOverride.equals(FeatureFlagOverride.ENABLED)) {
      return true;
    }
    if (localFeatureFlagOverride.equals(FeatureFlagOverride.DISABLED)) {
      return false;
    }
    return ((Boolean)constantsProvider.get(paramFeatureFlag)).booleanValue();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.FeaturesProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */