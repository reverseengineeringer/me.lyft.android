package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.driver.IDriverDestinationService;

public final class DriverDestinationJob$$InjectAdapter
  extends Binding<DriverDestinationJob>
{
  private Binding<IDriverDestinationService> driverDestinationService;
  private Binding<IUserProvider> userProvider;
  
  public DriverDestinationJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.DriverDestinationJob", false, DriverDestinationJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    driverDestinationService = paramLinker.requestBinding("me.lyft.android.application.driver.IDriverDestinationService", DriverDestinationJob.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", DriverDestinationJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(driverDestinationService);
    paramSet2.add(userProvider);
  }
  
  public void injectMembers(DriverDestinationJob paramDriverDestinationJob)
  {
    driverDestinationService = ((IDriverDestinationService)driverDestinationService.get());
    userProvider = ((IUserProvider)userProvider.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.DriverDestinationJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */