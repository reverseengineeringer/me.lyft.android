package me.lyft.android.controls;

import android.view.View;
import android.view.View.OnClickListener;
import me.lyft.android.common.AppFlow;
import me.lyft.android.ui.landing.LandingScreens.CountryPickerScreen;

class PhoneInputView$2
  implements View.OnClickListener
{
  PhoneInputView$2(PhoneInputView paramPhoneInputView) {}
  
  public void onClick(View paramView)
  {
    this$0.appFlow.goTo(new LandingScreens.CountryPickerScreen());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.PhoneInputView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */