package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ChargeAccountsResponseDTO
{
  @SerializedName("chargeAccounts")
  public final List<ChargeAccountDTO> chargeAccounts;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ChargeAccountsResponseDTO {\n");
    localStringBuilder.append("  chargeAccounts: ").append(chargeAccounts).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ChargeAccountsResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */