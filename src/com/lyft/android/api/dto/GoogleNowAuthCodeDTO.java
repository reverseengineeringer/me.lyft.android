package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class GoogleNowAuthCodeDTO
{
  @SerializedName("authCode")
  public final String authCode;
  @SerializedName("expirationTimestamp")
  public final Long expirationTimestamp;
  
  public GoogleNowAuthCodeDTO(Long paramLong, String paramString)
  {
    expirationTimestamp = paramLong;
    authCode = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class GoogleNowAuthCodeDTO {\n");
    localStringBuilder.append("  expirationTimestamp: ").append(expirationTimestamp).append("\n");
    localStringBuilder.append("  authCode: ").append(authCode).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.GoogleNowAuthCodeDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */