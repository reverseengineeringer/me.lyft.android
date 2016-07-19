package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;

public class GoogleRouteDTO$OverviewPolyLine
{
  @SerializedName("points")
  private String points;
  
  public GoogleRouteDTO$OverviewPolyLine(String paramString)
  {
    points = paramString;
  }
  
  public String getPoints()
  {
    return points;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.OverviewPolyLine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */