package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import com.lyft.rx.MessageBus;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.driver.notifications.IDriverNotificationService;
import me.lyft.android.events.RideStatusChangedEvent;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.instabug.IInstabugService;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.MainActivity;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.settings.SettingsScreens.TrainingRideStartScreen;
import me.lyft.android.utils.SoundManager;

public class RideStatusChangedJob
  implements Job
{
  @Inject
  AppFlow appFlow;
  @Inject
  IAppForegroundDetector appForegroundDetector;
  @Inject
  LyftApplication application;
  @Inject
  MessageBus bus;
  @Inject
  IConstantsProvider constantsProvider;
  private final UniversalDTO currentAppState;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IDriverNotificationService driverNotificationService;
  @Inject
  IDriverRideProvider driverRideProvider;
  @Inject
  InAppNotificationService inAppNotificationService;
  @Inject
  IInstabugService instabug;
  @Inject
  MainScreensRouter mainScreensRouter;
  private final UniversalDTO previousAppState;
  @Inject
  SoundManager soundManager;
  
  public RideStatusChangedJob(UniversalDTO paramUniversalDTO1, UniversalDTO paramUniversalDTO2)
  {
    previousAppState = paramUniversalDTO1;
    currentAppState = paramUniversalDTO2;
  }
  
  private void checkCancelationForDriverUser(RideDTO paramRideDTO)
  {
    if (isRideCanceled(paramRideDTO)) {
      driverNotificationService.rideCanceled();
    }
    if ((isRidePending(paramRideDTO)) || (isRideCanceled(paramRideDTO)))
    {
      if (appForegroundDetector.isForegrounded()) {
        instabug.dismissIfShowing();
      }
    }
    else {
      return;
    }
    MainActivity.foregroundActivity(application, "ride_status_changed");
  }
  
  private void checkCancelationForPassengerUser(RideDTO paramRideDTO1, RideDTO paramRideDTO2, UserDTO paramUserDTO)
  {
    int i;
    if ((paramRideDTO1 != null) && (Objects.equals(rideTypePublicId, "lyft_carpool")) && (Objects.equals(userMode, "driver")))
    {
      i = 1;
      if (!"canceledNoShow".equalsIgnoreCase(status)) {
        break label98;
      }
      showCourierPassengerNoShowDialog();
    }
    for (;;)
    {
      if (("accepted".equalsIgnoreCase(status)) || ("approaching".equalsIgnoreCase(status)) || ("droppedOff".equalsIgnoreCase(status))) {
        soundManager.play(1);
      }
      return;
      i = 0;
      break;
      label98:
      if ((isRideCanceled(paramRideDTO2)) && (appForegroundDetector.isForegrounded()))
      {
        soundManager.play(2);
        dialogFlow.show(new Toast(application.getString(2131166267)));
      }
      else if ((isRideLapsed(paramRideDTO2)) && (i == 0))
      {
        showRideLapsedDialog();
      }
      else if (("accepted".equalsIgnoreCase(status)) || ("approaching".equalsIgnoreCase(status)))
      {
        inAppNotificationService.showNotificationIfAvailable("passenger_ride_accept");
      }
    }
  }
  
  private void checkCancellation(RideDTO paramRideDTO1, RideDTO paramRideDTO2)
  {
    UserDTO localUserDTO = currentAppState.user;
    if ("driver".equalsIgnoreCase(getUserMode()))
    {
      checkCancelationForDriverUser(paramRideDTO2);
      return;
    }
    checkCancelationForPassengerUser(paramRideDTO1, paramRideDTO2, localUserDTO);
  }
  
  private String getUserMode()
  {
    if (currentAppState.user == null) {
      return null;
    }
    return currentAppState.user.mode;
  }
  
  private boolean isCancelledTrainingRide(RideDTO paramRideDTO1, RideDTO paramRideDTO2)
  {
    if ((paramRideDTO1 != null) && (((Boolean)Objects.firstNonNull(isTrainingRide, Boolean.valueOf(false))).booleanValue())) {
      if (Arrays.asList(new String[] { "canceled", "lapsed" }).contains(status)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isRideCanceled(RideDTO paramRideDTO)
  {
    return Arrays.asList(new String[] { "canceled", "canceledNoShow", "canceledWithPenalty", "canceledWrongPartySize" }).contains(status);
  }
  
  private static boolean isRideLapsed(RideDTO paramRideDTO)
  {
    return "lapsed".equalsIgnoreCase(status);
  }
  
  private static boolean isRidePending(RideDTO paramRideDTO)
  {
    return "pending".equalsIgnoreCase(status);
  }
  
  private void postRideStatusChanged(RideDTO paramRideDTO1, RideDTO paramRideDTO2)
  {
    bus.post(RideStatusChangedEvent.class, paramRideDTO2);
    checkCancellation(paramRideDTO1, paramRideDTO2);
    if (isCancelledTrainingRide(paramRideDTO1, paramRideDTO2)) {
      appFlow.goTo(new SettingsScreens.TrainingRideStartScreen());
    }
    while ((!isRideCanceled(paramRideDTO2)) && (!isRidePending(paramRideDTO2)) && (!isRideLapsed(paramRideDTO2))) {
      return;
    }
    mainScreensRouter.resetToHomeScreen();
  }
  
  private void showCourierPassengerNoShowDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("courier_passenger_no_show_dialog");
    String str = (String)constantsProvider.get(Constants.COURIER_NO_SHOW_PENALTY_MESSAGE, application.getString(2131165497));
    localAlertDialog.setTitle(application.getString(2131165498)).setTitleColorResource(2131493111).addNegativeButton(application.getString(2131165939)).setMessage(str);
    dialogFlow.show(localAlertDialog);
  }
  
  private void showRideLapsedDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("ride_lapsed_dialog");
    localAlertDialog.setTitle(application.getString(2131166007)).setTitleColorResource(2131493111).setMessage(application.getString(2131166006)).addPositiveButton(application.getString(2131165939));
    dialogFlow.show(localAlertDialog);
  }
  
  public void execute()
    throws Throwable
  {
    RideDTO localRideDTO1 = previousAppState.ride;
    RideDTO localRideDTO2 = currentAppState.ride;
    if (driverRideProvider.shouldIgnoreRide(localRideDTO2)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (localRideDTO2 == null) {
            break;
          }
        } while ((localRideDTO1 != null) && (Strings.equalsIgnoreCase(id, id)) && (status.equalsIgnoreCase(status)));
        postRideStatusChanged(localRideDTO1, localRideDTO2);
        return;
      } while (localRideDTO1 == null);
      if ("driver".equalsIgnoreCase(getUserMode())) {
        driverNotificationService.rideRemoved();
      }
    } while (appForegroundDetector.isForegrounded());
    MainActivity.foregroundActivity(application, "ride_canceled");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideStatusChangedJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */