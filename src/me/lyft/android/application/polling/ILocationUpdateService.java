package me.lyft.android.application.polling;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface ILocationUpdateService
{
  public abstract void addLocationToHistory(Location paramLocation);
  
  public abstract Observable<Unit> updateCoarseLocation(Location paramLocation);
  
  public abstract Observable<Unit> updateLocation();
  
  public abstract void updateLocationSync()
    throws Throwable;
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.ILocationUpdateService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */