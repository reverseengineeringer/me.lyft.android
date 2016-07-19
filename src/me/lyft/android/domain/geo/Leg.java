package me.lyft.android.domain.geo;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.Location;
import rx.functions.Func2;

public class Leg
  implements INullable
{
  private final List<LatLng> locations;
  
  public Leg()
  {
    this(new ArrayList());
  }
  
  public Leg(List<LatLng> paramList)
  {
    locations = paramList;
  }
  
  public static Leg empty()
  {
    return NullLeg.getInstance();
  }
  
  public void addPosition(Location paramLocation)
  {
    locations.add(paramLocation);
  }
  
  public void addPositions(List<LatLng> paramList)
  {
    locations.addAll(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Leg)) {
      return false;
    }
    paramObject = (Leg)paramObject;
    Iterables.equals(locations, locations, new Func2()
    {
      public Boolean call(LatLng paramAnonymousLatLng1, LatLng paramAnonymousLatLng2)
      {
        return Boolean.valueOf(paramAnonymousLatLng1.hasSameCoordinates(paramAnonymousLatLng2));
      }
    });
  }
  
  public List<LatLng> getLocations()
  {
    return locations;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public Leg subLeg(int paramInt1, int paramInt2)
  {
    return new Leg(locations.subList(paramInt1, paramInt2));
  }
  
  static class NullLeg
    extends Leg
  {
    private static final Leg INSTANCE = new NullLeg();
    
    public static Leg getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.Leg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */