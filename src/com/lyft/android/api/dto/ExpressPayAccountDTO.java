package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ExpressPayAccountDTO
{
  @SerializedName("failed")
  public final Boolean failed;
  @SerializedName("failedMessage")
  public final String failedMessage;
  @SerializedName("id")
  public final String id;
  @SerializedName("lastFour")
  public final String lastFour;
  @SerializedName("successMessage")
  public final String successMessage;
  @SerializedName("type")
  public final String type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ExpressPayAccountDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  lastFour: ").append(lastFour).append("\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  failed: ").append(failed).append("\n");
    localStringBuilder.append("  failedMessage: ").append(failedMessage).append("\n");
    localStringBuilder.append("  successMessage: ").append(successMessage).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ExpressPayAccountDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */