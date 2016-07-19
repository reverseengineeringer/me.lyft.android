package me.lyft.android.ui.landing;

import android.content.res.Resources;
import com.lyft.scoop.HandleBack;
import javax.inject.Inject;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.RxUIBinder;

public class LoginEnterInfoController
  extends RxViewController
  implements HandleBack
{
  EnterInfoView enterInfoView;
  private final LandingFlow landingFlow;
  Toolbar toolbar;
  
  @Inject
  public LoginEnterInfoController(LandingFlow paramLandingFlow)
  {
    landingFlow = paramLandingFlow;
  }
  
  public void goBack()
  {
    landingFlow.openLoginScreen();
  }
  
  protected int layoutId()
  {
    return 2130903267;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.showTitle().setTitle(getResources().getString(2131165853)).addItem(2131558445, getResources().getString(2131165934), 0, getResources().getColor(2131493004), 1);
    binder.bindAction(toolbar.observeHomeClick(), new LoginEnterInfoController.1(this));
    binder.bindAction(enterInfoView.observeSubmitProfile(), new LoginEnterInfoController.2(this));
    binder.bindAction(toolbar.observeItemClick(), new LoginEnterInfoController.3(this));
  }
  
  public boolean onBack()
  {
    goBack();
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LoginEnterInfoController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */