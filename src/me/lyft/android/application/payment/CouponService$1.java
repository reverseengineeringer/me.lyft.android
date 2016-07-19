package me.lyft.android.application.payment;

import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.analytics.core.ActionAnalytics;
import rx.Observable;
import rx.functions.Func1;

class CouponService$1
  implements Func1<Throwable, Observable<UniversalDTO>>
{
  CouponService$1(CouponService paramCouponService, ActionAnalytics paramActionAnalytics) {}
  
  public Observable<UniversalDTO> call(Throwable paramThrowable)
  {
    val$couponAnalytics.trackFailure(paramThrowable);
    return CouponService.access$000(this$0, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.CouponService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */