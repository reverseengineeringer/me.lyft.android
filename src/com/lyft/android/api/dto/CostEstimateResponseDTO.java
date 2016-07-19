package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CostEstimateResponseDTO
{
  @SerializedName("cost_estimates")
  public final List<CostEstimateDTO> cost_estimates;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CostEstimateResponseDTO {\n");
    localStringBuilder.append("  cost_estimates: ").append(cost_estimates).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CostEstimateResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */