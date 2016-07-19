package me.lyft.android.application.checkout;

import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import rx.Observable;
import rx.functions.Func1;

class CheckoutSession$1
  implements Func1<Boolean, Observable<ChargeAccount>>
{
  CheckoutSession$1(CheckoutSession paramCheckoutSession) {}
  
  public Observable<ChargeAccount> call(Boolean paramBoolean)
  {
    Observable localObservable1 = CheckoutSession.access$000(this$0).observeDefaultBusinessChargeAccount();
    Observable localObservable2 = CheckoutSession.access$000(this$0).observeDefaultChargeAccount();
    if (paramBoolean.booleanValue()) {
      return localObservable1;
    }
    return localObservable2;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.checkout.CheckoutSession.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */