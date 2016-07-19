package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.driver.notifications.IDriverNotificationService;

public final class DriverRideUpdateJob$$InjectAdapter
  extends Binding<DriverRideUpdateJob>
{
  private Binding<IDriverNotificationService> driverNotificationService;
  private Binding<IDriverRideProvider> driverRideProvider;
  private Binding<IFeaturesProvider> featuresProvider;
  
  public DriverRideUpdateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.DriverRideUpdateJob", false, DriverRideUpdateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    driverRideProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", DriverRideUpdateJob.class, getClass().getClassLoader());
    driverNotificationService = paramLinker.requestBinding("me.lyft.android.driver.notifications.IDriverNotificationService", DriverRideUpdateJob.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", DriverRideUpdateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(driverRideProvider);
    paramSet2.add(driverNotificationService);
    paramSet2.add(featuresProvider);
  }
  
  public void injectMembers(DriverRideUpdateJob paramDriverRideUpdateJob)
  {
    driverRideProvider = ((IDriverRideProvider)driverRideProvider.get());
    driverNotificationService = ((IDriverNotificationService)driverNotificationService.get());
    featuresProvider = ((IFeaturesProvider)featuresProvider.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.DriverRideUpdateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */