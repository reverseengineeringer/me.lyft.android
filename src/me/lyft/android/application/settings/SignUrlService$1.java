package me.lyft.android.application.settings;

import me.lyft.android.analytics.core.CallAnalytics;
import rx.functions.Action1;

class SignUrlService$1
  implements Action1<Throwable>
{
  SignUrlService$1(SignUrlService paramSignUrlService, CallAnalytics paramCallAnalytics) {}
  
  public void call(Throwable paramThrowable)
  {
    val$analytics.trackFailure(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.SignUrlService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */