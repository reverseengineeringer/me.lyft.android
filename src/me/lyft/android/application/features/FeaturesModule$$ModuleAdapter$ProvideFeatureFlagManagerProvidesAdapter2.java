package me.lyft.android.application.features;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;

public final class FeaturesModule$$ModuleAdapter$ProvideFeatureFlagManagerProvidesAdapter2
  extends ProvidesBinding<IFeatureFlagsOverrideManager>
{
  private final FeaturesModule module;
  private Binding<IFeatureFlagOverrideStorage> storage;
  
  public FeaturesModule$$ModuleAdapter$ProvideFeatureFlagManagerProvidesAdapter2(FeaturesModule paramFeaturesModule)
  {
    super("me.lyft.android.application.features.IFeatureFlagsOverrideManager", true, "me.lyft.android.application.features.FeaturesModule", "provideFeatureFlagManager");
    module = paramFeaturesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    storage = paramLinker.requestBinding("me.lyft.android.application.features.IFeatureFlagOverrideStorage", FeaturesModule.class, getClass().getClassLoader());
  }
  
  public IFeatureFlagsOverrideManager get()
  {
    return module.provideFeatureFlagManager((IFeatureFlagOverrideStorage)storage.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(storage);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.FeaturesModule..ModuleAdapter.ProvideFeatureFlagManagerProvidesAdapter2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */