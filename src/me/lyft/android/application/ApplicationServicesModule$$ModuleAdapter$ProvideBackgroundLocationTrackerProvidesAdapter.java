package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.polling.IBackgroundLocationTracker;
import me.lyft.android.application.polling.ILocationUpdateService;
import me.lyft.android.infrastructure.location.ILocationService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideBackgroundLocationTrackerProvidesAdapter
  extends ProvidesBinding<IBackgroundLocationTracker>
{
  private Binding<ILocationService> locationService;
  private Binding<ILocationUpdateService> locationUpdateService;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideBackgroundLocationTrackerProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.polling.IBackgroundLocationTracker", true, "me.lyft.android.application.ApplicationServicesModule", "provideBackgroundLocationTracker");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    locationUpdateService = paramLinker.requestBinding("me.lyft.android.application.polling.ILocationUpdateService", ApplicationServicesModule.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IBackgroundLocationTracker get()
  {
    return module.provideBackgroundLocationTracker((ILocationUpdateService)locationUpdateService.get(), (ILocationService)locationService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(locationUpdateService);
    paramSet1.add(locationService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideBackgroundLocationTrackerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */