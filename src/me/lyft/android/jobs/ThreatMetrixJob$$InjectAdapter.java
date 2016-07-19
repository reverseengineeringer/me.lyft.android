package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.infrastructure.location.ILocationService;

public final class ThreatMetrixJob$$InjectAdapter
  extends Binding<ThreatMetrixJob>
{
  private Binding<ILocationService> locationService;
  private Binding<LyftApplication> lyftApplication;
  
  public ThreatMetrixJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.ThreatMetrixJob", false, ThreatMetrixJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ThreatMetrixJob.class, getClass().getClassLoader());
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", ThreatMetrixJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(locationService);
    paramSet2.add(lyftApplication);
  }
  
  public void injectMembers(ThreatMetrixJob paramThreatMetrixJob)
  {
    locationService = ((ILocationService)locationService.get());
    lyftApplication = ((LyftApplication)lyftApplication.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.ThreatMetrixJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */