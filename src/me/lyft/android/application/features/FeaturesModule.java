package me.lyft.android.application.features;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.LyftApplication;

@Module(complete=false, library=true)
public class FeaturesModule
{
  @Provides
  @Singleton
  IFeatureFlagOverrideStorage provideFeatureFlagManager(LyftApplication paramLyftApplication)
  {
    return new FeatureFlagOverrideStorage(paramLyftApplication);
  }
  
  @Provides
  @Singleton
  IFeatureFlagsOverrideManager provideFeatureFlagManager(IFeatureFlagOverrideStorage paramIFeatureFlagOverrideStorage)
  {
    return new FeatureFlagsOverrideManager(paramIFeatureFlagOverrideStorage);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.FeaturesModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */