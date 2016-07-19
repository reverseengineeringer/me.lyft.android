package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;
import me.lyft.android.common.Objects;

public class GoogleLatLngDTO
{
  @SerializedName("lat")
  private Double lat;
  @SerializedName("lng")
  private Double lng;
  
  public GoogleLatLngDTO(Double paramDouble1, Double paramDouble2)
  {
    lat = paramDouble1;
    lng = paramDouble2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleLatLngDTO)) {}
    do
    {
      return false;
      paramObject = (GoogleLatLngDTO)paramObject;
    } while ((!Objects.equals(lat, lat)) || (!Objects.equals(lng, lng)));
    return true;
  }
  
  public Double getLat()
  {
    return lat;
  }
  
  public Double getLng()
  {
    return lng;
  }
  
  public void setLat(Double paramDouble)
  {
    lat = paramDouble;
  }
  
  public void setLng(Double paramDouble)
  {
    lng = paramDouble;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleLatLngDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */