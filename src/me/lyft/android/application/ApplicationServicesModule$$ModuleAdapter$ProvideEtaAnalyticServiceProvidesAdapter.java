package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.application.ride.IRideRequestSession;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideEtaAnalyticServiceProvidesAdapter
  extends ProvidesBinding<IEtaAnalyticService>
{
  private final ApplicationServicesModule module;
  private Binding<IRideRequestSession> rideRequestSession;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideEtaAnalyticServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.geo.IEtaAnalyticService", true, "me.lyft.android.application.ApplicationServicesModule", "provideEtaAnalyticService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IEtaAnalyticService get()
  {
    return module.provideEtaAnalyticService((IRideRequestSession)rideRequestSession.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(rideRequestSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideEtaAnalyticServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */