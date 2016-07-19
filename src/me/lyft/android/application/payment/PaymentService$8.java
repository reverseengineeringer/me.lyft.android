package me.lyft.android.application.payment;

import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import me.lyft.android.infrastructure.androidpay.AndroidPayStripeToken;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$8
  implements Func1<AndroidPayStripeToken, Observable<ChargeAccountsResponseDTO>>
{
  PaymentService$8(PaymentService paramPaymentService) {}
  
  public Observable<ChargeAccountsResponseDTO> call(AndroidPayStripeToken paramAndroidPayStripeToken)
  {
    return PaymentService.access$100(this$0, paramAndroidPayStripeToken);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */