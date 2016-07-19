package me.lyft.android.application.payment;

import me.lyft.android.domain.invite.CouponInfo;
import rx.Observable;
import rx.functions.Func1;

class CouponService$3
  implements Func1<Throwable, Observable<CouponInfo>>
{
  CouponService$3(CouponService paramCouponService) {}
  
  public Observable<CouponInfo> call(Throwable paramThrowable)
  {
    return Observable.just(CouponInfo.empty());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.CouponService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */