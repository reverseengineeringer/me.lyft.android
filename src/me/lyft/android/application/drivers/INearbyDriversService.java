package me.lyft.android.application.drivers;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.drivers.NearbyDriver;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface INearbyDriversService
{
  public abstract Set<String> getDriverRideTypes();
  
  public abstract List<NearbyDriver> getDriversForRideType(String paramString);
  
  public abstract Observable<Unit> observeDriverUpdated();
  
  public abstract void updateNearbyDrivers(Location paramLocation)
    throws IOException;
}

/* Location:
 * Qualified Name:     me.lyft.android.application.drivers.INearbyDriversService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */