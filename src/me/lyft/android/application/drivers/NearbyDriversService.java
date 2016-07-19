package me.lyft.android.application.drivers;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.drivers.NearbyDriver;
import me.lyft.android.domain.drivers.NearbyDriverMapper;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class NearbyDriversService
  implements INearbyDriversService
{
  BehaviorSubject<Map<String, List<NearbyDriver>>> driversSubject = BehaviorSubject.create();
  private ILyftApi lyftApi;
  
  public NearbyDriversService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Set<String> getDriverRideTypes()
  {
    if (driversSubject.hasValue()) {
      return ((Map)driversSubject.getValue()).keySet();
    }
    return Collections.emptySet();
  }
  
  public List<NearbyDriver> getDriversForRideType(String paramString)
  {
    if (driversSubject.hasValue())
    {
      List localList = (List)((Map)driversSubject.getValue()).get(paramString);
      paramString = localList;
      if (localList == null) {
        paramString = Collections.emptyList();
      }
      return paramString;
    }
    return Collections.emptyList();
  }
  
  public Observable<Unit> observeDriverUpdated()
  {
    return driversSubject.asObservable().map(Unit.func1());
  }
  
  public void updateNearbyDrivers(Location paramLocation)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramLocation = NearbyDriverMapper.fromNearbyDriversResponse(lyftApi.getNearbyDrivers(paramLocation.getLat(), paramLocation.getLng()));
      driversSubject.onNext(paramLocation);
      return;
    }
    catch (LyftApiException localLyftApiException)
    {
      do
      {
        paramLocation = localHashMap;
      } while (localLyftApiException.getStatusCode() == 400);
      throw localLyftApiException;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.drivers.NearbyDriversService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */