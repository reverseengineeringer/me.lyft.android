package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ActionsDTO
{
  @SerializedName("destinationActiveColor")
  public final String destinationActiveColor;
  @SerializedName("destinationColor")
  public final String destinationColor;
  @SerializedName("destinationLabel")
  public final String destinationLabel;
  @SerializedName("pickupActiveColor")
  public final String pickupActiveColor;
  @SerializedName("pickupColor")
  public final String pickupColor;
  @SerializedName("pickupLabel")
  public final String pickupLabel;
  @SerializedName("requestActiveColor")
  public final String requestActiveColor;
  @SerializedName("requestColor")
  public final String requestColor;
  @SerializedName("requestLabel")
  public final String requestLabel;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ActionsDTO {\n");
    localStringBuilder.append("  pickupLabel: ").append(pickupLabel).append("\n");
    localStringBuilder.append("  pickupColor: ").append(pickupColor).append("\n");
    localStringBuilder.append("  pickupActiveColor: ").append(pickupActiveColor).append("\n");
    localStringBuilder.append("  destinationLabel: ").append(destinationLabel).append("\n");
    localStringBuilder.append("  destinationColor: ").append(destinationColor).append("\n");
    localStringBuilder.append("  destinationActiveColor: ").append(destinationActiveColor).append("\n");
    localStringBuilder.append("  requestLabel: ").append(requestLabel).append("\n");
    localStringBuilder.append("  requestColor: ").append(requestColor).append("\n");
    localStringBuilder.append("  requestActiveColor: ").append(requestActiveColor).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ActionsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */