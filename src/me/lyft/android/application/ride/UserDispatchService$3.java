package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class UserDispatchService$3
  implements Func1<Unit, Observable<Unit>>
{
  UserDispatchService$3(UserDispatchService paramUserDispatchService) {}
  
  public Observable<Unit> call(Unit paramUnit)
  {
    return UserDispatchService.access$400(this$0, true).map(Unit.func1());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.UserDispatchService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */