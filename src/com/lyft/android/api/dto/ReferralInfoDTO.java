package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ReferralInfoDTO
{
  @SerializedName("driver")
  public final DriverReferralDTO driver;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ReferralInfoDTO {\n");
    localStringBuilder.append("  driver: ").append(driver).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ReferralInfoDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */