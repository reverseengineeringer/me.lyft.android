package me.lyft.android.jobs;

import android.content.res.Resources;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.RideFlags;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.ui.MainActivity;
import me.lyft.android.utils.TextToSpeech;

public class DriverCloseToCurrentStopJob
  implements Job
{
  @Inject
  IAppForegroundDetector appForegroundDetector;
  @Inject
  LyftApplication application;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  ILocationService locationService;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  IDriverRideProvider routeProvider;
  @Inject
  TextToSpeech textToSpeech;
  
  private boolean isCloseToPickup(Location paramLocation1, Location paramLocation2)
  {
    return paramLocation1.isWithin(paramLocation2, (Long)constantsProvider.get(Constants.AUTO_RESTORE_DISTANCE_THRESHOLD));
  }
  
  private boolean shouldAutoSwitchBackToApp()
  {
    return (lyftPreferences.isAutoSwitchBackEnabled()) && (!appForegroundDetector.isForegrounded()) && (routeProvider.getDriverRide().getCurrentStop().isPickup()) && (isCloseToPickup(routeProvider.getDriverRide().getCurrentStop().getLocation(), locationService.getLastCachedLocation()));
  }
  
  private void speakCloseToStop()
  {
    String str = routeProvider.getDriverRide().getCurrentPassenger().getFirstName();
    if (!Strings.isNullOrEmpty(str)) {}
    for (str = application.getResources().getString(2131165305, new Object[] { str });; str = application.getResources().getString(2131165304))
    {
      textToSpeech.speak(str);
      return;
    }
  }
  
  public void execute()
    throws Throwable
  {
    RideFlags localRideFlags = lyftPreferences.getRideFlags();
    if ((!routeProvider.getDriverRide().isInProgress()) || (localRideFlags.hasAutoSwitchedBack())) {}
    while (!shouldAutoSwitchBackToApp()) {
      return;
    }
    MainActivity.foregroundActivity(application, "close_to_pickup");
    speakCloseToStop();
    localRideFlags.setHasAutoSwitchedback(true);
    lyftPreferences.setRideFlags(localRideFlags);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.DriverCloseToCurrentStopJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */