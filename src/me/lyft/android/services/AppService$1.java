package me.lyft.android.services;

import me.lyft.android.errorhandling.IDefaultErrorHandler;
import rx.functions.Action1;

class AppService$1
  implements Action1<Throwable>
{
  AppService$1(AppService paramAppService) {}
  
  public void call(Throwable paramThrowable)
  {
    this$0.defaultErrorHandler.handle(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.AppService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */