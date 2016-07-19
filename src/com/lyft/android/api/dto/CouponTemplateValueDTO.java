package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class CouponTemplateValueDTO
{
  @SerializedName("amount")
  public final Integer amount;
  @SerializedName("currency")
  public final String currency;
  @SerializedName("discount_ratio")
  public final Float discount_ratio;
  @SerializedName("max_amount_per_ride")
  public final Integer max_amount_per_ride;
  @SerializedName("pretty_amount")
  public final String pretty_amount;
  @SerializedName("type")
  public final String type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CouponTemplateValueDTO {\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  amount: ").append(amount).append("\n");
    localStringBuilder.append("  max_amount_per_ride: ").append(max_amount_per_ride).append("\n");
    localStringBuilder.append("  discount_ratio: ").append(discount_ratio).append("\n");
    localStringBuilder.append("  currency: ").append(currency).append("\n");
    localStringBuilder.append("  pretty_amount: ").append(pretty_amount).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CouponTemplateValueDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */