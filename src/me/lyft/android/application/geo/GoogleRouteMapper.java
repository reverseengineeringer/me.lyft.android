package me.lyft.android.application.geo;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.SphericalUtils;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg.Step;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.OverviewPolyLine;
import rx.functions.Func1;
import rx.functions.Func2;

public class GoogleRouteMapper
{
  private static List<Leg> constructLegsFromSteps(List<List<GoogleRouteDTO.Leg.Step>> paramList)
  {
    (List)Iterables.aggregate(paramList, new ArrayList(), new Func2()
    {
      public ArrayList<Leg> call(ArrayList<Leg> paramAnonymousArrayList, List<GoogleRouteDTO.Leg.Step> paramAnonymousList)
      {
        paramAnonymousArrayList.add(GoogleRouteMapper.convertStepToLeg(paramAnonymousList));
        return paramAnonymousArrayList;
      }
    });
  }
  
  private static Leg convertStepToLeg(List<GoogleRouteDTO.Leg.Step> paramList)
  {
    (Leg)Iterables.aggregate(paramList, new Leg(), new Func2()
    {
      public Leg call(Leg paramAnonymousLeg, GoogleRouteDTO.Leg.Step paramAnonymousStep)
      {
        paramAnonymousLeg.addPositions(SphericalUtils.decodeOverviewPolyLineToLatLngs(paramAnonymousStep.getPolyline().getPoints()));
        return paramAnonymousLeg;
      }
    });
  }
  
  private static List<List<GoogleRouteDTO.Leg.Step>> flattenToListOfSteps(List<GoogleRouteDTO.Leg> paramList)
  {
    Iterables.map(paramList, new Func1()
    {
      public List<GoogleRouteDTO.Leg.Step> call(GoogleRouteDTO.Leg paramAnonymousLeg)
      {
        return paramAnonymousLeg.getSteps();
      }
    });
  }
  
  public static List<Leg> fromDto(GoogleRouteDTO paramGoogleRouteDTO)
  {
    return constructLegsFromSteps(flattenToListOfSteps(paramGoogleRouteDTO.getLegs()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleRouteMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */