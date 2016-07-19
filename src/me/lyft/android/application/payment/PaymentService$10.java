package me.lyft.android.application.payment;

import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.lyft.PaymentErrorParser;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$10
  implements Func1<Throwable, Observable<Unit>>
{
  PaymentService$10(PaymentService paramPaymentService) {}
  
  public Observable<Unit> call(Throwable paramThrowable)
  {
    return Observable.error(PaymentErrorParser.parse(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */