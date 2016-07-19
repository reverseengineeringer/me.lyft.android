package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.polling.ILocationUpdateService;
import me.lyft.android.application.polling.IPollingService;
import me.lyft.android.infrastructure.location.ILocationService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePollingServiceProvidesAdapter
  extends ProvidesBinding<IPollingService>
{
  private Binding<ILocationService> locationService;
  private Binding<ILyftPreferences> lyftPreferences;
  private final ApplicationServicesModule module;
  private Binding<ILocationUpdateService> pollingRequestService;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePollingServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.polling.IPollingService", true, "me.lyft.android.application.ApplicationServicesModule", "providePollingService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    pollingRequestService = paramLinker.requestBinding("me.lyft.android.application.polling.ILocationUpdateService", ApplicationServicesModule.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPollingService get()
  {
    return module.providePollingService((ILocationUpdateService)pollingRequestService.get(), (ILocationService)locationService.get(), (ILyftPreferences)lyftPreferences.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(pollingRequestService);
    paramSet1.add(locationService);
    paramSet1.add(lyftPreferences);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePollingServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */