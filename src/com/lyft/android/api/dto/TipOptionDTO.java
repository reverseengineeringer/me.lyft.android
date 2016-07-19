package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class TipOptionDTO
{
  @SerializedName("money")
  public final MoneyDTO money;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class TipOptionDTO {\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  money: ").append(money).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.TipOptionDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */