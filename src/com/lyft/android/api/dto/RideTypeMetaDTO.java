package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class RideTypeMetaDTO
{
  @SerializedName("actions")
  public final ActionsDTO actions;
  @SerializedName("displayNewBadge")
  public final Boolean displayNewBadge;
  @SerializedName("maximumContributors")
  public final Integer maximumContributors;
  @SerializedName("popup")
  public final PopupDTO popup;
  @SerializedName("publicId")
  public final String publicId;
  @SerializedName("style")
  public final StyleDTO style;
  @SerializedName("supportsFareEstimation")
  public final Boolean supportsFareEstimation;
  @SerializedName("typeInformation")
  public final TypeInformationDTO typeInformation;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideTypeMetaDTO {\n");
    localStringBuilder.append("  publicId: ").append(publicId).append("\n");
    localStringBuilder.append("  maximumContributors: ").append(maximumContributors).append("\n");
    localStringBuilder.append("  supportsFareEstimation: ").append(supportsFareEstimation).append("\n");
    localStringBuilder.append("  displayNewBadge: ").append(displayNewBadge).append("\n");
    localStringBuilder.append("  typeInformation: ").append(typeInformation).append("\n");
    localStringBuilder.append("  actions: ").append(actions).append("\n");
    localStringBuilder.append("  popup: ").append(popup).append("\n");
    localStringBuilder.append("  style: ").append(style).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideTypeMetaDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */