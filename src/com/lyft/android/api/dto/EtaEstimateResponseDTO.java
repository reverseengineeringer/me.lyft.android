package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EtaEstimateResponseDTO
{
  @SerializedName("eta_estimates")
  public final List<EtaEstimateDTO> eta_estimates;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class EtaEstimateResponseDTO {\n");
    localStringBuilder.append("  eta_estimates: ").append(eta_estimates).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.EtaEstimateResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */