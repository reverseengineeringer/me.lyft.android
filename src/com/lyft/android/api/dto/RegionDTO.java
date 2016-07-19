package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class RegionDTO
{
  @SerializedName("code")
  public final String code;
  @SerializedName("label")
  public final String label;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RegionDTO {\n");
    localStringBuilder.append("  code: ").append(code).append("\n");
    localStringBuilder.append("  label: ").append(label).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RegionDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */