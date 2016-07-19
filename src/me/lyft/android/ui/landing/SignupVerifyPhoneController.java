package me.lyft.android.ui.landing;

import android.content.res.Resources;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.RxUIBinder;

public class SignupVerifyPhoneController
  extends RxViewController
{
  private final LandingFlow landingFlow;
  VerifyPhoneNumberView phoneVerifyView;
  Toolbar toolbar;
  
  @Inject
  public SignupVerifyPhoneController(LandingFlow paramLandingFlow)
  {
    landingFlow = paramLandingFlow;
  }
  
  protected int layoutId()
  {
    return 2130903273;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.showTitle().setTitle(getResources().getString(2131165866)).addItem(2131558445, getResources().getString(2131165934), 0, getResources().getColor(2131493004), 1);
    LandingScreens.SignupVerifyPhoneScreen localSignupVerifyPhoneScreen = (LandingScreens.SignupVerifyPhoneScreen)Screen.fromController(this);
    phoneVerifyView.setPhoneNumberForVerification(localSignupVerifyPhoneScreen.getPhoneNumber());
    binder.bindAction(phoneVerifyView.observeVerificationCompleted(), new SignupVerifyPhoneController.1(this));
    binder.bindAction(toolbar.observeItemClick(), new SignupVerifyPhoneController.2(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.SignupVerifyPhoneController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */