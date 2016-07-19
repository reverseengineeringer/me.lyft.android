package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DriverProfileDTO
{
  @SerializedName("driver_shortcut_enabled")
  public final Boolean driver_shortcut_enabled;
  
  public DriverProfileDTO(Boolean paramBoolean)
  {
    driver_shortcut_enabled = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverProfileDTO {\n");
    localStringBuilder.append("  driver_shortcut_enabled: ").append(driver_shortcut_enabled).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverProfileDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */