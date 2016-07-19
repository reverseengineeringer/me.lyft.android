package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;

public final class RideAssignedJob$$InjectAdapter
  extends Binding<RideAssignedJob>
{
  private Binding<ILyftPreferences> preferences;
  
  public RideAssignedJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.RideAssignedJob", false, RideAssignedJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", RideAssignedJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(preferences);
  }
  
  public void injectMembers(RideAssignedJob paramRideAssignedJob)
  {
    preferences = ((ILyftPreferences)preferences.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideAssignedJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */