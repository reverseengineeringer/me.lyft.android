package me.lyft.android.application.geo.builders;

import me.lyft.android.infrastructure.googlegeo.model.GoogleLatLngDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg.Step;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.OverviewPolyLine;

public class GoogleRouteDTOBuilder$GoogleStepDTOBuilder
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

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.builders.GoogleRouteDTOBuilder.GoogleStepDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */