package me.lyft.android.application.payment;

import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import me.lyft.android.infrastructure.lyft.PaymentErrorParser;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$30
  implements Func1<Throwable, Observable<ChargeAccountsResponseDTO>>
{
  PaymentService$30(PaymentService paramPaymentService) {}
  
  public Observable<ChargeAccountsResponseDTO> call(Throwable paramThrowable)
  {
    return Observable.error(PaymentErrorParser.parse(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.30
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */