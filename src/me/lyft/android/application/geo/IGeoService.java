package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.domain.geo.City;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface IGeoService
{
  public abstract Observable<City> addressLookupFromZip(String paramString1, String paramString2);
  
  public abstract Observable<Long> getDriverEta(String paramString, Location paramLocation, List<Location> paramList);
  
  public abstract Observable<Long> getDriverEta(String paramString, Location paramLocation, Location... paramVarArgs);
  
  public abstract Observable<Long> getPassengerEtd(String paramString, Location paramLocation, List<Location> paramList);
  
  public abstract Observable<Location> reverseGeocode(Location paramLocation);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.IGeoService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */