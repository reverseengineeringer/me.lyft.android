package me.lyft.android.application.payment;

import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import rx.functions.Action1;

class PaymentService$28
  implements Action1<ChargeAccountsResponseDTO>
{
  PaymentService$28(PaymentService paramPaymentService) {}
  
  public void call(ChargeAccountsResponseDTO paramChargeAccountsResponseDTO)
  {
    PaymentService.access$000(this$0, paramChargeAccountsResponseDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */