package me.lyft.android.application.payment;

import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$9
  implements Func1<Unit, Observable<Unit>>
{
  PaymentService$9(PaymentService paramPaymentService, String paramString) {}
  
  public Observable<Unit> call(Unit paramUnit)
  {
    paramUnit = PaymentService.access$200(this$0).payDebtWithWallet(val$chargeAccountId);
    return PaymentService.access$300(this$0, paramUnit, val$chargeAccountId, "debt_wallet_failed");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */