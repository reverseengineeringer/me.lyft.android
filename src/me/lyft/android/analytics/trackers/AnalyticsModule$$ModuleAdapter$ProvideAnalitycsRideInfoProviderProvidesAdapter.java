package me.lyft.android.analytics.trackers;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.analytics.IAnalyticsRideInfoProvider;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IDriverRideProvider;

public final class AnalyticsModule$$ModuleAdapter$ProvideAnalitycsRideInfoProviderProvidesAdapter
  extends ProvidesBinding<IAnalyticsRideInfoProvider>
{
  private Binding<IDriverRideProvider> driverRideProvider;
  private final AnalyticsModule module;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  private Binding<IUserProvider> userProvider;
  
  public AnalyticsModule$$ModuleAdapter$ProvideAnalitycsRideInfoProviderProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("me.lyft.android.analytics.IAnalyticsRideInfoProvider", true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAnalitycsRideInfoProvider");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AnalyticsModule.class, getClass().getClassLoader());
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", AnalyticsModule.class, getClass().getClassLoader());
    driverRideProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", AnalyticsModule.class, getClass().getClassLoader());
  }
  
  public IAnalyticsRideInfoProvider get()
  {
    return module.provideAnalitycsRideInfoProvider((IUserProvider)userProvider.get(), (IPassengerRideProvider)passengerRideProvider.get(), (IDriverRideProvider)driverRideProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(passengerRideProvider);
    paramSet1.add(driverRideProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideAnalitycsRideInfoProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */