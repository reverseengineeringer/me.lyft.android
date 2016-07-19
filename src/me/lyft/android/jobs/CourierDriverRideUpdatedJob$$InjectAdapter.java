package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.driver.notifications.IDriverNotificationService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;

public final class CourierDriverRideUpdatedJob$$InjectAdapter
  extends Binding<CourierDriverRideUpdatedJob>
{
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<LyftApplication> application;
  private Binding<IDriverNotificationService> driverNotificationService;
  private Binding<ILyftPreferences> lyftPreferences;
  
  public CourierDriverRideUpdatedJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.CourierDriverRideUpdatedJob", false, CourierDriverRideUpdatedJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", CourierDriverRideUpdatedJob.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", CourierDriverRideUpdatedJob.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", CourierDriverRideUpdatedJob.class, getClass().getClassLoader());
    driverNotificationService = paramLinker.requestBinding("me.lyft.android.driver.notifications.IDriverNotificationService", CourierDriverRideUpdatedJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(application);
    paramSet2.add(lyftPreferences);
    paramSet2.add(appForegroundDetector);
    paramSet2.add(driverNotificationService);
  }
  
  public void injectMembers(CourierDriverRideUpdatedJob paramCourierDriverRideUpdatedJob)
  {
    application = ((LyftApplication)application.get());
    lyftPreferences = ((ILyftPreferences)lyftPreferences.get());
    appForegroundDetector = ((IAppForegroundDetector)appForegroundDetector.get());
    driverNotificationService = ((IDriverNotificationService)driverNotificationService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.CourierDriverRideUpdatedJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */