package me.lyft.android.application.requestridetypes;

import java.io.IOException;
import java.util.List;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import rx.Observable;

public abstract interface IRequestRideTypeService
{
  public abstract RequestRideType findRideTypeById(String paramString);
  
  public abstract RequestRideType getDefaultRideType();
  
  public abstract List<RequestRideType> getRideTypes();
  
  public abstract boolean hasRideTypes();
  
  public abstract boolean isRegionUnavailable();
  
  public abstract Observable<List<RequestRideType>> observeRideTypes();
  
  public abstract void updateRideTypes(Location paramLocation)
    throws IOException;
}

/* Location:
 * Qualified Name:     me.lyft.android.application.requestridetypes.IRequestRideTypeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */