package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class OrganizationPromotionDetailsDTO
{
  @SerializedName("promotionDescription")
  public final String promotionDescription;
  @SerializedName("promotionHeader")
  public final String promotionHeader;
  @SerializedName("promotionPeriod")
  public final String promotionPeriod;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class OrganizationPromotionDetailsDTO {\n");
    localStringBuilder.append("  promotionHeader: ").append(promotionHeader).append("\n");
    localStringBuilder.append("  promotionPeriod: ").append(promotionPeriod).append("\n");
    localStringBuilder.append("  promotionDescription: ").append(promotionDescription).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.OrganizationPromotionDetailsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */