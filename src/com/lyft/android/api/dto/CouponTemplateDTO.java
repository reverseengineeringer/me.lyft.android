package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class CouponTemplateDTO
{
  @SerializedName("code")
  public final String code;
  @SerializedName("driver_kickback_template")
  public final CouponTemplateBodyDTO driver_kickback_template;
  @SerializedName("driver_template")
  public final CouponTemplateBodyDTO driver_template;
  @SerializedName("passenger_kickback_template")
  public final CouponTemplateBodyDTO passenger_kickback_template;
  @SerializedName("passenger_template")
  public final CouponTemplateBodyDTO passenger_template;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CouponTemplateDTO {\n");
    localStringBuilder.append("  code: ").append(code).append("\n");
    localStringBuilder.append("  passenger_template: ").append(passenger_template).append("\n");
    localStringBuilder.append("  passenger_kickback_template: ").append(passenger_kickback_template).append("\n");
    localStringBuilder.append("  driver_template: ").append(driver_template).append("\n");
    localStringBuilder.append("  driver_kickback_template: ").append(driver_kickback_template).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CouponTemplateDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */