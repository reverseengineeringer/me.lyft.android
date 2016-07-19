package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DriverReferralDTO
{
  @SerializedName("daysUntilExpiration")
  public final Integer daysUntilExpiration;
  @SerializedName("payout")
  public final MoneyDTO payout;
  @SerializedName("refereePayout")
  public final MoneyDTO refereePayout;
  @SerializedName("regionLabel")
  public final String regionLabel;
  @SerializedName("requiredRidesCount")
  public final Integer requiredRidesCount;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverReferralDTO {\n");
    localStringBuilder.append("  payout: ").append(payout).append("\n");
    localStringBuilder.append("  refereePayout: ").append(refereePayout).append("\n");
    localStringBuilder.append("  requiredRidesCount: ").append(requiredRidesCount).append("\n");
    localStringBuilder.append("  daysUntilExpiration: ").append(daysUntilExpiration).append("\n");
    localStringBuilder.append("  regionLabel: ").append(regionLabel).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverReferralDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */