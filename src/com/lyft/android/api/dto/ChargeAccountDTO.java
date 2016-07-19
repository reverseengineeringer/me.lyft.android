package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ChargeAccountDTO
{
  @SerializedName("default")
  public final Boolean _default;
  @SerializedName("clientPaymentMethod")
  public final String clientPaymentMethod;
  @SerializedName("defaultBusiness")
  public final Boolean defaultBusiness;
  @SerializedName("email")
  public final String email;
  @SerializedName("failed")
  public final Boolean failed;
  @SerializedName("id")
  public final String id;
  @SerializedName("label")
  public final String label;
  @SerializedName("labelType")
  public final String labelType;
  @SerializedName("lastFour")
  public final String lastFour;
  @SerializedName("requestNotes")
  public final Boolean requestNotes;
  @SerializedName("type")
  public final String type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ChargeAccountDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  _default: ").append(_default).append("\n");
    localStringBuilder.append("  defaultBusiness: ").append(defaultBusiness).append("\n");
    localStringBuilder.append("  label: ").append(label).append("\n");
    localStringBuilder.append("  labelType: ").append(labelType).append("\n");
    localStringBuilder.append("  failed: ").append(failed).append("\n");
    localStringBuilder.append("  email: ").append(email).append("\n");
    localStringBuilder.append("  requestNotes: ").append(requestNotes).append("\n");
    localStringBuilder.append("  clientPaymentMethod: ").append(clientPaymentMethod).append("\n");
    localStringBuilder.append("  lastFour: ").append(lastFour).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ChargeAccountDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */