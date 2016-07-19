package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class RideVehicleDTO
{
  @SerializedName("color")
  public final String color;
  @SerializedName("licensePlate")
  public final String licensePlate;
  @SerializedName("make")
  public final String make;
  @SerializedName("model")
  public final String model;
  @SerializedName("photo")
  public final String photo;
  @SerializedName("transparentPhoto")
  public final String transparentPhoto;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideVehicleDTO {\n");
    localStringBuilder.append("  make: ").append(make).append("\n");
    localStringBuilder.append("  model: ").append(model).append("\n");
    localStringBuilder.append("  licensePlate: ").append(licensePlate).append("\n");
    localStringBuilder.append("  photo: ").append(photo).append("\n");
    localStringBuilder.append("  transparentPhoto: ").append(transparentPhoto).append("\n");
    localStringBuilder.append("  color: ").append(color).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideVehicleDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */