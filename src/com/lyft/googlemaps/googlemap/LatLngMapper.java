package com.lyft.googlemaps.googlemap;

import com.google.android.gms.maps.model.LatLng;
import com.lyft.googlemaps.core.latlng.MapLatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LatLngMapper
{
  public static LatLng toLatLng(MapLatLng paramMapLatLng)
  {
    return new LatLng(paramMapLatLng.getLat(), paramMapLatLng.getLng());
  }
  
  public static List<LatLng> toLatLng(List<MapLatLng> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(toLatLng((MapLatLng)paramList.next()));
    }
    return localArrayList;
  }
  
  public static MapLatLng toMapLatLng(LatLng paramLatLng)
  {
    return new MapLatLng(latitude, longitude);
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.LatLngMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */