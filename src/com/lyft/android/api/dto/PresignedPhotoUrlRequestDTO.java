package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PresignedPhotoUrlRequestDTO
{
  @SerializedName("purpose")
  public final String purpose;
  
  public PresignedPhotoUrlRequestDTO(String paramString)
  {
    purpose = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PresignedPhotoUrlRequestDTO {\n");
    localStringBuilder.append("  purpose: ").append(purpose).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PresignedPhotoUrlRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */