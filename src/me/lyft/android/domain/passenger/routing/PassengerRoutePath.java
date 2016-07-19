package me.lyft.android.domain.passenger.routing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.location.LatLng;
import rx.functions.Func2;

public class PassengerRoutePath
{
  private static final String EMPTY_ID = "EMPTY_ID";
  private static final PassengerRoutePath EMPTY_ROUTE_PATH = new PassengerRoutePath(Collections.emptyList(), "EMPTY_ID");
  private List<PassengerLeg> legs;
  private String routeId;
  
  public PassengerRoutePath(List<PassengerLeg> paramList, String paramString)
  {
    legs = paramList;
    routeId = paramString;
  }
  
  public static PassengerRoutePath empty()
  {
    return EMPTY_ROUTE_PATH;
  }
  
  public String getRouteId()
  {
    return routeId;
  }
  
  public List<LatLng> toLatLngList()
  {
    (List)Iterables.aggregate(legs, new ArrayList(), new Func2()
    {
      public List<LatLng> call(List<LatLng> paramAnonymousList, PassengerLeg paramAnonymousPassengerLeg)
      {
        paramAnonymousList.addAll(paramAnonymousPassengerLeg.getLocations());
        return paramAnonymousList;
      }
    });
  }
  
  public PassengerRoutePath untilPickup()
  {
    ArrayList localArrayList = new ArrayList(legs.size());
    Iterator localIterator = legs.iterator();
    while (localIterator.hasNext())
    {
      PassengerLeg localPassengerLeg = (PassengerLeg)localIterator.next();
      localArrayList.add(localPassengerLeg);
      if ((localPassengerLeg.isMine()) && (localPassengerLeg.isPickup())) {
        return new PassengerRoutePath(localArrayList, routeId);
      }
    }
    return empty();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.routing.PassengerRoutePath
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */