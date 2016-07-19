package me.lyft.android.application.payment;

import com.lyft.android.api.dto.ChargeAccountRequestDTOBuilder;
import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.paypal.PayPalChargeData;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$32
  implements Func1<PayPalChargeData, Observable<ChargeAccountsResponseDTO>>
{
  PaymentService$32(PaymentService paramPaymentService, Boolean paramBoolean1, Boolean paramBoolean2) {}
  
  public Observable<ChargeAccountsResponseDTO> call(PayPalChargeData paramPayPalChargeData)
  {
    String str = paramPayPalChargeData.getNonce();
    paramPayPalChargeData = paramPayPalChargeData.getDeviceData();
    paramPayPalChargeData = new ChargeAccountRequestDTOBuilder().withClientPaymentMethod("paypal").withNonce(str).withChargeToken(paramPayPalChargeData).withDefault(val$makeDefault).withDefaultBusiness(val$makeDefaultBusiness).build();
    return PaymentService.access$200(this$0).createChargeAccount(paramPayPalChargeData);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.32
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */