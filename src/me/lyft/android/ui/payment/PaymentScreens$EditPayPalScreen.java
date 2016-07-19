package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.payment.PayPalChargeAccount;

@Layout(2130903206)
public class PaymentScreens$EditPayPalScreen
  extends PaymentScreens
{
  private final PayPalChargeAccount chargeAccount;
  
  public PaymentScreens$EditPayPalScreen(PayPalChargeAccount paramPayPalChargeAccount)
  {
    chargeAccount = paramPayPalChargeAccount;
  }
  
  public PayPalChargeAccount getChargeAccount()
  {
    return chargeAccount;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.EditPayPalScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */