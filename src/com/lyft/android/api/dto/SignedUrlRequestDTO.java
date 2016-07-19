package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class SignedUrlRequestDTO
{
  @SerializedName("ttl")
  public final Integer ttl;
  @SerializedName("url")
  public final String url;
  
  public SignedUrlRequestDTO(String paramString, Integer paramInteger)
  {
    url = paramString;
    ttl = paramInteger;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class SignedUrlRequestDTO {\n");
    localStringBuilder.append("  url: ").append(url).append("\n");
    localStringBuilder.append("  ttl: ").append(ttl).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.SignedUrlRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */