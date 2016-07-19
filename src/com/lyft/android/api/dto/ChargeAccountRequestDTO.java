package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ChargeAccountRequestDTO
{
  @SerializedName("default")
  public final Boolean _default;
  @SerializedName("chargeToken")
  public final String chargeToken;
  @SerializedName("clientPaymentMethod")
  public final String clientPaymentMethod;
  @SerializedName("defaultBusiness")
  public final Boolean defaultBusiness;
  @SerializedName("label")
  public final String label;
  @SerializedName("labelType")
  public final String labelType;
  @SerializedName("nonce")
  public final String nonce;
  @SerializedName("token")
  public final String token;
  
  public ChargeAccountRequestDTO(String paramString1, String paramString2, Boolean paramBoolean1, Boolean paramBoolean2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    clientPaymentMethod = paramString1;
    token = paramString2;
    _default = paramBoolean1;
    defaultBusiness = paramBoolean2;
    labelType = paramString3;
    label = paramString4;
    nonce = paramString5;
    chargeToken = paramString6;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ChargeAccountRequestDTO {\n");
    localStringBuilder.append("  clientPaymentMethod: ").append(clientPaymentMethod).append("\n");
    localStringBuilder.append("  token: ").append(token).append("\n");
    localStringBuilder.append("  _default: ").append(_default).append("\n");
    localStringBuilder.append("  defaultBusiness: ").append(defaultBusiness).append("\n");
    localStringBuilder.append("  labelType: ").append(labelType).append("\n");
    localStringBuilder.append("  label: ").append(label).append("\n");
    localStringBuilder.append("  nonce: ").append(nonce).append("\n");
    localStringBuilder.append("  chargeToken: ").append(chargeToken).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ChargeAccountRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */