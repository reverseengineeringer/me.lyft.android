package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class VenueDTO
{
  @SerializedName("introduction")
  public final String introduction;
  @SerializedName("name")
  public final String name;
  @SerializedName("polygons")
  public final List<String> polygons;
  @SerializedName("type")
  public final String type;
  @SerializedName("venueId")
  public final String venueId;
  @SerializedName("zones")
  public final List<VenueZoneDTO> zones;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class VenueDTO {\n");
    localStringBuilder.append("  venueId: ").append(venueId).append("\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  name: ").append(name).append("\n");
    localStringBuilder.append("  introduction: ").append(introduction).append("\n");
    localStringBuilder.append("  zones: ").append(zones).append("\n");
    localStringBuilder.append("  polygons: ").append(polygons).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.VenueDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */