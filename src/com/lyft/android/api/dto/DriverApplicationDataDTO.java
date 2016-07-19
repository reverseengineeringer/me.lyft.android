package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DriverApplicationDataDTO
{
  @SerializedName("regions")
  public final List<RegionDTO> regions;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverApplicationDataDTO {\n");
    localStringBuilder.append("  regions: ").append(regions).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverApplicationDataDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */