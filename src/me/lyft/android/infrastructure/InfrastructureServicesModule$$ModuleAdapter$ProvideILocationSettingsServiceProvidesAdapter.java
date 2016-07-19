package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideILocationSettingsServiceProvidesAdapter
  extends ProvidesBinding<ILocationSettingsService>
{
  private Binding<LyftApplication> lyftApplication;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideILocationSettingsServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.locationsettings.ILocationSettingsService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideILocationSettingsService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public ILocationSettingsService get()
  {
    return module.provideILocationSettingsService((LyftApplication)lyftApplication.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideILocationSettingsServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */