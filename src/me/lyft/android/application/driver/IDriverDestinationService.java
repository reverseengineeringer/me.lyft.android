package me.lyft.android.application.driver;

import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface IDriverDestinationService
{
  public abstract Location getDriverDestination();
  
  public abstract Observable<Location> observeDriverDestination();
  
  public abstract void updateDriverDestination(Location paramLocation);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.IDriverDestinationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */