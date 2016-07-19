package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ContributorRequestDTO
{
  @SerializedName("id")
  public final String id;
  @SerializedName("initiatorName")
  public final String initiatorName;
  @SerializedName("initiatorPhoto")
  public final String initiatorPhoto;
  @SerializedName("status")
  public final String status;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ContributorRequestDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  initiatorName: ").append(initiatorName).append("\n");
    localStringBuilder.append("  initiatorPhoto: ").append(initiatorPhoto).append("\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ContributorRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */