package me.lyft.android.application.payment;

import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.NullChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;

public class PaymentDefaultsService
  implements IPaymentDefaultsService
{
  private final IChargeAccountsProvider chargeAccountsProvider;
  private final ICheckoutSession checkoutSession;
  
  public PaymentDefaultsService(IChargeAccountsProvider paramIChargeAccountsProvider, ICheckoutSession paramICheckoutSession)
  {
    chargeAccountsProvider = paramIChargeAccountsProvider;
    checkoutSession = paramICheckoutSession;
  }
  
  public ChargeAccount getCurrentDefaultChargeAccount()
  {
    if (checkoutSession.isBusinessProfile()) {}
    for (ChargeAccount localChargeAccount = chargeAccountsProvider.getBusinessOrDefaultChargeAccount();; localChargeAccount = chargeAccountsProvider.getDefaultOrFirstValidChargeAccount())
    {
      Object localObject = localChargeAccount;
      if (localChargeAccount == null) {
        localObject = new NullChargeAccount();
      }
      return (ChargeAccount)localObject;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentDefaultsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */