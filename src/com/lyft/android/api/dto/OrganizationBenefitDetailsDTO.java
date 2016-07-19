package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class OrganizationBenefitDetailsDTO
{
  @SerializedName("benefitCredit")
  public final String benefitCredit;
  @SerializedName("benefitDescription")
  public final String benefitDescription;
  @SerializedName("benefitRestriction")
  public final String benefitRestriction;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class OrganizationBenefitDetailsDTO {\n");
    localStringBuilder.append("  benefitDescription: ").append(benefitDescription).append("\n");
    localStringBuilder.append("  benefitCredit: ").append(benefitCredit).append("\n");
    localStringBuilder.append("  benefitRestriction: ").append(benefitRestriction).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.OrganizationBenefitDetailsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */