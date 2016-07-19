package me.lyft.android.application.payment;

import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$20
  implements Func1<String, Observable<ChargeAccountsResponseDTO>>
{
  PaymentService$20(PaymentService paramPaymentService, String paramString) {}
  
  public Observable<ChargeAccountsResponseDTO> call(String paramString)
  {
    return PaymentService.access$200(this$0).updateChargeAccount(val$chargeAccountId, paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */