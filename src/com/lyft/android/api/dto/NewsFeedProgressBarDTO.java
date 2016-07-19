package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class NewsFeedProgressBarDTO
{
  @SerializedName("label")
  public final String label;
  @SerializedName("percent")
  public final Integer percent;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NewsFeedProgressBarDTO {\n");
    localStringBuilder.append("  percent: ").append(percent).append("\n");
    localStringBuilder.append("  label: ").append(label).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NewsFeedProgressBarDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */