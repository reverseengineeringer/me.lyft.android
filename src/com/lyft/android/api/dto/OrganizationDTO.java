package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class OrganizationDTO
{
  @SerializedName("benefitDetails")
  public final OrganizationBenefitDetailsDTO benefitDetails;
  @SerializedName("benefitStatus")
  public final OrganizationBenefitStatusDTO benefitStatus;
  @SerializedName("email")
  public final String email;
  @SerializedName("joinDetails")
  public final OrganizationJoinDetailsDTO joinDetails;
  @SerializedName("name")
  public final String name;
  @SerializedName("promotionDetails")
  public final OrganizationPromotionDetailsDTO promotionDetails;
  @SerializedName("promotionStatus")
  public final OrganizationPromotionStatusDTO promotionStatus;
  @SerializedName("status")
  public final String status;
  @SerializedName("unverifiedDetails")
  public final OrganizationUnverifiedDetailsDTO unverifiedDetails;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class OrganizationDTO {\n");
    localStringBuilder.append("  email: ").append(email).append("\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("  name: ").append(name).append("\n");
    localStringBuilder.append("  joinDetails: ").append(joinDetails).append("\n");
    localStringBuilder.append("  unverifiedDetails: ").append(unverifiedDetails).append("\n");
    localStringBuilder.append("  promotionStatus: ").append(promotionStatus).append("\n");
    localStringBuilder.append("  promotionDetails: ").append(promotionDetails).append("\n");
    localStringBuilder.append("  benefitDetails: ").append(benefitDetails).append("\n");
    localStringBuilder.append("  benefitStatus: ").append(benefitStatus).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.OrganizationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */