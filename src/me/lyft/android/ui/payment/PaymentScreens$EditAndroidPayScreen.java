package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.payment.WalletChargeAccount;

@Layout(2130903205)
public class PaymentScreens$EditAndroidPayScreen
  extends PaymentScreens
{
  private final WalletChargeAccount chargeAccount;
  
  public PaymentScreens$EditAndroidPayScreen(WalletChargeAccount paramWalletChargeAccount)
  {
    chargeAccount = paramWalletChargeAccount;
  }
  
  public WalletChargeAccount getChargeAccount()
  {
    return chargeAccount;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.EditAndroidPayScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */