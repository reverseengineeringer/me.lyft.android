package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RideHistoryDTO
{
  @SerializedName("data")
  public final List<RideHistoryItemBriefDTO> data;
  @SerializedName("hasMore")
  public final Boolean hasMore;
  @SerializedName("limit")
  public final Integer limit;
  @SerializedName("skip")
  public final Integer skip;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideHistoryDTO {\n");
    localStringBuilder.append("  hasMore: ").append(hasMore).append("\n");
    localStringBuilder.append("  limit: ").append(limit).append("\n");
    localStringBuilder.append("  skip: ").append(skip).append("\n");
    localStringBuilder.append("  data: ").append(data).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideHistoryDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */