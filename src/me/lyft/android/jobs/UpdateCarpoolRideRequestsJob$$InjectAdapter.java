package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.ride.services.ICarpoolRideService;

public final class UpdateCarpoolRideRequestsJob$$InjectAdapter
  extends Binding<UpdateCarpoolRideRequestsJob>
{
  private Binding<ICarpoolRideService> carpoolRideService;
  
  public UpdateCarpoolRideRequestsJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.UpdateCarpoolRideRequestsJob", false, UpdateCarpoolRideRequestsJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    carpoolRideService = paramLinker.requestBinding("me.lyft.android.application.ride.services.ICarpoolRideService", UpdateCarpoolRideRequestsJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(carpoolRideService);
  }
  
  public void injectMembers(UpdateCarpoolRideRequestsJob paramUpdateCarpoolRideRequestsJob)
  {
    carpoolRideService = ((ICarpoolRideService)carpoolRideService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateCarpoolRideRequestsJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */