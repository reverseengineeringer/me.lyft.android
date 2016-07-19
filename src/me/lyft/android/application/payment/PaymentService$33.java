package me.lyft.android.application.payment;

import com.lyft.android.api.dto.PaypalClientTokenDTO;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.infrastructure.paypal.PayPalChargeData;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$33
  implements Func1<PaypalClientTokenDTO, Observable<PayPalChargeData>>
{
  PaymentService$33(PaymentService paramPaymentService) {}
  
  public Observable<PayPalChargeData> call(PaypalClientTokenDTO paramPaypalClientTokenDTO)
  {
    return PaymentService.access$500(this$0).obtainPayPalChargeData(clientToken);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.33
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */