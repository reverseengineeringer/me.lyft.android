package me.lyft.android.ui.settings;

import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import com.lyft.widgets.AdvancedTextView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.RequestCreator;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.application.driverdocuments.StatesProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DateUtils;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.Dialogs.DatePickerDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.DatePickerDialogView.DateSelectedEvent;
import me.lyft.android.ui.dialogs.DatePickerDialogView.DateSelectedEventArgs;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.utils.WebBrowser;
import rx.functions.Action1;

public class CapturedPersonalInsuranceController
  extends RxViewController
  implements HandleBack
{
  public static final DateFormat DATE_UI_FORMAT = DateUtils.createDateFormat("MM/dd/yyyy");
  public static final String INSURANCE_STATE_PICKER_DIALOG = "insurance_state_picker_dialog";
  public static final String UNSAVED_CHANGES_DIALOG = "unsaved_changes_dialog";
  @Inject
  AppFlow appFlow;
  @Inject
  MessageBus bus;
  @Inject
  ICaptureImageSession captureImageSession;
  private final CompoundButton.OnCheckedChangeListener checkedChangeListener = new CapturedPersonalInsuranceController.1(this);
  ScrollView containerScrollView;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  ImageLoader imageLoader;
  AdvancedTextView insuranceExpirationTextView;
  ImageView insurancePhoto;
  View insurancePhotoUploadProgress;
  AdvancedTextView insuranceStateTextView;
  @Inject
  ILyftPreferences lyftPreferences;
  CheckBox matchCarCheckbox;
  CheckBox matchNameCheckbox;
  private Action1<DatePickerDialogView.DateSelectedEventArgs> onDateSelectedEvent = new CapturedPersonalInsuranceController.6(this);
  private Action1<Unit> onHomeClicked = new CapturedPersonalInsuranceController.7(this);
  private Action1<DialogResult> onStateSelected = new CapturedPersonalInsuranceController.5(this);
  private Action1<DialogResult> onUnsavedChangesResult = new CapturedPersonalInsuranceController.8(this);
  private SettingsScreens.CarScreen params;
  @Inject
  IProgressController progressController;
  private Date selectedInsuranceExpiration;
  private String selectedInsuranceStateCode;
  @Inject
  StatesProvider statesProvider;
  View submitButton;
  Toolbar toolbar;
  TextView validationErrorTextView;
  @Inject
  IVehicleService vehicleService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  @Inject
  WebBrowser webBrowser;
  
  private boolean checkValidInput()
  {
    boolean bool = true;
    String str1 = insuranceExpirationTextView.getText().toString();
    String str2 = insuranceStateTextView.getText().toString();
    int i;
    if (((!matchCarCheckbox.isChecked()) && (!matchNameCheckbox.isChecked())) || (!matchCarCheckbox.isChecked()))
    {
      showClickableValidationError();
      matchCarCheckbox.setTextColor(getResources().getColor(2131493054));
      CheckBox localCheckBox = matchNameCheckbox;
      Resources localResources = getResources();
      if (matchNameCheckbox.isChecked())
      {
        i = 2131492865;
        localCheckBox.setTextColor(localResources.getColor(i));
        bool = false;
      }
    }
    for (;;)
    {
      if ((Strings.isNullOrEmpty(str1)) || (Strings.isNullOrEmpty(str2)))
      {
        validationErrorTextView.setText(getResources().getString(2131166114));
        if (Strings.isNullOrEmpty(str1))
        {
          insuranceExpirationTextView.setValidationErrorId(Integer.valueOf(2131166131));
          insuranceExpirationTextView.setHintTextColor(getResources().getColor(2131493054));
        }
        if (Strings.isNullOrEmpty(str2))
        {
          insuranceStateTextView.setValidationErrorId(Integer.valueOf(2131166131));
          insuranceStateTextView.setHintTextColor(getResources().getColor(2131493054));
        }
        validationErrorTextView.setOnClickListener(null);
        validationErrorTextView.setVisibility(0);
        scrollViewDown();
        bool = false;
      }
      return bool;
      i = 2131493054;
      break;
      if (!matchNameCheckbox.isChecked())
      {
        matchNameCheckbox.setTextColor(getResources().getColor(2131493054));
        showClickableValidationError();
        validationErrorTextView.setText(Html.fromHtml(getResources().getString(2131166118)));
        bool = false;
      }
    }
  }
  
  private void displayPhoto()
  {
    imageLoader.load(captureImageSession.getImage()).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[] { MemoryPolicy.NO_STORE }).into(insurancePhoto);
  }
  
  private void enableUI()
  {
    insurancePhotoUploadProgress.setVisibility(8);
  }
  
  private void handleGoBack()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("unsaved_changes_dialog");
    localAlertDialog.setTitle(getResources().getString(2131166130)).setMessage(getResources().getString(2131166129)).setButtonsOrientation(Integer.valueOf(1)).addPositiveButton(getResources().getString(2131166433), 2130903156).addNegativeButton(getResources().getString(2131165935)).setDialogEventClass(CapturedPersonalInsuranceController.UnsavedChangesDialogResultEvent.class);
    dialogFlow.show(localAlertDialog);
  }
  
  private void onSubmitClicked()
  {
    if (!checkValidInput()) {
      return;
    }
    progressController.showProgress();
    Insurance localInsurance = new Insurance();
    localInsurance.setExpirationDate(selectedInsuranceExpiration);
    localInsurance.setState(selectedInsuranceStateCode);
    String str = params.getVehicle().getInsurance().getPhotoUploadUrl();
    localInsurance.setPhotoUploadUrl(str);
    localInsurance.setPhotoUrl(str);
    binder.bindAsyncCall(vehicleService.updateInsurance(params.getVehicle().getId(), localInsurance, captureImageSession.getImage()), new CapturedPersonalInsuranceController.9(this));
  }
  
  private void scrollViewDown()
  {
    containerScrollView.post(new CapturedPersonalInsuranceController.11(this));
  }
  
  private void showClickableValidationError()
  {
    validationErrorTextView.setVisibility(0);
    validationErrorTextView.setText(Html.fromHtml(getResources().getString(2131166115)));
    validationErrorTextView.setOnClickListener(new CapturedPersonalInsuranceController.10(this));
    scrollViewDown();
  }
  
  private void showInsuranceExpirationPicker()
  {
    Date localDate = selectedInsuranceExpiration;
    Object localObject = localDate;
    if (localDate == null) {
      localObject = new Date();
    }
    localObject = DateUtils.fromDate((Date)localObject);
    localObject = new Dialogs.DatePickerDialog(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5));
    ((Dialogs.DatePickerDialog)localObject).setDisablePastDate(true);
    dialogFlow.show((Screen)localObject);
  }
  
  private void showInsuranceStatePicker()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("insurance_state_picker_dialog");
    localAlertDialog.setItems(statesProvider.getStateLabels()).setTitle(getResources().getString(2131165435)).setDialogEventClass(CapturedPersonalInsuranceController.StateSelectedDialogResultEvent.class);
    dialogFlow.show(localAlertDialog);
  }
  
  protected int layoutId()
  {
    return 2130903084;
  }
  
  public void onAttach()
  {
    super.onAttach();
    params = ((SettingsScreens.CarScreen)Screen.fromController(this));
    toolbar.setTitle(getResources().getString(2131166128));
    insuranceExpirationTextView.setOnClickListener(new CapturedPersonalInsuranceController.2(this));
    insuranceStateTextView.setOnClickListener(new CapturedPersonalInsuranceController.3(this));
    matchCarCheckbox.setOnCheckedChangeListener(checkedChangeListener);
    matchNameCheckbox.setOnCheckedChangeListener(checkedChangeListener);
    submitButton.setOnClickListener(new CapturedPersonalInsuranceController.4(this));
    binder.bindAction(bus.observe(CapturedPersonalInsuranceController.StateSelectedDialogResultEvent.class), onStateSelected);
    binder.bindAction(bus.observe(DatePickerDialogView.DateSelectedEvent.class), onDateSelectedEvent);
    binder.bindAction(bus.observe(CapturedPersonalInsuranceController.UnsavedChangesDialogResultEvent.class), onUnsavedChangesResult);
    binder.bindAction(toolbar.observeHomeClick(), onHomeClicked);
    displayPhoto();
  }
  
  public boolean onBack()
  {
    handleGoBack();
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.CapturedPersonalInsuranceController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */