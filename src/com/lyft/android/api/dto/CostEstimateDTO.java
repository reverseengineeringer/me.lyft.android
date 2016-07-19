package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CostEstimateDTO
{
  @SerializedName("additional_estimates")
  public final List<AdditionalCostEstimateDTO> additional_estimates;
  @SerializedName("comparison_cents")
  public final Integer comparison_cents;
  @SerializedName("cost_token")
  public final String cost_token;
  @SerializedName("currency")
  public final String currency;
  @SerializedName("display_name")
  public final String display_name;
  @SerializedName("error_message")
  public final String error_message;
  @SerializedName("estimated_cost_cents_max")
  public final Integer estimated_cost_cents_max;
  @SerializedName("estimated_cost_cents_min")
  public final Integer estimated_cost_cents_min;
  @SerializedName("estimated_distance_miles")
  public final Double estimated_distance_miles;
  @SerializedName("estimated_duration_seconds")
  public final Integer estimated_duration_seconds;
  @SerializedName("primetime_confirmation_token")
  public final String primetime_confirmation_token;
  @SerializedName("primetime_multiplier")
  public final Double primetime_multiplier;
  @SerializedName("primetime_percentage")
  public final String primetime_percentage;
  @SerializedName("ride_type")
  public final String ride_type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CostEstimateDTO {\n");
    localStringBuilder.append("  ride_type: ").append(ride_type).append("\n");
    localStringBuilder.append("  display_name: ").append(display_name).append("\n");
    localStringBuilder.append("  estimated_duration_seconds: ").append(estimated_duration_seconds).append("\n");
    localStringBuilder.append("  estimated_distance_miles: ").append(estimated_distance_miles).append("\n");
    localStringBuilder.append("  estimated_cost_cents_max: ").append(estimated_cost_cents_max).append("\n");
    localStringBuilder.append("  estimated_cost_cents_min: ").append(estimated_cost_cents_min).append("\n");
    localStringBuilder.append("  currency: ").append(currency).append("\n");
    localStringBuilder.append("  cost_token: ").append(cost_token).append("\n");
    localStringBuilder.append("  primetime_confirmation_token: ").append(primetime_confirmation_token).append("\n");
    localStringBuilder.append("  primetime_percentage: ").append(primetime_percentage).append("\n");
    localStringBuilder.append("  primetime_multiplier: ").append(primetime_multiplier).append("\n");
    localStringBuilder.append("  error_message: ").append(error_message).append("\n");
    localStringBuilder.append("  comparison_cents: ").append(comparison_cents).append("\n");
    localStringBuilder.append("  additional_estimates: ").append(additional_estimates).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CostEstimateDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */