package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ClientPermissionsRequestDTO
{
  @SerializedName("alertEnabled")
  public final Boolean alertEnabled;
  @SerializedName("badgeEnabled")
  public final Boolean badgeEnabled;
  @SerializedName("locationPermission")
  public final String locationPermission;
  @SerializedName("pushEnabled")
  public final Boolean pushEnabled;
  @SerializedName("soundEnabled")
  public final Boolean soundEnabled;
  
  public ClientPermissionsRequestDTO(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, String paramString)
  {
    pushEnabled = paramBoolean1;
    badgeEnabled = paramBoolean2;
    soundEnabled = paramBoolean3;
    alertEnabled = paramBoolean4;
    locationPermission = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ClientPermissionsRequestDTO {\n");
    localStringBuilder.append("  pushEnabled: ").append(pushEnabled).append("\n");
    localStringBuilder.append("  badgeEnabled: ").append(badgeEnabled).append("\n");
    localStringBuilder.append("  soundEnabled: ").append(soundEnabled).append("\n");
    localStringBuilder.append("  alertEnabled: ").append(alertEnabled).append("\n");
    localStringBuilder.append("  locationPermission: ").append(locationPermission).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ClientPermissionsRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */