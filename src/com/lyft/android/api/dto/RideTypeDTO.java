package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RideTypeDTO
{
  @SerializedName("display_name")
  public final String display_name;
  @SerializedName("features")
  public final List<String> features;
  @SerializedName("image_url")
  public final String image_url;
  @SerializedName("pricing_details")
  public final PricingDetailsDTO pricing_details;
  @SerializedName("ride_type")
  public final String ride_type;
  @SerializedName("seats")
  public final Integer seats;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideTypeDTO {\n");
    localStringBuilder.append("  ride_type: ").append(ride_type).append("\n");
    localStringBuilder.append("  pricing_details: ").append(pricing_details).append("\n");
    localStringBuilder.append("  display_name: ").append(display_name).append("\n");
    localStringBuilder.append("  seats: ").append(seats).append("\n");
    localStringBuilder.append("  image_url: ").append(image_url).append("\n");
    localStringBuilder.append("  features: ").append(features).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideTypeDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */