package me.lyft.android.application.driver;

import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationEqualityComparator;
import me.lyft.android.rx.ReactiveProperty;
import rx.Observable;

public class DriverDestinationService
  implements IDriverDestinationService
{
  private final ReactiveProperty<Location> routeSubject;
  
  public DriverDestinationService(ReactiveProperty<Location> paramReactiveProperty)
  {
    routeSubject = paramReactiveProperty.setEqualityComparator(new LocationEqualityComparator());
  }
  
  public Location getDriverDestination()
  {
    return (Location)routeSubject.get();
  }
  
  public Observable<Location> observeDriverDestination()
  {
    return routeSubject.asObservable();
  }
  
  public void updateDriverDestination(Location paramLocation)
  {
    routeSubject.onNext(paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.DriverDestinationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */