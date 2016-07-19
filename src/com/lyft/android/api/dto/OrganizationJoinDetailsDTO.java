package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class OrganizationJoinDetailsDTO
{
  @SerializedName("joinDescription")
  public final String joinDescription;
  @SerializedName("joinHeader")
  public final String joinHeader;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class OrganizationJoinDetailsDTO {\n");
    localStringBuilder.append("  joinHeader: ").append(joinHeader).append("\n");
    localStringBuilder.append("  joinDescription: ").append(joinDescription).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.OrganizationJoinDetailsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */