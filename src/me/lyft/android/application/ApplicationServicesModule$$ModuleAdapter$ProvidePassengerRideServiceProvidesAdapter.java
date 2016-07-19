package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePassengerRideServiceProvidesAdapter
  extends ProvidesBinding<IPassengerRideService>
{
  private Binding<ICheckoutSession> checkoutSession;
  private Binding<IExpenseNoteSession> expenseNoteSession;
  private Binding<ILocationService> locationService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  private Binding<IRatingSession> ratingSession;
  private Binding<IRideRequestSession> rideRequestSession;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePassengerRideServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.passenger.IPassengerRideService", true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerRideService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    checkoutSession = paramLinker.requestBinding("me.lyft.android.application.checkout.ICheckoutSession", ApplicationServicesModule.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    ratingSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRatingSession", ApplicationServicesModule.class, getClass().getClassLoader());
    expenseNoteSession = paramLinker.requestBinding("me.lyft.android.application.ride.IExpenseNoteSession", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPassengerRideService get()
  {
    return module.providePassengerRideService((ILyftApi)lyftApi.get(), (IPassengerRideProvider)passengerRideProvider.get(), (ICheckoutSession)checkoutSession.get(), (ILocationService)locationService.get(), (IRideRequestSession)rideRequestSession.get(), (IRatingSession)ratingSession.get(), (IExpenseNoteSession)expenseNoteSession.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(passengerRideProvider);
    paramSet1.add(checkoutSession);
    paramSet1.add(locationService);
    paramSet1.add(rideRequestSession);
    paramSet1.add(ratingSession);
    paramSet1.add(expenseNoteSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePassengerRideServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */