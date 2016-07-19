package me.lyft.android.ui.driver.vehicles;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driver.Vehicle.Status;
import me.lyft.android.domain.driverdocuments.Inspection;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.domain.driverdocuments.Registration;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.settings.SettingsScreens.CarScreen;
import me.lyft.android.ui.settings.SettingsScreens.PersonalInsuranceScreen;
import me.lyft.android.utils.WebBrowser;

public class CarController
  extends RxViewController
{
  @Inject
  AppFlow appFlow;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  ImageLoader imageLoader;
  TextView licensePlateText;
  private SettingsScreens.CarScreen params;
  TextView personalInspectionStatusText;
  TextView personalInsuranceStatusText;
  View personalInsuranceView;
  TextView personalRegistrationStatusText;
  ImageView photoImageView;
  @Inject
  IProgressController progressController;
  Toolbar toolbar;
  Button useThisVehicleButton;
  @Inject
  IUserProvider userProvider;
  private Vehicle vehicle;
  View vehicleInspectionView;
  View vehicleRegistrationView;
  @Inject
  IVehicleService vehicleService;
  VehicleStatusTextView vehicleStatusTextView;
  TextView vehicleText;
  @Inject
  IViewErrorHandler viewErrorHandler;
  @Inject
  WebBrowser webBrowser;
  
  private void fetchVehicle(String paramString)
  {
    progressController.showProgress();
    binder.bindAsyncCall(vehicleService.getVehicleById(paramString), new CarController.1(this));
  }
  
  private String getLicensePlateStr(Vehicle paramVehicle)
  {
    String str2 = paramVehicle.getLicensePlate();
    String str1 = str2;
    if (!Strings.isNullOrEmpty(paramVehicle.getState())) {
      str1 = str2 + " (" + paramVehicle.getState() + ")";
    }
    return str1;
  }
  
  private String getVehicleStr(Vehicle paramVehicle)
  {
    return Strings.joinWithDelimiter(" ", new String[] { Strings.capitalizeWord(paramVehicle.getColor()), paramVehicle.getYearFormatted(), paramVehicle.getMake(), paramVehicle.getModel() });
  }
  
  private void initData()
  {
    toolbar.setTitle(vehicle.getMakeModel());
    refreshVehicleViews(vehicle.getStatus());
    useThisVehicleButton.setOnClickListener(new CarController.2(this));
    imageLoader.load(vehicle.getPhoto()).fit().placeholder(2130838465).into(photoImageView);
    String str = getVehicleStr(vehicle);
    vehicleText.setText(str);
    str = getLicensePlateStr(vehicle);
    licensePlateText.setText(str);
    vehicleInspectionView.setOnClickListener(new CarController.3(this));
    vehicleRegistrationView.setOnClickListener(new CarController.4(this));
    refreshVehicleDocumentViews(vehicle);
  }
  
  private void initInspectionStatus(Inspection paramInspection)
  {
    TextView localTextView = personalInspectionStatusText;
    Resources localResources;
    if ((paramInspection.isNull()) || (paramInspection.isApproved()) || (paramInspection.isNone()))
    {
      i = 8;
      localTextView.setVisibility(i);
      personalInspectionStatusText.setText(Strings.capitalizeWord(paramInspection.getStatusString()));
      localTextView = personalInspectionStatusText;
      localResources = getResources();
      if (!paramInspection.isPending()) {
        break label86;
      }
    }
    label86:
    for (int i = 2131492996;; i = 2131493054)
    {
      localTextView.setTextColor(localResources.getColor(i));
      return;
      i = 0;
      break;
    }
  }
  
  private void initInsuranceStatus(Insurance paramInsurance)
  {
    TextView localTextView = personalInsuranceStatusText;
    Resources localResources;
    if ((paramInsurance.isNull()) || (paramInsurance.isApproved()) || (paramInsurance.isNone()))
    {
      i = 8;
      localTextView.setVisibility(i);
      personalInsuranceStatusText.setText(Strings.capitalizeWord(paramInsurance.getStatusString()));
      localTextView = personalInsuranceStatusText;
      localResources = getResources();
      if (!paramInsurance.isPending()) {
        break label86;
      }
    }
    label86:
    for (int i = 2131492996;; i = 2131493054)
    {
      localTextView.setTextColor(localResources.getColor(i));
      return;
      i = 0;
      break;
    }
  }
  
  private void initRegistrationStatus(Registration paramRegistration)
  {
    TextView localTextView = personalRegistrationStatusText;
    Resources localResources;
    if ((paramRegistration.isNull()) || (paramRegistration.isApproved()) || (paramRegistration.isNone()))
    {
      i = 8;
      localTextView.setVisibility(i);
      personalRegistrationStatusText.setText(Strings.capitalizeWord(paramRegistration.getStatusString()));
      localTextView = personalRegistrationStatusText;
      localResources = getResources();
      if (!paramRegistration.isPending()) {
        break label86;
      }
    }
    label86:
    for (int i = 2131492996;; i = 2131493054)
    {
      localTextView.setTextColor(localResources.getColor(i));
      return;
      i = 0;
      break;
    }
  }
  
  private void refreshVehicleDocumentViews(Vehicle paramVehicle)
  {
    int j = 8;
    if (!userProvider.getUser().isDriverDocumentsEnabled())
    {
      personalInsuranceView.setVisibility(8);
      vehicleRegistrationView.setVisibility(8);
      vehicleInspectionView.setVisibility(8);
      initInsuranceStatus(paramVehicle.getInsurance());
      initInspectionStatus(paramVehicle.getInspection());
      initRegistrationStatus(paramVehicle.getRegistration());
      return;
    }
    View localView = vehicleRegistrationView;
    if (paramVehicle.getRegistration().isNull())
    {
      i = 8;
      label89:
      localView.setVisibility(i);
      localView = vehicleInspectionView;
      if (!paramVehicle.getInspection().isNull()) {
        break label127;
      }
    }
    label127:
    for (int i = j;; i = 0)
    {
      localView.setVisibility(i);
      break;
      i = 0;
      break label89;
    }
  }
  
  private void refreshVehicleViews(Vehicle.Status paramStatus)
  {
    int j = 0;
    Object localObject = vehicleStatusTextView;
    if (Vehicle.Status.APPROVED.equals(paramStatus))
    {
      i = 8;
      label21:
      ((VehicleStatusTextView)localObject).setVisibility(i);
      localObject = useThisVehicleButton;
      if (!Vehicle.Status.APPROVED.equals(paramStatus)) {
        break label90;
      }
    }
    label90:
    for (int i = j;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      switch (CarController.5.$SwitchMap$me$lyft$android$domain$driver$Vehicle$Status[paramStatus.ordinal()])
      {
      default: 
        return;
        i = 0;
        break label21;
      }
    }
    vehicleStatusTextView.setInUseView();
    return;
    vehicleStatusTextView.setUpdateView();
    return;
    vehicleStatusTextView.setPendingView();
  }
  
  private void setVehicle(Vehicle paramVehicle)
  {
    vehicle = paramVehicle;
  }
  
  protected int layoutId()
  {
    return 2130903086;
  }
  
  public void onAttach()
  {
    super.onAttach();
    params = ((SettingsScreens.CarScreen)Screen.fromController(this));
    if (params.getVehicleId().isEmpty())
    {
      if (vehicleService.getUpdatedVehicle().isNull()) {}
      for (Vehicle localVehicle = params.getVehicle();; localVehicle = vehicleService.getUpdatedVehicle())
      {
        vehicle = localVehicle;
        initData();
        return;
      }
    }
    fetchVehicle(params.getVehicleId());
  }
  
  public void onLyftInsuranceClicked()
  {
    webBrowser.open((String)constantsProvider.get(Constants.INSURANCE_HELP_CENTER_URL));
  }
  
  public void onPersonalInsuranceClicked()
  {
    appFlow.goTo(new SettingsScreens.PersonalInsuranceScreen(vehicle));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.vehicles.CarController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */