package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class AccountInfoDTO
{
  @SerializedName("clientPaymentMethod")
  public final String clientPaymentMethod;
  @SerializedName("type")
  public final String type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class AccountInfoDTO {\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  clientPaymentMethod: ").append(clientPaymentMethod).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.AccountInfoDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */