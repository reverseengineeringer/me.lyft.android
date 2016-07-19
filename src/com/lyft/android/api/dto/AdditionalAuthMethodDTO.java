package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class AdditionalAuthMethodDTO
{
  @SerializedName("authResponse")
  public final String authResponse;
  @SerializedName("authType")
  public final String authType;
  
  public AdditionalAuthMethodDTO(String paramString1, String paramString2)
  {
    authType = paramString1;
    authResponse = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class AdditionalAuthMethodDTO {\n");
    localStringBuilder.append("  authType: ").append(authType).append("\n");
    localStringBuilder.append("  authResponse: ").append(authResponse).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.AdditionalAuthMethodDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */