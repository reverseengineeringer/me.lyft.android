package me.lyft.android.application.driver.expresspay;

import com.lyft.android.api.dto.ExpressPayAccountDTO;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.infrastructure.lyft.PaymentErrorParser;
import rx.Observable;
import rx.functions.Func1;

class ExpressPayService$4
  implements Func1<Throwable, Observable<ExpressPayAccountDTO>>
{
  ExpressPayService$4(ExpressPayService paramExpressPayService, ActionAnalytics paramActionAnalytics) {}
  
  public Observable<ExpressPayAccountDTO> call(Throwable paramThrowable)
  {
    val$analytics.trackFailure(paramThrowable);
    return Observable.error(PaymentErrorParser.parse(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */