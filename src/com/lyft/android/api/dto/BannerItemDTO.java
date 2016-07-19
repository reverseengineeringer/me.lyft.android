package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class BannerItemDTO
{
  @SerializedName("bannerColor")
  public final String bannerColor;
  @SerializedName("deeplink")
  public final String deeplink;
  @SerializedName("text")
  public final String text;
  @SerializedName("textColor")
  public final String textColor;
  @SerializedName("url")
  public final String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class BannerItemDTO {\n");
    localStringBuilder.append("  text: ").append(text).append("\n");
    localStringBuilder.append("  url: ").append(url).append("\n");
    localStringBuilder.append("  deeplink: ").append(deeplink).append("\n");
    localStringBuilder.append("  textColor: ").append(textColor).append("\n");
    localStringBuilder.append("  bannerColor: ").append(bannerColor).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.BannerItemDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */