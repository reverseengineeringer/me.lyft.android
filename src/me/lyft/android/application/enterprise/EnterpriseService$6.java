package me.lyft.android.application.enterprise;

import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class EnterpriseService$6
  implements Func1<Throwable, Observable<? extends Unit>>
{
  EnterpriseService$6(EnterpriseService paramEnterpriseService) {}
  
  public Observable<? extends Unit> call(Throwable paramThrowable)
  {
    return EnterpriseService.access$000(this$0, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.enterprise.EnterpriseService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */