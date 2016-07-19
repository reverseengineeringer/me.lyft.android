package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PlaceDTO
{
  @SerializedName("address")
  public final String address;
  @SerializedName("lat")
  public final Double lat;
  @SerializedName("lng")
  public final Double lng;
  @SerializedName("location_input_source")
  public final String location_input_source;
  @SerializedName("place_id")
  public final String place_id;
  @SerializedName("place_name")
  public final String place_name;
  @SerializedName("place_provider")
  public final String place_provider;
  @SerializedName("routable_address")
  public final String routable_address;
  
  public PlaceDTO(Double paramDouble1, Double paramDouble2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    lat = paramDouble1;
    lng = paramDouble2;
    address = paramString1;
    place_name = paramString2;
    routable_address = paramString3;
    location_input_source = paramString4;
    place_id = paramString5;
    place_provider = paramString6;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PlaceDTO {\n");
    localStringBuilder.append("  lat: ").append(lat).append("\n");
    localStringBuilder.append("  lng: ").append(lng).append("\n");
    localStringBuilder.append("  address: ").append(address).append("\n");
    localStringBuilder.append("  place_name: ").append(place_name).append("\n");
    localStringBuilder.append("  routable_address: ").append(routable_address).append("\n");
    localStringBuilder.append("  location_input_source: ").append(location_input_source).append("\n");
    localStringBuilder.append("  place_id: ").append(place_id).append("\n");
    localStringBuilder.append("  place_provider: ").append(place_provider).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PlaceDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */