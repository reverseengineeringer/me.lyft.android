package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class NewsFeedMessageDTO
{
  @SerializedName("button")
  public final NewsFeedButtonDTO button;
  @SerializedName("created_at_ms")
  public final Long created_at_ms;
  @SerializedName("description")
  public final String description;
  @SerializedName("id")
  public final String id;
  @SerializedName("image_url")
  public final String image_url;
  @SerializedName("progress")
  public final NewsFeedProgressBarDTO progress;
  @SerializedName("style")
  public final String style;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NewsFeedMessageDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  created_at_ms: ").append(created_at_ms).append("\n");
    localStringBuilder.append("  style: ").append(style).append("\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  description: ").append(description).append("\n");
    localStringBuilder.append("  image_url: ").append(image_url).append("\n");
    localStringBuilder.append("  progress: ").append(progress).append("\n");
    localStringBuilder.append("  button: ").append(button).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NewsFeedMessageDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */