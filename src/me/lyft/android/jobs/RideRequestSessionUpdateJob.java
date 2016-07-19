package me.lyft.android.jobs;

import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.ride.flow.RequestFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.SimpleSubscriber;
import me.lyft.android.ui.MainScreensRouter;
import rx.Observable;

public class RideRequestSessionUpdateJob
  implements Job
{
  private final Location dropoffLocation;
  @Inject
  ILocationService locationService;
  @Inject
  MainScreensRouter mainScreensRouter;
  private final Location pickupLocation;
  @Inject
  IRequestFlowProvider requestFlowProvider;
  @Inject
  IRideRequestSession rideRequestSession;
  private final String rideTypeId;
  @Inject
  IUserProvider userProvider;
  
  public RideRequestSessionUpdateJob(Location paramLocation1, Location paramLocation2, String paramString)
  {
    pickupLocation = paramLocation1;
    dropoffLocation = paramLocation2;
    rideTypeId = paramString;
  }
  
  public void execute()
    throws Throwable
  {
    locationService.getLastLocation().subscribe(new SimpleSubscriber()
    {
      public void onNext(Location paramAnonymousLocation)
      {
        if (!Strings.isNullOrEmpty(rideTypeId)) {
          rideRequestSession.setCurrentRideTypeById(rideTypeId);
        }
        if (!pickupLocation.isNull()) {
          rideRequestSession.setPickupLocation(pickupLocation);
        }
        for (;;)
        {
          if (!dropoffLocation.isNull())
          {
            if (rideRequestSession.getPickupLocation().isNull()) {
              rideRequestSession.setPickupLocation(paramAnonymousLocation);
            }
            rideRequestSession.setDropoffLocation(dropoffLocation);
          }
          rideRequestSession.setRequestRideStep(requestFlowProvider.getRequestFlow().determineCurrentStep());
          mainScreensRouter.resetToHomeScreen();
          return;
          if (rideRequestSession.getPickupLocation().isNull()) {
            rideRequestSession.setPickupLocation(paramAnonymousLocation);
          }
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideRequestSessionUpdateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */