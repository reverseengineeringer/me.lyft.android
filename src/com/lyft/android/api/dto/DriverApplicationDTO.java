package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DriverApplicationDTO
{
  @SerializedName("phone")
  public final String phone;
  @SerializedName("referralCode")
  public final String referralCode;
  @SerializedName("region")
  public final String region;
  @SerializedName("self")
  public final String self;
  @SerializedName("webOnboardingCompleteness")
  public final Integer webOnboardingCompleteness;
  
  public DriverApplicationDTO(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger)
  {
    self = paramString1;
    phone = paramString2;
    region = paramString3;
    referralCode = paramString4;
    webOnboardingCompleteness = paramInteger;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverApplicationDTO {\n");
    localStringBuilder.append("  self: ").append(self).append("\n");
    localStringBuilder.append("  phone: ").append(phone).append("\n");
    localStringBuilder.append("  region: ").append(region).append("\n");
    localStringBuilder.append("  referralCode: ").append(referralCode).append("\n");
    localStringBuilder.append("  webOnboardingCompleteness: ").append(webOnboardingCompleteness).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverApplicationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */