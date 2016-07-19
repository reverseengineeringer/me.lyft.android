package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;

public class GoogleRouteDTO$Leg$Step
{
  @SerializedName("end_location")
  private GoogleLatLngDTO endLocation;
  @SerializedName("polyline")
  private GoogleRouteDTO.OverviewPolyLine polyline;
  @SerializedName("start_location")
  private GoogleLatLngDTO startLocation;
  
  public GoogleRouteDTO$Leg$Step(GoogleLatLngDTO paramGoogleLatLngDTO1, GoogleLatLngDTO paramGoogleLatLngDTO2, GoogleRouteDTO.OverviewPolyLine paramOverviewPolyLine)
  {
    startLocation = paramGoogleLatLngDTO1;
    endLocation = paramGoogleLatLngDTO2;
    polyline = paramOverviewPolyLine;
  }
  
  public GoogleLatLngDTO getEndLocation()
  {
    return endLocation;
  }
  
  public GoogleRouteDTO.OverviewPolyLine getPolyline()
  {
    return polyline;
  }
  
  public GoogleLatLngDTO getStartLocation()
  {
    return startLocation;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg.Step
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */