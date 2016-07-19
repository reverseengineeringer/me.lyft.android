package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class RidePaymentDTO
{
  @SerializedName("chargeToken")
  public final String chargeToken;
  @SerializedName("id")
  public final String id;
  @SerializedName("method")
  public final String method;
  @SerializedName("money")
  public final MoneyDTO money;
  
  public RidePaymentDTO(String paramString1, String paramString2, MoneyDTO paramMoneyDTO, String paramString3)
  {
    method = paramString1;
    id = paramString2;
    money = paramMoneyDTO;
    chargeToken = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RidePaymentDTO {\n");
    localStringBuilder.append("  method: ").append(method).append("\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  money: ").append(money).append("\n");
    localStringBuilder.append("  chargeToken: ").append(chargeToken).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RidePaymentDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */