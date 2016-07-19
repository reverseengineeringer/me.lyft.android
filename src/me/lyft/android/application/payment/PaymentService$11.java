package me.lyft.android.application.payment;

import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.payment.ChargeAccount;
import rx.Observable;
import rx.functions.Func1;

class PaymentService$11
  implements Func1<ChargeAccountsResponseDTO, Observable<Unit>>
{
  PaymentService$11(PaymentService paramPaymentService, String paramString1, String paramString2) {}
  
  public Observable<Unit> call(ChargeAccountsResponseDTO paramChargeAccountsResponseDTO)
  {
    paramChargeAccountsResponseDTO = PaymentService.access$000(this$0, paramChargeAccountsResponseDTO);
    Object localObject = null;
    Iterator localIterator = paramChargeAccountsResponseDTO.iterator();
    do
    {
      paramChargeAccountsResponseDTO = (ChargeAccountsResponseDTO)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramChargeAccountsResponseDTO = (ChargeAccount)localIterator.next();
    } while (!val$chargeAccountId.equals(paramChargeAccountsResponseDTO.getId()));
    if ((paramChargeAccountsResponseDTO != null) && (paramChargeAccountsResponseDTO.isFailed().booleanValue())) {
      return Observable.error(new PaymentException("Charging debt failed", null, val$reason));
    }
    return Observable.just(Unit.create());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */