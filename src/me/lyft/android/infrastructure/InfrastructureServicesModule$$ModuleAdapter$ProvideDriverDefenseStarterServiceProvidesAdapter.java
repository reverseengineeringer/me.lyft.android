package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideDriverDefenseStarterServiceProvidesAdapter
  extends ProvidesBinding<DriverShortcutStarterService>
{
  private Binding<IFeaturesProvider> featuresProvider;
  private Binding<ILyftPreferences> lyftPreferences;
  private final InfrastructureServicesModule module;
  private Binding<IUserProvider> userProvider;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideDriverDefenseStarterServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideDriverDefenseStarterService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public DriverShortcutStarterService get()
  {
    return module.provideDriverDefenseStarterService((IUserProvider)userProvider.get(), (ILyftPreferences)lyftPreferences.get(), (IFeaturesProvider)featuresProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(lyftPreferences);
    paramSet1.add(featuresProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideDriverDefenseStarterServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */