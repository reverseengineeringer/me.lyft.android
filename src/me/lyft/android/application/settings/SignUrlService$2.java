package me.lyft.android.application.settings;

import me.lyft.android.analytics.core.CallAnalytics;
import rx.functions.Action1;

class SignUrlService$2
  implements Action1<String>
{
  SignUrlService$2(SignUrlService paramSignUrlService, CallAnalytics paramCallAnalytics) {}
  
  public void call(String paramString)
  {
    val$analytics.trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.SignUrlService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */