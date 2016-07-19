package me.lyft.android.application.geo.routecache;

import java.util.List;
import me.lyft.android.application.geo.IDirectionsService;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;
import rx.Observable;
import rx.functions.Action1;

public class DirectionsCacheDecorator
  implements IDirectionsService
{
  private IDirectionsCache directionsCache;
  private IDirectionsService directionsService;
  
  public DirectionsCacheDecorator(IDirectionsService paramIDirectionsService, IDirectionsCache paramIDirectionsCache)
  {
    directionsService = paramIDirectionsService;
    directionsCache = paramIDirectionsCache;
  }
  
  public Observable<List<Leg>> directions(String paramString, final List<LatLng> paramList)
  {
    List localList = directionsCache.getRoute(paramList);
    if (localList != null) {
      return Observable.just(localList);
    }
    directionsService.directions(paramString, paramList).doOnNext(new Action1()
    {
      public void call(List<Leg> paramAnonymousList)
      {
        directionsCache.cache(paramList, paramAnonymousList);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.routecache.DirectionsCacheDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */