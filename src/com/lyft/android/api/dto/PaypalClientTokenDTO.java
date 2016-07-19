package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PaypalClientTokenDTO
{
  @SerializedName("clientToken")
  public final String clientToken;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PaypalClientTokenDTO {\n");
    localStringBuilder.append("  clientToken: ").append(clientToken).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PaypalClientTokenDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */