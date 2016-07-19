package me.lyft.android.ui.landing;

import android.content.res.Resources;
import javax.inject.Inject;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.RxUIBinder;

public class SignupPhoneController
  extends RxViewController
{
  EnterPhoneView enterPhoneView;
  private final LandingFlow landingFlow;
  Toolbar toolbar;
  
  @Inject
  public SignupPhoneController(LandingFlow paramLandingFlow)
  {
    landingFlow = paramLandingFlow;
  }
  
  protected int layoutId()
  {
    return 2130903272;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.setTitle(getResources().getString(2131165859)).addItem(2131558445, getResources().getString(2131165934), 0, getResources().getColor(2131493004), 1);
    binder.bindAction(toolbar.observeItemClick(), new SignupPhoneController.1(this));
    binder.bindAction(enterPhoneView.observeVerificationRequested(), new SignupPhoneController.2(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.SignupPhoneController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */