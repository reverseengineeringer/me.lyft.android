package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.payment.FacebookChargeAccount;

@Layout(2130903204)
public class PaymentScreens$EditFacebookCreditCardScreen
  extends PaymentScreens
{
  private final FacebookChargeAccount chargeAccount;
  
  public PaymentScreens$EditFacebookCreditCardScreen(FacebookChargeAccount paramFacebookChargeAccount)
  {
    chargeAccount = paramFacebookChargeAccount;
  }
  
  public FacebookChargeAccount getChargeAccount()
  {
    return chargeAccount;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.EditFacebookCreditCardScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */