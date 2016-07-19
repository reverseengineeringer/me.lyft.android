package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class VehicleDTO
{
  @SerializedName("color")
  public final String color;
  @SerializedName("displayName")
  public final String displayName;
  @SerializedName("documents")
  public final VehicleDocumentsDTO documents;
  @SerializedName("id")
  public final String id;
  @SerializedName("licensePlate")
  public final String licensePlate;
  @SerializedName("make")
  public final String make;
  @SerializedName("model")
  public final String model;
  @SerializedName("photo")
  public final String photo;
  @SerializedName("state")
  public final String state;
  @SerializedName("status")
  public final String status;
  @SerializedName("statusText")
  public final String statusText;
  @SerializedName("year")
  public final Integer year;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class VehicleDTO {\n");
    localStringBuilder.append("  photo: ").append(photo).append("\n");
    localStringBuilder.append("  year: ").append(year).append("\n");
    localStringBuilder.append("  make: ").append(make).append("\n");
    localStringBuilder.append("  model: ").append(model).append("\n");
    localStringBuilder.append("  state: ").append(state).append("\n");
    localStringBuilder.append("  licensePlate: ").append(licensePlate).append("\n");
    localStringBuilder.append("  color: ").append(color).append("\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("  statusText: ").append(statusText).append("\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  displayName: ").append(displayName).append("\n");
    localStringBuilder.append("  documents: ").append(documents).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.VehicleDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */