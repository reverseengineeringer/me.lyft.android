package me.lyft.android.ui.payment;

import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.ui.MainActivityModule;

@Module(addsTo=MainActivityModule.class, injects={PaymentDefaultsWidgetController.class})
public class PaymentDefaultsWidgetModule
{
  private final List<ChargeAccount> chargeAccounts;
  
  public PaymentDefaultsWidgetModule(List<ChargeAccount> paramList)
  {
    chargeAccounts = paramList;
  }
  
  @Provides
  List<ChargeAccount> provideChargeAccounts()
  {
    return new ArrayList(chargeAccounts);
  }
  
  @Provides
  PaymentDefaultsWidgetController provideController(AppFlow paramAppFlow, List<ChargeAccount> paramList)
  {
    return new PaymentDefaultsWidgetController(paramAppFlow, paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentDefaultsWidgetModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */