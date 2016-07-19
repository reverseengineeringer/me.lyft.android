package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.geo.routecache.DriverDeviationBasedCache;
import me.lyft.android.application.passenger.IPassengerRideProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideDriverDeviationBasedCacheProvidesAdapter
  extends ProvidesBinding<DriverDeviationBasedCache>
{
  private Binding<IConstantsProvider> constantsProvider;
  private final ApplicationServicesModule module;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideDriverDeviationBasedCacheProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.geo.routecache.DriverDeviationBasedCache", true, "me.lyft.android.application.ApplicationServicesModule", "provideDriverDeviationBasedCache");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public DriverDeviationBasedCache get()
  {
    return module.provideDriverDeviationBasedCache((IPassengerRideProvider)passengerRideProvider.get(), (IConstantsProvider)constantsProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(passengerRideProvider);
    paramSet1.add(constantsProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideDriverDeviationBasedCacheProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */