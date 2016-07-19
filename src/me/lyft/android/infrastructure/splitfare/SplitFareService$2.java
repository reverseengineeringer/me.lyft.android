package me.lyft.android.infrastructure.splitfare;

import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import rx.Observable;
import rx.functions.Func1;

class SplitFareService$2
  implements Func1<Throwable, Observable<Unit>>
{
  SplitFareService$2(SplitFareService paramSplitFareService) {}
  
  public Observable<Unit> call(Throwable paramThrowable)
  {
    SplitFareService.access$000(this$0).trackSplitResponseFailure(paramThrowable);
    Object localObject = paramThrowable;
    if ((paramThrowable instanceof LyftApiException))
    {
      localObject = paramThrowable;
      if (((LyftApiException)paramThrowable).getStatusCode() == 422) {
        localObject = new SplitFareServiceException("splitfare_request_lapsed");
      }
    }
    return Observable.error((Throwable)localObject);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.splitfare.SplitFareService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */