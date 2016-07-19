package me.lyft.android.application;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.common.Unit;
import me.lyft.android.rx.AsyncCall;

class LogoutService$1
  extends AsyncCall<Unit>
{
  LogoutService$1(LogoutService paramLogoutService, ActionAnalytics paramActionAnalytics) {}
  
  public void onFail(Throwable paramThrowable)
  {
    super.onFail(paramThrowable);
    val$analytics.trackFailure(paramThrowable);
  }
  
  public void onSuccess(Unit paramUnit)
  {
    super.onSuccess(paramUnit);
    val$analytics.trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.LogoutService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */