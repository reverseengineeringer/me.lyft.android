package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class MoneyDTO
{
  @SerializedName("amount")
  public final Integer amount;
  @SerializedName("amountCurrency")
  public final String amountCurrency;
  
  public MoneyDTO(Integer paramInteger, String paramString)
  {
    amount = paramInteger;
    amountCurrency = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class MoneyDTO {\n");
    localStringBuilder.append("  amount: ").append(amount).append("\n");
    localStringBuilder.append("  amountCurrency: ").append(amountCurrency).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.MoneyDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */