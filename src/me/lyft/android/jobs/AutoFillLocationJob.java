package me.lyft.android.jobs;

import android.content.res.Resources;
import com.lyft.android.api.dto.PrefillLocationsDTO;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.autofill.AutoFillResolutionService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.passenger.PassengerDialogs.AutoFillConfirmationDialog;

public class AutoFillLocationJob
  implements Job
{
  @Inject
  AutoFillResolutionService autoFillResolutionService;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  ILyftPreferences preferences;
  private final Location prefillDropoffLocation;
  private final Location prefillPickupLocation;
  @Inject
  Resources resources;
  private final String rideType;
  @Inject
  IUserUiService userService;
  
  public AutoFillLocationJob(PrefillLocationsDTO paramPrefillLocationsDTO)
  {
    if (paramPrefillLocationsDTO == null)
    {
      prefillPickupLocation = NullLocation.getInstance();
      prefillDropoffLocation = NullLocation.getInstance();
      rideType = null;
      return;
    }
    prefillPickupLocation = LocationMapper.fromPlaceDTO(pickup);
    prefillDropoffLocation = LocationMapper.fromPlaceDTO(dropoff);
    rideType = rideType;
  }
  
  public void execute()
    throws Throwable
  {
    if (userService.getUiState().isDriverUi()) {}
    while (!autoFillResolutionService.autoFill(prefillPickupLocation, prefillDropoffLocation, rideType)) {
      return;
    }
    if (!preferences.autoFillInfoDialogShown())
    {
      dialogFlow.show(new PassengerDialogs.AutoFillConfirmationDialog());
      return;
    }
    dialogFlow.show(new Toast(resources.getString(2131165313), Integer.valueOf(2130838126)));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.AutoFillLocationJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */