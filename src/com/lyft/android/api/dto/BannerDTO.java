package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class BannerDTO
{
  @SerializedName("bannerItem")
  public final BannerItemDTO bannerItem;
  @SerializedName("rideType")
  public final String rideType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class BannerDTO {\n");
    localStringBuilder.append("  rideType: ").append(rideType).append("\n");
    localStringBuilder.append("  bannerItem: ").append(bannerItem).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.BannerDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */