package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DriverActivityDTO
{
  @SerializedName("amountEarned")
  public final MoneyDTO amountEarned;
  @SerializedName("rideCount")
  public final Integer rideCount;
  @SerializedName("subtitle")
  public final String subtitle;
  @SerializedName("timeDrivenSecs")
  public final Integer timeDrivenSecs;
  @SerializedName("title")
  public final String title;
  @SerializedName("type")
  public final String type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverActivityDTO {\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  amountEarned: ").append(amountEarned).append("\n");
    localStringBuilder.append("  rideCount: ").append(rideCount).append("\n");
    localStringBuilder.append("  timeDrivenSecs: ").append(timeDrivenSecs).append("\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  subtitle: ").append(subtitle).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverActivityDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */