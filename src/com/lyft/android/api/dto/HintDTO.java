package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class HintDTO
{
  @SerializedName("backgroundColor")
  public final String backgroundColor;
  @SerializedName("id")
  public final String id;
  @SerializedName("numDisplays")
  public final Integer numDisplays;
  @SerializedName("text")
  public final String text;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class HintDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  text: ").append(text).append("\n");
    localStringBuilder.append("  numDisplays: ").append(numDisplays).append("\n");
    localStringBuilder.append("  backgroundColor: ").append(backgroundColor).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.HintDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */