package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class CouponDTO
{
  @SerializedName("id")
  public final String id;
  @SerializedName("lineItemTitle")
  public final String lineItemTitle;
  @SerializedName("money")
  public final MoneyDTO money;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CouponDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  money: ").append(money).append("\n");
    localStringBuilder.append("  lineItemTitle: ").append(lineItemTitle).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CouponDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */