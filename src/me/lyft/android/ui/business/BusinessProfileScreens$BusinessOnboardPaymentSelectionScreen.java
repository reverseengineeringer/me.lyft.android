package me.lyft.android.ui.business;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.ui.business.onboard.PaymentSelectionController;

@Controller(PaymentSelectionController.class)
@DaggerModule(BusinessProfileModule.class)
public class BusinessProfileScreens$BusinessOnboardPaymentSelectionScreen
  extends BusinessProfileScreens
{}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.BusinessProfileScreens.BusinessOnboardPaymentSelectionScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */