package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.navigation.NavigationSettings;

public final class UserModeChangeJob$$InjectAdapter
  extends Binding<UserModeChangeJob>
{
  private Binding<NavigationSettings> navigationSettings;
  private Binding<ILyftPreferences> preferences;
  private Binding<IRequestRideTypeService> requestRideTypeProvider;
  private Binding<IRideRequestSession> rideRequestSession;
  
  public UserModeChangeJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.UserModeChangeJob", false, UserModeChangeJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", UserModeChangeJob.class, getClass().getClassLoader());
    requestRideTypeProvider = paramLinker.requestBinding("me.lyft.android.application.requestridetypes.IRequestRideTypeService", UserModeChangeJob.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", UserModeChangeJob.class, getClass().getClassLoader());
    navigationSettings = paramLinker.requestBinding("me.lyft.android.navigation.NavigationSettings", UserModeChangeJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(rideRequestSession);
    paramSet2.add(requestRideTypeProvider);
    paramSet2.add(preferences);
    paramSet2.add(navigationSettings);
  }
  
  public void injectMembers(UserModeChangeJob paramUserModeChangeJob)
  {
    rideRequestSession = ((IRideRequestSession)rideRequestSession.get());
    requestRideTypeProvider = ((IRequestRideTypeService)requestRideTypeProvider.get());
    preferences = ((ILyftPreferences)preferences.get());
    navigationSettings = ((NavigationSettings)navigationSettings.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UserModeChangeJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */