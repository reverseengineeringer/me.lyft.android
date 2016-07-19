package me.lyft.android.ui.settings;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import javax.inject.Inject;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driverdocuments.Registration;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.camera.CameraScreens.CameraOtherDocumentsScreen;
import me.lyft.android.ui.photo.PhotoPickerDialog;
import me.lyft.android.utils.FileUtils;

public class VehicleRegistrationController
  extends RxViewController
{
  private static final String TEMPORARY_VEHICLE_REGISTRATION_PHOTO_NAME = "vehicle_registration.jpg";
  @Inject
  DialogFlow dialogFlow;
  @Inject
  ImageLoader imageLoader;
  private SettingsScreens.CarScreen params;
  TextView registrationTextView;
  Toolbar toolbar;
  Button updateButton;
  ImageView vehicleInspectionPhotoImageView;
  @Inject
  IVehicleService vehicleService;
  
  private File getTemporaryInsurancePhotoFile()
  {
    return FileUtils.getTemporaryFile(getView().getContext(), "vehicle_registration.jpg");
  }
  
  private void loadDocumentImage(Registration paramRegistration)
  {
    if (paramRegistration.getPhotoFile() == null) {}
    for (paramRegistration = imageLoader.load(paramRegistration.getPhotoUrl());; paramRegistration = imageLoader.load(paramRegistration.getPhotoFile()))
    {
      paramRegistration.fit().placeholder(2130838189).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[] { MemoryPolicy.NO_STORE }).into(vehicleInspectionPhotoImageView);
      return;
    }
  }
  
  private void refreshViews(Registration paramRegistration)
  {
    if ((paramRegistration.isNull()) || (Strings.isNullOrEmpty(paramRegistration.getPhotoUrl())))
    {
      registrationTextView.setText(getResources().getString(2131166409));
      registrationTextView.setVisibility(0);
      updateButton.setText(2131165591);
      return;
    }
    registrationTextView.setVisibility(8);
    updateButton.setText(2131165590);
  }
  
  private void showUpdateDialog()
  {
    PhotoPickerDialog localPhotoPickerDialog = new PhotoPickerDialog(getResources().getString(2131166410), new CameraScreens.CameraOtherDocumentsScreen(), new SettingsScreens.VehicleRegistrationScreen(params.getVehicle()), new SettingsScreens.CapturedCarDocumentScreen(params.getVehicle(), SettingsScreens.CapturedCarDocumentScreen.DocumentType.VEHICLE_REGISTRATION), getTemporaryInsurancePhotoFile());
    dialogFlow.show(localPhotoPickerDialog);
  }
  
  protected int layoutId()
  {
    return 2130903452;
  }
  
  public void onAttach()
  {
    super.onAttach();
    params = ((SettingsScreens.CarScreen)Screen.fromController(this));
    toolbar.setTitle(getResources().getString(2131165370));
    Registration localRegistration;
    Button localButton;
    if (vehicleService.getUpdatedVehicle().isNull())
    {
      localRegistration = params.getVehicle().getRegistration();
      localButton = updateButton;
      if (!localRegistration.isPending()) {
        break label120;
      }
    }
    label120:
    for (int i = 8;; i = 0)
    {
      localButton.setVisibility(i);
      updateButton.setOnClickListener(new VehicleRegistrationController.1(this));
      refreshViews(localRegistration);
      loadDocumentImage(localRegistration);
      return;
      localRegistration = vehicleService.getUpdatedVehicle().getRegistration();
      break;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.VehicleRegistrationController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */