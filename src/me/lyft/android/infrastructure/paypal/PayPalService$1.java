package me.lyft.android.infrastructure.paypal;

import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.functions.Func1;

class PayPalService$1
  implements Func1<ActivityResult, Observable<PayPalChargeData>>
{
  PayPalService$1(PayPalService paramPayPalService, String paramString) {}
  
  public Observable<PayPalChargeData> call(ActivityResult paramActivityResult)
  {
    return PayPalService.access$000(this$0, val$clientToken, paramActivityResult);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.PayPalService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */