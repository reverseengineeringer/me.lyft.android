package me.lyft.android.ui.settings;

import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driverdocuments.Inspection;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.domain.driverdocuments.Registration;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.camera.CaptureResultView;

public class CapturedCarDocumentPreviewController
  extends RxViewController
{
  @Inject
  AppFlow appFlow;
  @Inject
  ICaptureImageSession captureImageSession;
  CaptureResultView captureResultView;
  @Inject
  DialogFlow dialogFlow;
  private SettingsScreens.CapturedCarDocumentScreen params;
  @Inject
  IProgressController progressController;
  @Inject
  IVehicleService vehicleService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  private void uploadInspectionPhoto()
  {
    progressController.showProgress();
    Object localObject = params.getVehicle().getInspection().getPhotoUploadUrl();
    localObject = new Inspection((String)localObject, (String)localObject, null);
    binder.bindAsyncCall(vehicleService.updateInspection(params.getVehicle().getId(), (Inspection)localObject, captureImageSession.getImage()), new CapturedCarDocumentPreviewController.2(this));
  }
  
  private void uploadRegistrationPhoto()
  {
    progressController.showProgress();
    Object localObject = params.getVehicle().getInsurance().getPhotoUploadUrl();
    localObject = new Registration((String)localObject, (String)localObject, null);
    binder.bindAsyncCall(vehicleService.updateRegistration(params.getVehicle().getId(), (Registration)localObject, captureImageSession.getImage()), new CapturedCarDocumentPreviewController.3(this));
  }
  
  protected int layoutId()
  {
    return 2130903083;
  }
  
  public void onAttach()
  {
    super.onAttach();
    params = ((SettingsScreens.CapturedCarDocumentScreen)Screen.fromController(this));
    captureResultView.setOnSaveListener(new CapturedCarDocumentPreviewController.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.CapturedCarDocumentPreviewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */