package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRideTypeMetaServiceProvidesAdapter
  extends ProvidesBinding<IRideTypeMetaService>
{
  private Binding<IAppInfoService> appInfoService;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRideTypeMetaServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.requestridetypes.IRideTypeMetaService", true, "me.lyft.android.application.ApplicationServicesModule", "provideRideTypeMetaService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IRideTypeMetaService get()
  {
    return module.provideRideTypeMetaService((IAppInfoService)appInfoService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(appInfoService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRideTypeMetaServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */