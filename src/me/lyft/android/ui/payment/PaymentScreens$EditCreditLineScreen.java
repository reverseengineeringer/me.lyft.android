package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.payment.CreditLineChargeAccount;

@Layout(2130903369)
public class PaymentScreens$EditCreditLineScreen
  extends PaymentScreens
{
  private final CreditLineChargeAccount chargeAccount;
  
  public PaymentScreens$EditCreditLineScreen(CreditLineChargeAccount paramCreditLineChargeAccount)
  {
    chargeAccount = paramCreditLineChargeAccount;
  }
  
  public CreditLineChargeAccount getChargeAccount()
  {
    return chargeAccount;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.EditCreditLineScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */