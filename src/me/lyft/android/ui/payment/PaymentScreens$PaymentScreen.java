package me.lyft.android.ui.payment;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;

@Controller(PaymentScreenController.class)
@DaggerModule(PaymentScreenModule.class)
public class PaymentScreens$PaymentScreen
  extends PaymentScreens.PaymentBaseScreen
{
  public PaymentScreens$PaymentScreen() {}
  
  public PaymentScreens$PaymentScreen(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.PaymentScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */