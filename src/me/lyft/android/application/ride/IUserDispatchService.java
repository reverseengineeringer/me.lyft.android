package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IUserDispatchService
{
  public abstract Observable<Unit> switchToDispatchable(boolean paramBoolean);
  
  public abstract Observable<Unit> validateDriverStatusAndSwitchToDispatch();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IUserDispatchService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */