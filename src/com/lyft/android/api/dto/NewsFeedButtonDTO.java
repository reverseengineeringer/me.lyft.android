package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class NewsFeedButtonDTO
{
  @SerializedName("text")
  public final String text;
  @SerializedName("url")
  public final String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NewsFeedButtonDTO {\n");
    localStringBuilder.append("  text: ").append(text).append("\n");
    localStringBuilder.append("  url: ").append(url).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NewsFeedButtonDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */