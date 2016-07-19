package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DeprecatedPlaceDTO
{
  @SerializedName("address")
  public final String address;
  @SerializedName("lat")
  public final Double lat;
  @SerializedName("lng")
  public final Double lng;
  @SerializedName("navigationMethod")
  public final String navigationMethod;
  @SerializedName("placeId")
  public final String placeId;
  @SerializedName("placeName")
  public final String placeName;
  @SerializedName("routableAddress")
  public final String routableAddress;
  @SerializedName("source")
  public final String source;
  
  public DeprecatedPlaceDTO(Double paramDouble1, Double paramDouble2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    lat = paramDouble1;
    lng = paramDouble2;
    address = paramString1;
    placeName = paramString2;
    routableAddress = paramString3;
    source = paramString4;
    navigationMethod = paramString5;
    placeId = paramString6;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DeprecatedPlaceDTO {\n");
    localStringBuilder.append("  lat: ").append(lat).append("\n");
    localStringBuilder.append("  lng: ").append(lng).append("\n");
    localStringBuilder.append("  address: ").append(address).append("\n");
    localStringBuilder.append("  placeName: ").append(placeName).append("\n");
    localStringBuilder.append("  routableAddress: ").append(routableAddress).append("\n");
    localStringBuilder.append("  source: ").append(source).append("\n");
    localStringBuilder.append("  navigationMethod: ").append(navigationMethod).append("\n");
    localStringBuilder.append("  placeId: ").append(placeId).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DeprecatedPlaceDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */