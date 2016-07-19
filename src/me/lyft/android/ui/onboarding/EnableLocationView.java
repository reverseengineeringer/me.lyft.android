package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.settings.ISettingsService;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;

public class EnableLocationView
  extends LinearLayout
{
  private Binder binder;
  @Inject
  IConstantsProvider constantsProvider;
  TextView enableLocationsMessage;
  TextView enableLocationsTitle;
  Button gotItButton;
  @Inject
  IProgressController progressController;
  @Inject
  CarpoolDriverOnboardingRouter router;
  @Inject
  ISettingsService settingsService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public EnableLocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void enabledDriverDispatch()
  {
    progressController.showProgress();
    binder.bind(settingsService.agreeToCoarseLocations(), new EnableLocationView.2(this));
  }
  
  private void goToNextScreen()
  {
    router.goToCompletedOnboarding();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    String str1 = getResources().getString(2131165402);
    String str2 = getResources().getString(2131165401);
    enableLocationsTitle.setText((CharSequence)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_LOCATION_SERVICES_TITLE, str1));
    enableLocationsMessage.setText((CharSequence)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_LOCATION_SERVICES_BODY, str2));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    gotItButton.setOnClickListener(new EnableLocationView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.EnableLocationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */