package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class VenuePickupLocationDTO
{
  @SerializedName("copy")
  public final String copy;
  @SerializedName("id")
  public final String id;
  @SerializedName("lat")
  public final Double lat;
  @SerializedName("lng")
  public final Double lng;
  @SerializedName("name")
  public final String name;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class VenuePickupLocationDTO {\n");
    localStringBuilder.append("  lat: ").append(lat).append("\n");
    localStringBuilder.append("  lng: ").append(lng).append("\n");
    localStringBuilder.append("  name: ").append(name).append("\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  copy: ").append(copy).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.VenuePickupLocationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */