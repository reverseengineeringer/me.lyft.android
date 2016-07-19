package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class AdditionalCostEstimateDTO
{
  @SerializedName("estimated_cost_cents_max")
  public final Integer estimated_cost_cents_max;
  @SerializedName("estimated_cost_cents_min")
  public final Integer estimated_cost_cents_min;
  @SerializedName("seats")
  public final Integer seats;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class AdditionalCostEstimateDTO {\n");
    localStringBuilder.append("  seats: ").append(seats).append("\n");
    localStringBuilder.append("  estimated_cost_cents_max: ").append(estimated_cost_cents_max).append("\n");
    localStringBuilder.append("  estimated_cost_cents_min: ").append(estimated_cost_cents_min).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.AdditionalCostEstimateDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */