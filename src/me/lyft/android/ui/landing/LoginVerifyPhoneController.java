package me.lyft.android.ui.landing;

import android.content.res.Resources;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.RxUIBinder;

public class LoginVerifyPhoneController
  extends RxViewController
{
  private final LandingFlow landingFlow;
  VerifyPhoneNumberView phoneVerifyView;
  Toolbar toolbar;
  
  @Inject
  public LoginVerifyPhoneController(LandingFlow paramLandingFlow)
  {
    landingFlow = paramLandingFlow;
  }
  
  protected int layoutId()
  {
    return 2130903269;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.showTitle().setTitle(getResources().getString(2131165866)).addItem(2131558445, getResources().getString(2131165934), 0, getResources().getColor(2131493004), 1);
    LandingScreens.LoginVerifyPhoneScreen localLoginVerifyPhoneScreen = (LandingScreens.LoginVerifyPhoneScreen)Screen.fromController(this);
    phoneVerifyView.setPhoneNumberForVerification(localLoginVerifyPhoneScreen.getPhoneNumber());
    binder.bindAction(phoneVerifyView.observeVerificationCompleted(), new LoginVerifyPhoneController.1(this));
    binder.bindAction(toolbar.observeItemClick(), new LoginVerifyPhoneController.2(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LoginVerifyPhoneController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */