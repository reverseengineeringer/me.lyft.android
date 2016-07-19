package me.lyft.android.application.landing;

import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.lyft.PhoneLoginErrorParser;
import rx.Observable;
import rx.functions.Func1;

class LandingService$7
  implements Func1<Throwable, Observable<Unit>>
{
  LandingService$7(LandingService paramLandingService) {}
  
  public Observable<Unit> call(Throwable paramThrowable)
  {
    return Observable.error(PhoneLoginErrorParser.parse(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.LandingService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */