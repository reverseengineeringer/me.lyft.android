package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface IDestinyService
{
  public abstract Observable<Unit> exitDestiny();
  
  public abstract Observable<Unit> exitSetDestiny();
  
  public abstract Observable<Unit> setDestiny(Location paramLocation);
  
  public abstract Observable<Unit> switchToDestiny();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IDestinyService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */