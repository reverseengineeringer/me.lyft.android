package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FareSplitInviteRequestDTO
{
  @SerializedName("contributors")
  public final List<ContributorDTO> contributors;
  @SerializedName("rideId")
  public final String rideId;
  
  public FareSplitInviteRequestDTO(String paramString, List<ContributorDTO> paramList)
  {
    rideId = paramString;
    contributors = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class FareSplitInviteRequestDTO {\n");
    localStringBuilder.append("  rideId: ").append(rideId).append("\n");
    localStringBuilder.append("  contributors: ").append(contributors).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.FareSplitInviteRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */