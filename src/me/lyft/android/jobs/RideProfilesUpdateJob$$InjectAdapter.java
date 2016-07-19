package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.profile.IRideProfileService;

public final class RideProfilesUpdateJob$$InjectAdapter
  extends Binding<RideProfilesUpdateJob>
{
  private Binding<IRideProfileService> rideProfileService;
  
  public RideProfilesUpdateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.RideProfilesUpdateJob", false, RideProfilesUpdateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    rideProfileService = paramLinker.requestBinding("me.lyft.android.application.profile.IRideProfileService", RideProfilesUpdateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(rideProfileService);
  }
  
  public void injectMembers(RideProfilesUpdateJob paramRideProfilesUpdateJob)
  {
    rideProfileService = ((IRideProfileService)rideProfileService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideProfilesUpdateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */