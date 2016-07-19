package me.lyft.android.application.payment;

import com.lyft.android.api.dto.ChargeAccountRequestDTOBuilder;
import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$16
  implements Func1<String, Observable<ChargeAccountsResponseDTO>>
{
  PaymentService$16(PaymentService paramPaymentService, Boolean paramBoolean1, Boolean paramBoolean2) {}
  
  public Observable<ChargeAccountsResponseDTO> call(String paramString)
  {
    paramString = new ChargeAccountRequestDTOBuilder().withClientPaymentMethod("card").withToken(paramString).withDefault(val$makeDefault).withDefaultBusiness(val$makeDefaultBusiness).build();
    return PaymentService.access$200(this$0).createChargeAccount(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */