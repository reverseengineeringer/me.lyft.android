package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class OrganizationBenefitStatusDTO
{
  @SerializedName("benefitDescription")
  public final String benefitDescription;
  @SerializedName("benefitHeader")
  public final String benefitHeader;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class OrganizationBenefitStatusDTO {\n");
    localStringBuilder.append("  benefitHeader: ").append(benefitHeader).append("\n");
    localStringBuilder.append("  benefitDescription: ").append(benefitDescription).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.OrganizationBenefitStatusDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */