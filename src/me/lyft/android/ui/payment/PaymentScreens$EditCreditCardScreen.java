package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.payment.CreditCardChargeAccount;

@Layout(2130903368)
public class PaymentScreens$EditCreditCardScreen
  extends PaymentScreens
{
  private final CreditCardChargeAccount chargeAccount;
  
  public PaymentScreens$EditCreditCardScreen(CreditCardChargeAccount paramCreditCardChargeAccount)
  {
    chargeAccount = paramCreditCardChargeAccount;
  }
  
  public CreditCardChargeAccount getChargeAccount()
  {
    return chargeAccount;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.EditCreditCardScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */