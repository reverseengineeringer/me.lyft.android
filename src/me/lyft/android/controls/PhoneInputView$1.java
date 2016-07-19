package me.lyft.android.controls;

import me.lyft.android.domain.system.Country;
import rx.functions.Action1;

class PhoneInputView$1
  implements Action1<Country>
{
  PhoneInputView$1(PhoneInputView paramPhoneInputView) {}
  
  public void call(Country paramCountry)
  {
    this$0.phoneEditText.setText("");
    PhoneInputView.access$002(this$0, paramCountry.getCountryCode());
    PhoneInputView.access$100(this$0);
    PhoneInputView.access$200(this$0);
    PhoneInputView.access$300(this$0);
    PhoneInputView.access$400(this$0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.PhoneInputView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */