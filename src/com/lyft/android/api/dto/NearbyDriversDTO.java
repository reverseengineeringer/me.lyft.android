package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NearbyDriversDTO
{
  @SerializedName("drivers")
  public final List<NearbyDriverDTO> drivers;
  @SerializedName("ride_type")
  public final String ride_type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NearbyDriversDTO {\n");
    localStringBuilder.append("  ride_type: ").append(ride_type).append("\n");
    localStringBuilder.append("  drivers: ").append(drivers).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NearbyDriversDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */