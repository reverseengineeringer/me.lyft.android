package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class MutualFriendDTO
{
  @SerializedName("name")
  public final String name;
  @SerializedName("photo")
  public final String photo;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class MutualFriendDTO {\n");
    localStringBuilder.append("  name: ").append(name).append("\n");
    localStringBuilder.append("  photo: ").append(photo).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.MutualFriendDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */