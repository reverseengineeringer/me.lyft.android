package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PricingDetailsDTO
{
  @SerializedName("base_charge")
  public final Integer base_charge;
  @SerializedName("cancel_penalty_amount")
  public final Integer cancel_penalty_amount;
  @SerializedName("cost_minimum")
  public final Integer cost_minimum;
  @SerializedName("cost_per_mile")
  public final Integer cost_per_mile;
  @SerializedName("cost_per_minute")
  public final Integer cost_per_minute;
  @SerializedName("currency")
  public final String currency;
  @SerializedName("trust_and_service")
  public final Integer trust_and_service;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PricingDetailsDTO {\n");
    localStringBuilder.append("  base_charge: ").append(base_charge).append("\n");
    localStringBuilder.append("  cancel_penalty_amount: ").append(cancel_penalty_amount).append("\n");
    localStringBuilder.append("  cost_minimum: ").append(cost_minimum).append("\n");
    localStringBuilder.append("  cost_per_mile: ").append(cost_per_mile).append("\n");
    localStringBuilder.append("  cost_per_minute: ").append(cost_per_minute).append("\n");
    localStringBuilder.append("  currency: ").append(currency).append("\n");
    localStringBuilder.append("  trust_and_service: ").append(trust_and_service).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PricingDetailsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */