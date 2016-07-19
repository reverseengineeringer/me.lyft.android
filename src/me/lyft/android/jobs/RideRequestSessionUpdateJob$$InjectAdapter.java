package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.ui.MainScreensRouter;

public final class RideRequestSessionUpdateJob$$InjectAdapter
  extends Binding<RideRequestSessionUpdateJob>
{
  private Binding<ILocationService> locationService;
  private Binding<MainScreensRouter> mainScreensRouter;
  private Binding<IRequestFlowProvider> requestFlowProvider;
  private Binding<IRideRequestSession> rideRequestSession;
  private Binding<IUserProvider> userProvider;
  
  public RideRequestSessionUpdateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.RideRequestSessionUpdateJob", false, RideRequestSessionUpdateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", RideRequestSessionUpdateJob.class, getClass().getClassLoader());
    mainScreensRouter = paramLinker.requestBinding("me.lyft.android.ui.MainScreensRouter", RideRequestSessionUpdateJob.class, getClass().getClassLoader());
    requestFlowProvider = paramLinker.requestBinding("me.lyft.android.application.ride.flow.IRequestFlowProvider", RideRequestSessionUpdateJob.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", RideRequestSessionUpdateJob.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", RideRequestSessionUpdateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(rideRequestSession);
    paramSet2.add(mainScreensRouter);
    paramSet2.add(requestFlowProvider);
    paramSet2.add(locationService);
    paramSet2.add(userProvider);
  }
  
  public void injectMembers(RideRequestSessionUpdateJob paramRideRequestSessionUpdateJob)
  {
    rideRequestSession = ((IRideRequestSession)rideRequestSession.get());
    mainScreensRouter = ((MainScreensRouter)mainScreensRouter.get());
    requestFlowProvider = ((IRequestFlowProvider)requestFlowProvider.get());
    locationService = ((ILocationService)locationService.get());
    userProvider = ((IUserProvider)userProvider.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideRequestSessionUpdateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */