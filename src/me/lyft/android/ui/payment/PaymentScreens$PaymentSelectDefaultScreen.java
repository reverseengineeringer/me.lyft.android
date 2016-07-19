package me.lyft.android.ui.payment;

import com.lyft.scoop.Controller;

@Controller(PaymentSelectDefaultController.class)
public class PaymentScreens$PaymentSelectDefaultScreen
  extends PaymentScreens.PaymentBaseScreen
{
  private boolean isBusinessProfile = false;
  
  public PaymentScreens$PaymentSelectDefaultScreen(boolean paramBoolean)
  {
    isBusinessProfile = paramBoolean;
  }
  
  public boolean isBusinessProfile()
  {
    return isBusinessProfile;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.PaymentSelectDefaultScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */