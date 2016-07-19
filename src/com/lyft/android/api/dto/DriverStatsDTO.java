package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DriverStatsDTO
{
  @SerializedName("activities")
  public final List<DriverActivityDTO> activities;
  @SerializedName("cards")
  public final List<DriverAchievementCardDTO> cards;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverStatsDTO {\n");
    localStringBuilder.append("  activities: ").append(activities).append("\n");
    localStringBuilder.append("  cards: ").append(cards).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverStatsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */