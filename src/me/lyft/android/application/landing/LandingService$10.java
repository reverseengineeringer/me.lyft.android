package me.lyft.android.application.landing;

import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class LandingService$10
  implements Func1<Unit, Observable<Unit>>
{
  LandingService$10(LandingService paramLandingService) {}
  
  public Observable<Unit> call(Unit paramUnit)
  {
    return LandingService.access$400(this$0).refreshChargeAccounts();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.LandingService.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */