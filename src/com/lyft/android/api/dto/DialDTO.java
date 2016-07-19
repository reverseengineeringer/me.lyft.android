package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DialDTO
{
  @SerializedName("goalMet")
  public final Boolean goalMet;
  @SerializedName("maxValue")
  public final Integer maxValue;
  @SerializedName("payout")
  public final MoneyDTO payout;
  @SerializedName("subtitle")
  public final String subtitle;
  @SerializedName("title")
  public final String title;
  @SerializedName("type")
  public final String type;
  @SerializedName("value")
  public final Integer value;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DialDTO {\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  payout: ").append(payout).append("\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  subtitle: ").append(subtitle).append("\n");
    localStringBuilder.append("  value: ").append(value).append("\n");
    localStringBuilder.append("  maxValue: ").append(maxValue).append("\n");
    localStringBuilder.append("  goalMet: ").append(goalMet).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DialDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */