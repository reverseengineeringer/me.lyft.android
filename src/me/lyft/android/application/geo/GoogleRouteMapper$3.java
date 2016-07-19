package me.lyft.android.application.geo;

import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.SphericalUtils;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg.Step;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.OverviewPolyLine;
import rx.functions.Func2;

final class GoogleRouteMapper$3
  implements Func2<Leg, GoogleRouteDTO.Leg.Step, Leg>
{
  public Leg call(Leg paramLeg, GoogleRouteDTO.Leg.Step paramStep)
  {
    paramLeg.addPositions(SphericalUtils.decodeOverviewPolyLineToLatLngs(paramStep.getPolyline().getPoints()));
    return paramLeg;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleRouteMapper.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */