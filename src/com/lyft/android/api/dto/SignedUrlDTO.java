package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class SignedUrlDTO
{
  @SerializedName("expires")
  public final String expires;
  @SerializedName("signedUrl")
  public final String signedUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class SignedUrlDTO {\n");
    localStringBuilder.append("  signedUrl: ").append(signedUrl).append("\n");
    localStringBuilder.append("  expires: ").append(expires).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.SignedUrlDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */