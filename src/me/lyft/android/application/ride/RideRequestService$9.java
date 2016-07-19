package me.lyft.android.application.ride;

import me.lyft.android.application.payment.PaymentException;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class RideRequestService$9
  implements Func1<Throwable, Observable<Unit>>
{
  RideRequestService$9(RideRequestService paramRideRequestService) {}
  
  public Observable<Unit> call(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof PaymentException)) {
      return Observable.error(new NoValidChargeAccountException());
    }
    return Observable.error(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */