package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class CreateExpressPayAccountDTO
{
  @SerializedName("paymentMethod")
  public final String paymentMethod;
  @SerializedName("token")
  public final String token;
  
  public CreateExpressPayAccountDTO(String paramString1, String paramString2)
  {
    paymentMethod = paramString1;
    token = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CreateExpressPayAccountDTO {\n");
    localStringBuilder.append("  paymentMethod: ").append(paymentMethod).append("\n");
    localStringBuilder.append("  token: ").append(token).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CreateExpressPayAccountDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */