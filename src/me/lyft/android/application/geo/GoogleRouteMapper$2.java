package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg.Step;
import rx.functions.Func1;

final class GoogleRouteMapper$2
  implements Func1<GoogleRouteDTO.Leg, List<GoogleRouteDTO.Leg.Step>>
{
  public List<GoogleRouteDTO.Leg.Step> call(GoogleRouteDTO.Leg paramLeg)
  {
    return paramLeg.getSteps();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleRouteMapper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */