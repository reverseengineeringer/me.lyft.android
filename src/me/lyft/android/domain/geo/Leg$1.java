package me.lyft.android.domain.geo;

import me.lyft.android.domain.location.LatLng;
import rx.functions.Func2;

class Leg$1
  implements Func2<LatLng, LatLng, Boolean>
{
  Leg$1(Leg paramLeg) {}
  
  public Boolean call(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return Boolean.valueOf(paramLatLng1.hasSameCoordinates(paramLatLng2));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.Leg.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */