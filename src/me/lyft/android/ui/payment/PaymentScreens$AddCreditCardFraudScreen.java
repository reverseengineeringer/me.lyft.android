package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;

@Layout(2130903370)
public class PaymentScreens$AddCreditCardFraudScreen
  extends PaymentScreens.PaymentBaseScreen
{
  private boolean isBusinessProfile = false;
  private boolean isMakeDefault = false;
  
  public PaymentScreens$AddCreditCardFraudScreen() {}
  
  public PaymentScreens$AddCreditCardFraudScreen(boolean paramBoolean1, boolean paramBoolean2)
  {
    isMakeDefault = paramBoolean1;
    isBusinessProfile = paramBoolean2;
  }
  
  public boolean isBusinessProfile()
  {
    return isBusinessProfile;
  }
  
  public boolean isMakeDefault()
  {
    return isMakeDefault;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.AddCreditCardFraudScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */