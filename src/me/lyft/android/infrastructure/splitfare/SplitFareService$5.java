package me.lyft.android.infrastructure.splitfare;

import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class SplitFareService$5
  implements Func1<Throwable, Observable<? extends Unit>>
{
  SplitFareService$5(SplitFareService paramSplitFareService) {}
  
  public Observable<? extends Unit> call(Throwable paramThrowable)
  {
    SplitFareService.access$000(this$0).trackSendSplitRequestFailure(paramThrowable);
    return Observable.error(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.splitfare.SplitFareService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */