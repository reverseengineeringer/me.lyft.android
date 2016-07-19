package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class NotificationDTO
{
  @SerializedName("event")
  public final String event;
  @SerializedName("height")
  public final Integer height;
  @SerializedName("sourceUrl")
  public final String sourceUrl;
  @SerializedName("width")
  public final Integer width;
  
  public NotificationDTO(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2)
  {
    event = paramString1;
    sourceUrl = paramString2;
    width = paramInteger1;
    height = paramInteger2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NotificationDTO {\n");
    localStringBuilder.append("  event: ").append(event).append("\n");
    localStringBuilder.append("  sourceUrl: ").append(sourceUrl).append("\n");
    localStringBuilder.append("  width: ").append(width).append("\n");
    localStringBuilder.append("  height: ").append(height).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NotificationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */