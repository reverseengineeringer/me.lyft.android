package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ContributorUpdateRequestDTO
{
  @SerializedName("status")
  public final String status;
  
  public ContributorUpdateRequestDTO(String paramString)
  {
    status = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ContributorUpdateRequestDTO {\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ContributorUpdateRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */