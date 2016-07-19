package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.android.api.dto.PhoneDTO;
import com.lyft.googlemaps.core.util.Objects;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedEditText;
import com.lyft.widgets.AdvancedTextView;
import com.lyft.widgets.SimpleTextWatcher;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ats.IAtsService;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.Phone;
import me.lyft.android.domain.User;
import me.lyft.android.domain.ats.DriverApplication;
import me.lyft.android.domain.ats.DriverApplicationData;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.utils.WebBrowser;
import rx.Observable;
import rx.functions.Action1;

public class BecomeLyftDriverView
  extends LinearLayout
{
  private static final String REASON_INVALID_CODE = "invalidCode";
  @Inject
  IAtsService atsService;
  View becomeDriverContainer;
  private Binder binder;
  @Inject
  MessageBus bus;
  private boolean dataChanged = false;
  @Inject
  DialogFlow dialogFlow;
  private DriverApplication driverApplication;
  private DriverApplicationData driverApplicationData;
  AdvancedEditText driverReferralCodeTxt;
  TextView errorDetailsTxt;
  Button goToApplicationButton;
  @Inject
  ILyftPreferences lyftPreferences;
  private final Action1<DialogResult> onRegionSelectedDialogResult = new BecomeLyftDriverView.7(this);
  @Inject
  IProgressController progressController;
  private SimpleTextWatcher referralCodeTextWatcher;
  AdvancedTextView regionTxt;
  View retryView;
  private String selectedRegion;
  @Inject
  ISignUrlService signUrlService;
  BecomeDriverHelpToolbarView toolbar;
  @Inject
  IUserProvider userProvider;
  @Inject
  IViewErrorHandler viewErrorHandler;
  @Inject
  WebBrowser webBrowser;
  
  public BecomeLyftDriverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void initData()
  {
    driverApplication = ((DriverApplication)Objects.firstNonNull(driverApplication, DriverApplication.empty()));
    if (driverApplication != null) {
      selectedRegion = driverApplication.getRegion();
    }
    if (Strings.isNullOrEmpty(selectedRegion))
    {
      goToApplicationButton.setEnabled(false);
      if (Strings.isNullOrEmpty(driverApplication.getReferralCode())) {
        break label140;
      }
      driverReferralCodeTxt.setText(driverApplication.getReferralCode());
      driverReferralCodeTxt.setEnabled(false);
    }
    for (;;)
    {
      dataChanged = false;
      becomeDriverContainer.setVisibility(0);
      retryView.setVisibility(8);
      return;
      regionTxt.setText(driverApplicationData.findRegionLabelByCode(selectedRegion));
      goToApplicationButton.setEnabled(true);
      break;
      label140:
      driverReferralCodeTxt.setEnabled(true);
    }
  }
  
  private void loadRegions()
  {
    progressController.showProgress();
    binder.bind(atsService.getDriverApplicationData(), new BecomeLyftDriverView.4(this));
  }
  
  private void openWebOnboarding()
  {
    progressController.disableUI();
    progressController.showProgress();
    String str = lyftPreferences.getLyftWebRoot() + "/drivers?from_app=1";
    binder.bind(signUrlService.getSignedUrl(str), new BecomeLyftDriverView.6(this));
  }
  
  private void showRegionPicker()
  {
    Object localObject = driverApplicationData.getRegionLabels();
    localObject = new Dialogs.AlertDialog("driver_region_picker_dialog").setItems((List)localObject).setTitle(getResources().getString(2131166238)).setDialogEventClass(BecomeLyftDriverView.RegionSelectedDialogResultEvent.class);
    dialogFlow.show((Screen)localObject);
  }
  
  private void submitDriverApplication()
  {
    if ((!Strings.isNullOrEmpty(driverApplication.getRegion())) && (!dataChanged))
    {
      openWebOnboarding();
      return;
    }
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(updateDriverApplication(), new BecomeLyftDriverView.5(this));
  }
  
  private PhoneDTO toPhoneDTO(Phone paramPhone)
  {
    return new PhoneDTO(paramPhone.getNumber(), null, Boolean.valueOf(paramPhone.isVerificationNeeded()), null);
  }
  
  private Observable<DriverApplication> updateDriverApplication()
  {
    return atsService.updateDriverApplication(driverApplication.getSelf(), selectedRegion, toPhoneDTO(userProvider.getUser().getPhone()), driverReferralCodeTxt.getText().toString());
  }
  
  public void handleError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof LyftApiException))
    {
      Object localObject1 = (LyftApiException)paramThrowable;
      if ((((LyftApiException)localObject1).getStatusCode() == 422) && (((LyftApiException)localObject1).getLyftError().getErrors().size() > 0))
      {
        Object localObject2 = (LyftValidationError)((LyftApiException)localObject1).getLyftError().getErrors().get(0);
        localObject1 = ((LyftValidationError)localObject2).getField();
        localObject2 = ((LyftValidationError)localObject2).getReason();
        if ((((String)localObject1).equalsIgnoreCase("referralCode")) || (((String)localObject2).equalsIgnoreCase("invalidCode")))
        {
          driverReferralCodeTxt.setValidationErrorId(Integer.valueOf(2131165793));
          return;
        }
      }
    }
    viewErrorHandler.handle(paramThrowable);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    UxAnalytics.displayed(UiElement.DRIVER_ONBOARDING_VIEW).setTag(Category.DRIVER.toString()).track();
    toolbar.showHelpButton(true);
    goToApplicationButton.setEnabled(false);
    regionTxt.setOnClickListener(new BecomeLyftDriverView.1(this));
    goToApplicationButton.setOnClickListener(new BecomeLyftDriverView.2(this));
    driverReferralCodeTxt.setValidationMessageView(errorDetailsTxt);
    toolbar.setTitle(getResources().getString(2131165325));
    referralCodeTextWatcher = new BecomeLyftDriverView.3(this);
    driverReferralCodeTxt.addTextChangedListener(referralCodeTextWatcher);
    binder = Binder.attach(this);
    binder.bind(bus.observe(BecomeLyftDriverView.RegionSelectedDialogResultEvent.class), onRegionSelectedDialogResult);
    if (driverApplicationData == null)
    {
      loadRegions();
      return;
    }
    initData();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    driverReferralCodeTxt.removeTextChangedListener(referralCodeTextWatcher);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  void retry()
  {
    loadRegions();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.BecomeLyftDriverView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */