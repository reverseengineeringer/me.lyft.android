package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class OrganizationUnverifiedDetailsDTO
{
  @SerializedName("unverifiedDescription")
  public final String unverifiedDescription;
  @SerializedName("unverifiedHeader")
  public final String unverifiedHeader;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class OrganizationUnverifiedDetailsDTO {\n");
    localStringBuilder.append("  unverifiedHeader: ").append(unverifiedHeader).append("\n");
    localStringBuilder.append("  unverifiedDescription: ").append(unverifiedDescription).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.OrganizationUnverifiedDetailsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */