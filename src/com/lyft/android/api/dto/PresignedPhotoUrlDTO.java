package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PresignedPhotoUrlDTO
{
  @SerializedName("purpose")
  public final String purpose;
  @SerializedName("uploadUrl")
  public final String uploadUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PresignedPhotoUrlDTO {\n");
    localStringBuilder.append("  purpose: ").append(purpose).append("\n");
    localStringBuilder.append("  uploadUrl: ").append(uploadUrl).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PresignedPhotoUrlDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */