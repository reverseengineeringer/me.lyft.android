package me.lyft.android.application.driver.expresspay;

import com.lyft.android.api.dto.ExpressPayDTO;
import rx.Observable;
import rx.functions.Func1;

class ExpressPayService$2
  implements Func1<Throwable, Observable<ExpressPayDTO>>
{
  ExpressPayService$2(ExpressPayService paramExpressPayService) {}
  
  public Observable<ExpressPayDTO> call(Throwable paramThrowable)
  {
    return ExpressPayService.access$100(this$0, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */