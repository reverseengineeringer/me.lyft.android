package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;

public final class RideTypesMetaChangedJob$$InjectAdapter
  extends Binding<RideTypesMetaChangedJob>
{
  private Binding<IRideTypeMetaService> rideTypeMetaService;
  
  public RideTypesMetaChangedJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.RideTypesMetaChangedJob", false, RideTypesMetaChangedJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    rideTypeMetaService = paramLinker.requestBinding("me.lyft.android.application.requestridetypes.IRideTypeMetaService", RideTypesMetaChangedJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(rideTypeMetaService);
  }
  
  public void injectMembers(RideTypesMetaChangedJob paramRideTypesMetaChangedJob)
  {
    rideTypeMetaService = ((IRideTypeMetaService)rideTypeMetaService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideTypesMetaChangedJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */