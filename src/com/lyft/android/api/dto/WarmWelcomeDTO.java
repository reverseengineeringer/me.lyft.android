package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class WarmWelcomeDTO
{
  @SerializedName("attribution_text")
  public final String attribution_text;
  @SerializedName("credit_text")
  public final String credit_text;
  @SerializedName("photo")
  public final String photo;
  @SerializedName("promo_text")
  public final String promo_text;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class WarmWelcomeDTO {\n");
    localStringBuilder.append("  attribution_text: ").append(attribution_text).append("\n");
    localStringBuilder.append("  credit_text: ").append(credit_text).append("\n");
    localStringBuilder.append("  photo: ").append(photo).append("\n");
    localStringBuilder.append("  promo_text: ").append(promo_text).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.WarmWelcomeDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */