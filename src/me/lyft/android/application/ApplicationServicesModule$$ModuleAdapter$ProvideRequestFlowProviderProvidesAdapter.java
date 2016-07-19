package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.venue.IVenuePickupService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRequestFlowProviderProvidesAdapter
  extends ProvidesBinding<IRequestFlowProvider>
{
  private final ApplicationServicesModule module;
  private Binding<IRideRequestSession> session;
  private Binding<IVenuePickupService> venueService;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRequestFlowProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.flow.IRequestFlowProvider", true, "me.lyft.android.application.ApplicationServicesModule", "provideRequestFlowProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    session = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    venueService = paramLinker.requestBinding("me.lyft.android.application.venue.IVenuePickupService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IRequestFlowProvider get()
  {
    return module.provideRequestFlowProvider((IRideRequestSession)session.get(), (IVenuePickupService)venueService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(session);
    paramSet1.add(venueService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRequestFlowProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */