package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideRequestDetailsDTO;
import me.lyft.android.application.landing.exceptions.TermsNotAcceptedException;
import rx.Observable;
import rx.functions.Func1;

class RideRequestService$8
  implements Func1<Throwable, Observable<? extends RideRequestDetailsDTO>>
{
  RideRequestService$8(RideRequestService paramRideRequestService) {}
  
  public Observable<? extends RideRequestDetailsDTO> call(Throwable paramThrowable)
  {
    RideRequestService.access$400(this$0, paramThrowable);
    paramThrowable = RideRequestService.access$500(this$0, paramThrowable);
    paramThrowable = RideRequestService.access$600(this$0, paramThrowable);
    return Observable.error(TermsNotAcceptedException.transform(RideRequestService.access$700(this$0, paramThrowable)));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */