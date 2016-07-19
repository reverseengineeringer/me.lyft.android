package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class VehiclesDTO
{
  @SerializedName("vehicles")
  public final List<VehicleDTO> vehicles;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class VehiclesDTO {\n");
    localStringBuilder.append("  vehicles: ").append(vehicles).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.VehiclesDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */