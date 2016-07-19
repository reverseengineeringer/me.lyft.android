package me.lyft.android.application.geo.builders;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleLatLngDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg.Step;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.OverviewPolyLine;

public class GoogleRouteDTOBuilder
{
  private List<GoogleRouteDTO.Leg> legs = new ArrayList();
  private GoogleRouteDTO.OverviewPolyLine overviewPolyline;
  private String summary;
  
  public GoogleRouteDTO build()
  {
    return new GoogleRouteDTO(summary, overviewPolyline, legs);
  }
  
  public GoogleRouteDTOBuilder withLeg(GoogleLegDTOBuilder paramGoogleLegDTOBuilder)
  {
    legs.add(paramGoogleLegDTOBuilder.build());
    return this;
  }
  
  public static class GoogleLegDTOBuilder
  {
    private List<GoogleRouteDTO.Leg.Step> steps = new ArrayList();
    
    private GoogleRouteDTO.Leg build()
    {
      return new GoogleRouteDTO.Leg(steps);
    }
    
    public GoogleLegDTOBuilder withStep(GoogleRouteDTOBuilder.GoogleStepDTOBuilder paramGoogleStepDTOBuilder)
    {
      steps.add(paramGoogleStepDTOBuilder.build());
      return this;
    }
  }
  
  public static class GoogleStepDTOBuilder
  {
    private GoogleLatLngDTO endLocation;
    private GoogleRouteDTO.OverviewPolyLine polyline;
    private GoogleLatLngDTO startLocation;
    
    public GoogleRouteDTO.Leg.Step build()
    {
      return new GoogleRouteDTO.Leg.Step(startLocation, endLocation, polyline);
    }
    
    public GoogleStepDTOBuilder withPolyline(GoogleRouteDTO.OverviewPolyLine paramOverviewPolyLine)
    {
      polyline = paramOverviewPolyLine;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.builders.GoogleRouteDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */