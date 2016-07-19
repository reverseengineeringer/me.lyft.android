package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class CouponTemplateBodyDTO
{
  @SerializedName("value")
  public final CouponTemplateValueDTO value;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CouponTemplateBodyDTO {\n");
    localStringBuilder.append("  value: ").append(value).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CouponTemplateBodyDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */