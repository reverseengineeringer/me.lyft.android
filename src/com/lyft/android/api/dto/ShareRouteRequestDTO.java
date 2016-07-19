package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ShareRouteRequestDTO
{
  @SerializedName("id")
  public final String id;
  
  public ShareRouteRequestDTO(String paramString)
  {
    id = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ShareRouteRequestDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ShareRouteRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */