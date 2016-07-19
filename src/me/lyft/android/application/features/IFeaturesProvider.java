package me.lyft.android.application.features;

import me.lyft.android.infrastructure.lyft.features.FeatureFlag;

public abstract interface IFeaturesProvider
{
  public abstract boolean isEnabled(FeatureFlag paramFeatureFlag);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.IFeaturesProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */