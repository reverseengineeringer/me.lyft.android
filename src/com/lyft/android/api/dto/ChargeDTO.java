package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ChargeDTO
{
  @SerializedName("chargeAccount")
  public final AccountInfoDTO chargeAccount;
  @SerializedName("money")
  public final MoneyDTO money;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ChargeDTO {\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  money: ").append(money).append("\n");
    localStringBuilder.append("  chargeAccount: ").append(chargeAccount).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ChargeDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */