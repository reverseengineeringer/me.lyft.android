package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ShareRouteDTO
{
  @SerializedName("generatedAt")
  public final String generatedAt;
  @SerializedName("shareUrl")
  public final String shareUrl;
  @SerializedName("timestamp")
  public final Long timestamp;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ShareRouteDTO {\n");
    localStringBuilder.append("  generatedAt: ").append(generatedAt).append("\n");
    localStringBuilder.append("  shareUrl: ").append(shareUrl).append("\n");
    localStringBuilder.append("  timestamp: ").append(timestamp).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ShareRouteDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */