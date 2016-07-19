package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.payment.ChargeAccount;

@Layout(2130903146)
public class PaymentScreens$DebtAddChargeAccountScreen
  extends PaymentScreens
{
  private final ChargeAccount chargeAccount;
  
  public PaymentScreens$DebtAddChargeAccountScreen(ChargeAccount paramChargeAccount)
  {
    chargeAccount = paramChargeAccount;
  }
  
  public ChargeAccount getChargeAccount()
  {
    return chargeAccount;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.DebtAddChargeAccountScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */