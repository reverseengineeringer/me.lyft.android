package me.lyft.android.application.geo;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg.Step;
import rx.functions.Func2;

final class GoogleRouteMapper$1
  implements Func2<ArrayList<Leg>, List<GoogleRouteDTO.Leg.Step>, ArrayList<Leg>>
{
  public ArrayList<Leg> call(ArrayList<Leg> paramArrayList, List<GoogleRouteDTO.Leg.Step> paramList)
  {
    paramArrayList.add(GoogleRouteMapper.access$000(paramList));
    return paramArrayList;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleRouteMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */