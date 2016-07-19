package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class OrganizationPromotionStatusDTO
{
  @SerializedName("needed")
  public final Integer needed;
  @SerializedName("pendingApprovalText")
  public final String pendingApprovalText;
  @SerializedName("promotionDescription")
  public final String promotionDescription;
  @SerializedName("promotionHeader")
  public final String promotionHeader;
  @SerializedName("registered")
  public final Integer registered;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class OrganizationPromotionStatusDTO {\n");
    localStringBuilder.append("  needed: ").append(needed).append("\n");
    localStringBuilder.append("  registered: ").append(registered).append("\n");
    localStringBuilder.append("  promotionHeader: ").append(promotionHeader).append("\n");
    localStringBuilder.append("  promotionDescription: ").append(promotionDescription).append("\n");
    localStringBuilder.append("  pendingApprovalText: ").append(pendingApprovalText).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.OrganizationPromotionStatusDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */