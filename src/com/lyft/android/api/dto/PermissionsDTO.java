package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PermissionsDTO
{
  @SerializedName("canShowMutualFriends")
  public final Boolean canShowMutualFriends;
  
  public PermissionsDTO(Boolean paramBoolean)
  {
    canShowMutualFriends = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PermissionsDTO {\n");
    localStringBuilder.append("  canShowMutualFriends: ").append(canShowMutualFriends).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PermissionsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */