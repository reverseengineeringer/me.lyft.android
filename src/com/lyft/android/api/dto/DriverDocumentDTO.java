package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DriverDocumentDTO
{
  @SerializedName("expirationDate")
  public final String expirationDate;
  @SerializedName("imageUploadUrl")
  public final String imageUploadUrl;
  @SerializedName("lastUpdated")
  public final String lastUpdated;
  @SerializedName("photo")
  public final String photo;
  @SerializedName("state")
  public final String state;
  @SerializedName("status")
  public final String status;
  
  public DriverDocumentDTO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    status = paramString1;
    state = paramString2;
    expirationDate = paramString3;
    lastUpdated = paramString4;
    photo = paramString5;
    imageUploadUrl = paramString6;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverDocumentDTO {\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("  state: ").append(state).append("\n");
    localStringBuilder.append("  expirationDate: ").append(expirationDate).append("\n");
    localStringBuilder.append("  lastUpdated: ").append(lastUpdated).append("\n");
    localStringBuilder.append("  photo: ").append(photo).append("\n");
    localStringBuilder.append("  imageUploadUrl: ").append(imageUploadUrl).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverDocumentDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */