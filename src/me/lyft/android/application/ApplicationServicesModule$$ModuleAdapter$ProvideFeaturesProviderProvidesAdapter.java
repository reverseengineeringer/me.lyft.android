package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.features.IFeatureFlagOverrideStorage;
import me.lyft.android.application.features.IFeaturesProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideFeaturesProviderProvidesAdapter
  extends ProvidesBinding<IFeaturesProvider>
{
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<IFeatureFlagOverrideStorage> featureFlagOverrideStorage;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideFeaturesProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.features.IFeaturesProvider", true, "me.lyft.android.application.ApplicationServicesModule", "provideFeaturesProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    featureFlagOverrideStorage = paramLinker.requestBinding("me.lyft.android.application.features.IFeatureFlagOverrideStorage", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IFeaturesProvider get()
  {
    return module.provideFeaturesProvider((IConstantsProvider)constantsProvider.get(), (IFeatureFlagOverrideStorage)featureFlagOverrideStorage.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(constantsProvider);
    paramSet1.add(featureFlagOverrideStorage);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideFeaturesProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */