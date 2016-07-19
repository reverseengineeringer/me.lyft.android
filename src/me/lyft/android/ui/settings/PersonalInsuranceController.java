package me.lyft.android.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DateUtils;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.infrastructure.photo.IPhotoPickerService;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.camera.CameraScreens.CameraPersonalInsurance;
import me.lyft.android.ui.photo.PhotoPickerDialog;
import me.lyft.android.utils.FileUtils;
import rx.functions.Action1;

public class PersonalInsuranceController
  extends RxViewController
{
  public static final DateFormat DATE_UI_FORMAT = DateUtils.createDateFormat("MM/dd/yyyy");
  public static final String STATUS_FORMAT = " (%s)";
  public static final String TEMPORARY_INSURANCE_PHOTO_NAME = "insurance_photo.jpg";
  private final AppFlow appFlow;
  private final DialogFlow dialogFlow;
  TextView expirationDateTextView;
  private final ImageLoader imageLoader;
  TableLayout insuranceInfoTableLayout;
  ImageView insurancePhoto;
  private final ILyftPreferences lyftPreferences;
  TextView noInsuranceTextView;
  private Action1<Unit> onFilePicked = new PersonalInsuranceController.1(this);
  private SettingsScreens.CarScreen params;
  private final IPhotoPickerService photoPickerService;
  TextView requirementsLinkTextView;
  TextView stateTextView;
  View statusBannerContainer;
  TextView statusBannerTextView;
  Toolbar toolbar;
  Button updateInsuranceButton;
  private Vehicle vehicle;
  private final IVehicleService vehicleService;
  
  @Inject
  public PersonalInsuranceController(AppFlow paramAppFlow, DialogFlow paramDialogFlow, ILyftPreferences paramILyftPreferences, ImageLoader paramImageLoader, IPhotoPickerService paramIPhotoPickerService, IVehicleService paramIVehicleService)
  {
    appFlow = paramAppFlow;
    dialogFlow = paramDialogFlow;
    lyftPreferences = paramILyftPreferences;
    imageLoader = paramImageLoader;
    photoPickerService = paramIPhotoPickerService;
    vehicleService = paramIVehicleService;
  }
  
  private File getTemporaryInsurancePhotoFile()
  {
    return FileUtils.getTemporaryFile(getView().getContext(), "insurance_photo.jpg");
  }
  
  private void init()
  {
    binder.bindAction(photoPickerService.observePhotoPickerResult(), onFilePicked);
    requirementsLinkTextView.setOnClickListener(new PersonalInsuranceController.2(this));
    updateInsuranceButton.setOnClickListener(new PersonalInsuranceController.3(this));
    updateInsuranceInfo();
    toolbar.setTitle(getResources().getString(2131166128));
  }
  
  private void loadDocumentImage(Insurance paramInsurance)
  {
    if (paramInsurance.getPhotoFile() == null) {}
    for (paramInsurance = imageLoader.load(paramInsurance.getPhotoUrl());; paramInsurance = imageLoader.load(paramInsurance.getPhotoFile()))
    {
      paramInsurance.fit().placeholder(2130838189).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[] { MemoryPolicy.NO_STORE }).into(insurancePhoto);
      return;
    }
  }
  
  private void openInsuranceRequirements()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(lyftPreferences.getLyftWebRoot() + "/drive/help/article/1517270"));
    localIntent.addFlags(268435456);
    getView().getContext().startActivity(localIntent);
  }
  
  private void showUpdateDialog()
  {
    PhotoPickerDialog localPhotoPickerDialog = new PhotoPickerDialog(getResources().getString(2131166120), new CameraScreens.CameraPersonalInsurance(), new SettingsScreens.PersonalInsuranceScreen(vehicle), new SettingsScreens.CapturedPersonalInsuranceScreen(vehicle), getTemporaryInsurancePhotoFile());
    dialogFlow.show(localPhotoPickerDialog);
  }
  
  private void updateInsuranceInfo()
  {
    if (vehicleService.getUpdatedVehicle().isNull()) {}
    for (Insurance localInsurance = vehicle.getInsurance(); (localInsurance.isNull()) || (Strings.isNullOrEmpty(localInsurance.getPhotoUrl())); localInsurance = vehicleService.getUpdatedVehicle().getInsurance())
    {
      noInsuranceTextView.setText(Html.fromHtml(getResources().getString(2131166119)));
      noInsuranceTextView.setVisibility(0);
      insuranceInfoTableLayout.setVisibility(8);
      statusBannerContainer.setVisibility(8);
      updateInsuranceButton.setEnabled(true);
      updateInsuranceButton.setText(2131165591);
      return;
    }
    noInsuranceTextView.setVisibility(8);
    insuranceInfoTableLayout.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localInsurance.getExpirationDate();
    if (localObject != null) {
      localStringBuilder.append(DATE_UI_FORMAT.format(new Date(((Date)localObject).getTime())));
    }
    if (localInsurance.isApproved())
    {
      statusBannerContainer.setVisibility(8);
      expirationDateTextView.setTextColor(getResources().getColor(2131492980));
    }
    for (;;)
    {
      expirationDateTextView.setText(localStringBuilder.toString());
      stateTextView.setText(localInsurance.getState());
      loadDocumentImage(localInsurance);
      return;
      if ((localInsurance.isExpired()) || (localInsurance.isRejected()))
      {
        label270:
        TextView localTextView;
        if (localInsurance.isExpired())
        {
          localObject = getResources().getString(2131165587);
          localStringBuilder.append(String.format(" (%s)", new Object[] { localObject }));
          expirationDateTextView.setTextColor(getResources().getColor(2131493054));
          statusBannerTextView.setCompoundDrawablesWithIntrinsicBounds(2130838125, 0, 0, 0);
          localTextView = statusBannerTextView;
          if (!localInsurance.isExpired()) {
            break label365;
          }
        }
        label365:
        for (localObject = getResources().getString(2131166125);; localObject = getResources().getString(2131166127))
        {
          localTextView.setText((CharSequence)localObject);
          break;
          localObject = getResources().getString(2131165589);
          break label270;
        }
      }
      localStringBuilder.append(String.format(" (%s)", new Object[] { getResources().getString(2131165588) }));
      expirationDateTextView.setTextColor(getResources().getColor(2131492980));
      statusBannerTextView.setCompoundDrawablesWithIntrinsicBounds(2130838124, 0, 0, 0);
      statusBannerTextView.setText(getResources().getString(2131166126));
      requirementsLinkTextView.setVisibility(8);
      updateInsuranceButton.setVisibility(8);
    }
  }
  
  protected int layoutId()
  {
    return 2130903377;
  }
  
  public void onAttach()
  {
    super.onAttach();
    params = ((SettingsScreens.CarScreen)Screen.fromController(this));
    vehicle = params.getVehicle();
    init();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.PersonalInsuranceController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */