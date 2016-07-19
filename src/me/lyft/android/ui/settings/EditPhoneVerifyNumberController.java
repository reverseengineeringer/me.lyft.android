package me.lyft.android.ui.settings;

import android.widget.ImageButton;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.domain.Phone;
import me.lyft.android.domain.User;
import me.lyft.android.rx.RxUIBinder;

public class EditPhoneVerifyNumberController
  extends RxViewController
{
  @Inject
  AppFlow appFlow;
  ImageButton backButton;
  PhoneVerifyView phoneVerifyView;
  @Inject
  IUserProvider userProvider;
  
  protected int layoutId()
  {
    return 2130903414;
  }
  
  public void onAttach()
  {
    super.onAttach();
    phoneVerifyView.setPhoneNumberForVerification(userProvider.getUser().getPhone().getNumber());
    backButton.setOnClickListener(new EditPhoneVerifyNumberController.1(this));
    binder.bindAction(phoneVerifyView.observeVerificationCompleted(), new EditPhoneVerifyNumberController.2(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.EditPhoneVerifyNumberController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */