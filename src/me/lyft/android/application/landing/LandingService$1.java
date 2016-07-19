package me.lyft.android.application.landing;

import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.lyft.PhoneLoginErrorParser;
import rx.Observable;
import rx.functions.Func1;

class LandingService$1
  implements Func1<Throwable, Observable<? extends Unit>>
{
  LandingService$1(LandingService paramLandingService) {}
  
  public Observable<? extends Unit> call(Throwable paramThrowable)
  {
    return Observable.error(PhoneLoginErrorParser.parse(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.LandingService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */