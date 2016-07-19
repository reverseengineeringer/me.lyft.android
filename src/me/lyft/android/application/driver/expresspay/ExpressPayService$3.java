package me.lyft.android.application.driver.expresspay;

import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class ExpressPayService$3
  implements Func1<Throwable, Observable<Unit>>
{
  ExpressPayService$3(ExpressPayService paramExpressPayService) {}
  
  public Observable<Unit> call(Throwable paramThrowable)
  {
    return ExpressPayService.access$100(this$0, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */