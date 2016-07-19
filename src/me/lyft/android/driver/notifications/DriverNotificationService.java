package me.lyft.android.driver.notifications;

import android.content.res.Resources;
import android.os.Handler;
import java.util.List;
import me.lyft.android.analytics.studies.DriverAnalytics;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.driver.DriverDialogs.QueuedRideDialog;
import me.lyft.android.utils.SoundManager;
import me.lyft.android.utils.TextToSpeech;
import me.lyft.android.utils.Vibrator;

public class DriverNotificationService
  implements IDriverNotificationService
{
  private IAppForegroundDetector appForegroundDetector;
  private DialogFlow dialogFlow;
  private Handler mainThreadHandler;
  private Navigator navigator;
  private Resources resources;
  private SoundManager soundManager;
  private TextToSpeech textToSpeech;
  private Vibrator vibrator;
  
  public DriverNotificationService(TextToSpeech paramTextToSpeech, DialogFlow paramDialogFlow, SoundManager paramSoundManager, Resources paramResources, IAppForegroundDetector paramIAppForegroundDetector, Navigator paramNavigator, Vibrator paramVibrator, Handler paramHandler)
  {
    textToSpeech = paramTextToSpeech;
    dialogFlow = paramDialogFlow;
    soundManager = paramSoundManager;
    resources = paramResources;
    appForegroundDetector = paramIAppForegroundDetector;
    navigator = paramNavigator;
    vibrator = paramVibrator;
    mainThreadHandler = paramHandler;
  }
  
  private void navigate(final Location paramLocation)
  {
    mainThreadHandler.post(new Runnable()
    {
      public void run()
      {
        navigator.navigate(paramLocation);
      }
    });
  }
  
  public void courierRouteChanged(Location paramLocation)
  {
    vibrator.vibrate(0, 250L, new Long[] { Long.valueOf(250L), Long.valueOf(250L), Long.valueOf(1000L) });
    DriverAnalytics.trackDriverReroute();
    textToSpeech.speak(resources.getString(2131165836));
    if (!appForegroundDetector.isForegrounded()) {
      navigate(paramLocation);
    }
  }
  
  public void destinationChanged(Location paramLocation)
  {
    textToSpeech.speak(resources.getString(2131165545));
    if (!appForegroundDetector.isForegrounded()) {
      navigate(paramLocation);
    }
  }
  
  public void newPassengerAdded()
  {
    vibrator.vibrate(0, 250L, new Long[] { Long.valueOf(250L), Long.valueOf(250L), Long.valueOf(1000L) });
    soundManager.play(6);
    textToSpeech.speakWithDelay(resources.getString(2131165835), 2);
  }
  
  public void newQueuedRoute(List<DriverRidePassenger> paramList)
  {
    String str = resources.getQuantityString(2131689481, paramList.size(), new Object[] { Integer.valueOf(paramList.size()) });
    soundManager.play(6);
    textToSpeech.speakWithDelay(str, 2);
    dialogFlow.show(new DriverDialogs.QueuedRideDialog(paramList));
  }
  
  public void pickupChanged(Location paramLocation)
  {
    textToSpeech.speak(resources.getString(2131166134));
    if (!appForegroundDetector.isForegrounded()) {
      navigate(paramLocation);
    }
  }
  
  public void rideCanceled()
  {
    vibrator.vibrate(0, 250L, new Long[] { Long.valueOf(250L), Long.valueOf(250L), Long.valueOf(1000L) });
    soundManager.play(2);
    dialogFlow.show(new Toast(resources.getString(2131166267)));
  }
  
  public void rideRemoved()
  {
    vibrator.vibrate(0, 250L, new Long[] { Long.valueOf(250L), Long.valueOf(250L), Long.valueOf(1000L) });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.driver.notifications.DriverNotificationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */