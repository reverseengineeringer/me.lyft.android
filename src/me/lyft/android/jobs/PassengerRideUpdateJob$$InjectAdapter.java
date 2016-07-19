package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.ride.ICancellationOptionsProvider;

public final class PassengerRideUpdateJob$$InjectAdapter
  extends Binding<PassengerRideUpdateJob>
{
  private Binding<ICancellationOptionsProvider> cancellationOptionsProvider;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  private Binding<IPassengerRideService> passengerRideService;
  
  public PassengerRideUpdateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.PassengerRideUpdateJob", false, PassengerRideUpdateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    cancellationOptionsProvider = paramLinker.requestBinding("me.lyft.android.application.ride.ICancellationOptionsProvider", PassengerRideUpdateJob.class, getClass().getClassLoader());
    passengerRideService = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideService", PassengerRideUpdateJob.class, getClass().getClassLoader());
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", PassengerRideUpdateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(cancellationOptionsProvider);
    paramSet2.add(passengerRideService);
    paramSet2.add(passengerRideProvider);
  }
  
  public void injectMembers(PassengerRideUpdateJob paramPassengerRideUpdateJob)
  {
    cancellationOptionsProvider = ((ICancellationOptionsProvider)cancellationOptionsProvider.get());
    passengerRideService = ((IPassengerRideService)passengerRideService.get());
    passengerRideProvider = ((IPassengerRideProvider)passengerRideProvider.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.PassengerRideUpdateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */