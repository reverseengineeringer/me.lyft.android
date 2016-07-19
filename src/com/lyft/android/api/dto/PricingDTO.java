package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PricingDTO
{
  @SerializedName("dynamicPricing")
  public final Integer dynamicPricing;
  @SerializedName("minimum")
  public final String minimum;
  @SerializedName("perMile")
  public final String perMile;
  @SerializedName("perMinute")
  public final String perMinute;
  @SerializedName("pickup")
  public final String pickup;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PricingDTO {\n");
    localStringBuilder.append("  dynamicPricing: ").append(dynamicPricing).append("\n");
    localStringBuilder.append("  minimum: ").append(minimum).append("\n");
    localStringBuilder.append("  pickup: ").append(pickup).append("\n");
    localStringBuilder.append("  perMile: ").append(perMile).append("\n");
    localStringBuilder.append("  perMinute: ").append(perMinute).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PricingDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */