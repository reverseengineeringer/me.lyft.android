package me.lyft.android.jobs;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.ride.flow.RequestFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.SimpleSubscriber;
import me.lyft.android.ui.MainScreensRouter;

class RideRequestSessionUpdateJob$1
  extends SimpleSubscriber<Location>
{
  RideRequestSessionUpdateJob$1(RideRequestSessionUpdateJob paramRideRequestSessionUpdateJob) {}
  
  public void onNext(Location paramLocation)
  {
    if (!Strings.isNullOrEmpty(RideRequestSessionUpdateJob.access$000(this$0))) {
      this$0.rideRequestSession.setCurrentRideTypeById(RideRequestSessionUpdateJob.access$000(this$0));
    }
    if (!RideRequestSessionUpdateJob.access$100(this$0).isNull()) {
      this$0.rideRequestSession.setPickupLocation(RideRequestSessionUpdateJob.access$100(this$0));
    }
    for (;;)
    {
      if (!RideRequestSessionUpdateJob.access$200(this$0).isNull())
      {
        if (this$0.rideRequestSession.getPickupLocation().isNull()) {
          this$0.rideRequestSession.setPickupLocation(paramLocation);
        }
        this$0.rideRequestSession.setDropoffLocation(RideRequestSessionUpdateJob.access$200(this$0));
      }
      this$0.rideRequestSession.setRequestRideStep(this$0.requestFlowProvider.getRequestFlow().determineCurrentStep());
      this$0.mainScreensRouter.resetToHomeScreen();
      return;
      if (this$0.rideRequestSession.getPickupLocation().isNull()) {
        this$0.rideRequestSession.setPickupLocation(paramLocation);
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideRequestSessionUpdateJob.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */