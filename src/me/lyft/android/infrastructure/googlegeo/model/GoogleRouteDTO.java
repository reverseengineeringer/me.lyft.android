package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class GoogleRouteDTO
{
  @SerializedName("legs")
  private List<Leg> legs = new ArrayList();
  @SerializedName("overview_polyline")
  private OverviewPolyLine overviewPolyline;
  @SerializedName("summary")
  private String summary;
  
  public GoogleRouteDTO(String paramString, OverviewPolyLine paramOverviewPolyLine, List<Leg> paramList)
  {
    summary = paramString;
    overviewPolyline = paramOverviewPolyLine;
    legs = paramList;
  }
  
  public List<Leg> getLegs()
  {
    return legs;
  }
  
  public OverviewPolyLine getOverviewPolyline()
  {
    return overviewPolyline;
  }
  
  public String getSummary()
  {
    return summary;
  }
  
  public static class Leg
  {
    @SerializedName("steps")
    List<Step> steps = new ArrayList();
    
    public Leg(List<Step> paramList)
    {
      steps = paramList;
    }
    
    public List<Step> getSteps()
    {
      return steps;
    }
    
    public static class Step
    {
      @SerializedName("end_location")
      private GoogleLatLngDTO endLocation;
      @SerializedName("polyline")
      private GoogleRouteDTO.OverviewPolyLine polyline;
      @SerializedName("start_location")
      private GoogleLatLngDTO startLocation;
      
      public Step(GoogleLatLngDTO paramGoogleLatLngDTO1, GoogleLatLngDTO paramGoogleLatLngDTO2, GoogleRouteDTO.OverviewPolyLine paramOverviewPolyLine)
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
  }
  
  public static class OverviewPolyLine
  {
    @SerializedName("points")
    private String points;
    
    public OverviewPolyLine(String paramString)
    {
      points = paramString;
    }
    
    public String getPoints()
    {
      return points;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */