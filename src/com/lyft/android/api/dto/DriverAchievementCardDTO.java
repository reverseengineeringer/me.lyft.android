package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DriverAchievementCardDTO
{
  @SerializedName("buttonText")
  public final String buttonText;
  @SerializedName("dials")
  public final List<DialDTO> dials;
  @SerializedName("footer")
  public final String footer;
  @SerializedName("infoUrl")
  public final String infoUrl;
  @SerializedName("style")
  public final String style;
  @SerializedName("subtitle")
  public final String subtitle;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverAchievementCardDTO {\n");
    localStringBuilder.append("  style: ").append(style).append("\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  subtitle: ").append(subtitle).append("\n");
    localStringBuilder.append("  infoUrl: ").append(infoUrl).append("\n");
    localStringBuilder.append("  buttonText: ").append(buttonText).append("\n");
    localStringBuilder.append("  footer: ").append(footer).append("\n");
    localStringBuilder.append("  dials: ").append(dials).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverAchievementCardDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */