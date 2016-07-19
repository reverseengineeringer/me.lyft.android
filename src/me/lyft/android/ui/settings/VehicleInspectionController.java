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
import me.lyft.android.domain.driverdocuments.Inspection;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.camera.CameraScreens.CameraOtherDocumentsScreen;
import me.lyft.android.ui.photo.PhotoPickerDialog;
import me.lyft.android.utils.FileUtils;

public class VehicleInspectionController
  extends RxViewController
{
  private static final String TEMPORARY_VEHICLE_INSPECTION_PHOTO_NAME = "vehicle_inspection.jpg";
  @Inject
  DialogFlow dialogFlow;
  @Inject
  ImageLoader imageLoader;
  TextView inspectionTextView;
  private SettingsScreens.CarScreen params;
  Toolbar toolbar;
  Button updateButton;
  ImageView vehicleInspectionPhotoImageView;
  @Inject
  IVehicleService vehicleService;
  
  private File getTemporaryInsurancePhotoFile()
  {
    return FileUtils.getTemporaryFile(getView().getContext(), "vehicle_inspection.jpg");
  }
  
  private void loadDocumentImage(Inspection paramInspection)
  {
    if (paramInspection.getPhotoFile() == null) {}
    for (paramInspection = imageLoader.load(paramInspection.getPhotoUrl());; paramInspection = imageLoader.load(paramInspection.getPhotoFile()))
    {
      paramInspection.fit().placeholder(2130838189).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[] { MemoryPolicy.NO_STORE }).into(vehicleInspectionPhotoImageView);
      return;
    }
  }
  
  private void refreshViews(Inspection paramInspection)
  {
    if ((paramInspection.isNull()) || (Strings.isNullOrEmpty(paramInspection.getPhotoUrl())))
    {
      inspectionTextView.setText(getResources().getString(2131166407));
      inspectionTextView.setVisibility(0);
      updateButton.setText(2131165591);
      return;
    }
    if (paramInspection.isPending())
    {
      inspectionTextView.setText(getResources().getString(2131166406));
      inspectionTextView.setVisibility(0);
      updateButton.setVisibility(8);
      return;
    }
    inspectionTextView.setVisibility(8);
    updateButton.setText(2131165590);
  }
  
  private void showUpdateDialog()
  {
    PhotoPickerDialog localPhotoPickerDialog = new PhotoPickerDialog(getResources().getString(2131166408), new CameraScreens.CameraOtherDocumentsScreen(), new SettingsScreens.VehicleInspectionScreen(params.getVehicle()), new SettingsScreens.CapturedCarDocumentScreen(params.getVehicle(), SettingsScreens.CapturedCarDocumentScreen.DocumentType.VEHICLE_INSPECTION), getTemporaryInsurancePhotoFile());
    dialogFlow.show(localPhotoPickerDialog);
  }
  
  protected int layoutId()
  {
    return 2130903451;
  }
  
  public void onAttach()
  {
    super.onAttach();
    params = ((SettingsScreens.CarScreen)Screen.fromController(this));
    toolbar.setTitle(getResources().getString(2131165369));
    updateButton.setOnClickListener(new VehicleInspectionController.1(this));
    if (vehicleService.getUpdatedVehicle().isNull()) {}
    for (Inspection localInspection = params.getVehicle().getInspection();; localInspection = vehicleService.getUpdatedVehicle().getInspection())
    {
      refreshViews(localInspection);
      loadDocumentImage(localInspection);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.VehicleInspectionController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */