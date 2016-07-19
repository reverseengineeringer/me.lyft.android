package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class StyleDTO
{
  @SerializedName("primaryColor")
  public final String primaryColor;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class StyleDTO {\n");
    localStringBuilder.append("  primaryColor: ").append(primaryColor).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.StyleDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */