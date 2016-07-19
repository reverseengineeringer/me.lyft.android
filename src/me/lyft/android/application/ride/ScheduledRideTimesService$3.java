package me.lyft.android.application.ride;

import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import rx.Observable;
import rx.functions.Func1;

final class ScheduledRideTimesService$3
  implements Func1<Throwable, Observable<? extends List<ScheduledInterval>>>
{
  public Observable<? extends List<ScheduledInterval>> call(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof LyftApiException)) {
      return Observable.error(paramThrowable);
    }
    Object localObject = ((LyftApiException)paramThrowable).getLyftError();
    String str = ((LyftError)localObject).getErrorCode();
    localObject = ((LyftError)localObject).getErrorDescription();
    if (Objects.equals(str, "inactive_chauffeur_route")) {
      return Observable.error(new InactiveCarpoolRouteException(str, (String)localObject));
    }
    if (Objects.equals(str, "inactive_chauffeur_route_line")) {
      return Observable.error(new InactiveCarpoolRouteLineFallbackException(str, (String)localObject));
    }
    return Observable.error(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.ScheduledRideTimesService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */