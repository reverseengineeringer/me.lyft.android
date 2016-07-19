package me.lyft.android.application.features;

import java.util.List;
import me.lyft.android.infrastructure.lyft.features.FeatureFlag;

public abstract interface IFeatureFlagsOverrideManager
{
  public abstract List<FeatureFlag> getFlags();
  
  public abstract boolean hasManualOverride(FeatureFlag paramFeatureFlag);
  
  public abstract void overrideFlag(FeatureFlag paramFeatureFlag, boolean paramBoolean);
  
  public abstract void resetAllOverrides();
  
  public abstract void resetFlag(FeatureFlag paramFeatureFlag);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.IFeatureFlagsOverrideManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */