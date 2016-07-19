package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;

@Layout(2130903363)
public class PaymentScreens$AddCreditCardScreen
  extends PaymentScreens.PaymentBaseScreen
{
  private final String cardNumber;
  private boolean isBusinessProfile = false;
  private boolean isMakeDefault = false;
  
  public PaymentScreens$AddCreditCardScreen(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    cardNumber = null;
    isMakeDefault = paramBoolean1.booleanValue();
    isBusinessProfile = paramBoolean2.booleanValue();
  }
  
  public PaymentScreens$AddCreditCardScreen(String paramString, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    cardNumber = paramString;
    isMakeDefault = paramBoolean1.booleanValue();
    isBusinessProfile = paramBoolean2.booleanValue();
  }
  
  public String getCardNumber()
  {
    return cardNumber;
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
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.AddCreditCardScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */