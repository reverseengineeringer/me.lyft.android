package me.lyft.android.application.payment;

import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$26
  implements Func1<String, Observable<Unit>>
{
  PaymentService$26(PaymentService paramPaymentService, String paramString) {}
  
  public Observable<Unit> call(String paramString)
  {
    paramString = PaymentService.access$200(this$0).makePayPalDefault(val$chargeAccountId, paramString);
    return PaymentService.access$400(this$0, paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */