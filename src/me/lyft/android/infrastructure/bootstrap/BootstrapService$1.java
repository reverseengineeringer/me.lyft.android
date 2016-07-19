package me.lyft.android.infrastructure.bootstrap;

import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class BootstrapService$1
  implements Func1<Unit, Observable<Unit>>
{
  BootstrapService$1(BootstrapService paramBootstrapService) {}
  
  public Observable<Unit> call(Unit paramUnit)
  {
    if (!Strings.isNullOrEmpty(BootstrapService.access$000(this$0).getLyftToken())) {
      return BootstrapService.access$100(this$0);
    }
    BootstrapService.access$200(this$0);
    return Unit.just();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.bootstrap.BootstrapService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */