package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarpoolRideDeclineRequestDTO
{
  @SerializedName("ids")
  public final List<String> ids;
  @SerializedName("lat")
  public final Double lat;
  @SerializedName("lng")
  public final Double lng;
  @SerializedName("reason")
  public final String reason;
  
  public CarpoolRideDeclineRequestDTO(List<String> paramList, String paramString, Double paramDouble1, Double paramDouble2)
  {
    ids = paramList;
    reason = paramString;
    lat = paramDouble1;
    lng = paramDouble2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CarpoolRideDeclineRequestDTO {\n");
    localStringBuilder.append("  ids: ").append(ids).append("\n");
    localStringBuilder.append("  reason: ").append(reason).append("\n");
    localStringBuilder.append("  lat: ").append(lat).append("\n");
    localStringBuilder.append("  lng: ").append(lng).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CarpoolRideDeclineRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */