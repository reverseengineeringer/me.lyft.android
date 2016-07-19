package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class LocationDTO
{
  @SerializedName("accuracy")
  public final Double accuracy;
  @SerializedName("bearing")
  public final Double bearing;
  @SerializedName("eta")
  public final Long eta;
  @SerializedName("isInternalEta")
  public final Boolean isInternalEta;
  @SerializedName("lat")
  public final Double lat;
  @SerializedName("lng")
  public final Double lng;
  @SerializedName("recordedAt")
  public final String recordedAt;
  @SerializedName("recorded_at")
  public final Long recorded_at;
  @SerializedName("rideId")
  public final String rideId;
  @SerializedName("rideStatus")
  public final String rideStatus;
  @SerializedName("source")
  public final String source;
  @SerializedName("speed")
  public final Double speed;
  
  public LocationDTO(Double paramDouble1, Double paramDouble2, Double paramDouble3, Double paramDouble4, Double paramDouble5, String paramString1, String paramString2, String paramString3, Long paramLong1, Boolean paramBoolean, Long paramLong2, String paramString4)
  {
    lat = paramDouble1;
    lng = paramDouble2;
    speed = paramDouble3;
    bearing = paramDouble4;
    accuracy = paramDouble5;
    recordedAt = paramString1;
    rideId = paramString2;
    rideStatus = paramString3;
    eta = paramLong1;
    isInternalEta = paramBoolean;
    recorded_at = paramLong2;
    source = paramString4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class LocationDTO {\n");
    localStringBuilder.append("  lat: ").append(lat).append("\n");
    localStringBuilder.append("  lng: ").append(lng).append("\n");
    localStringBuilder.append("  speed: ").append(speed).append("\n");
    localStringBuilder.append("  bearing: ").append(bearing).append("\n");
    localStringBuilder.append("  accuracy: ").append(accuracy).append("\n");
    localStringBuilder.append("  recordedAt: ").append(recordedAt).append("\n");
    localStringBuilder.append("  rideId: ").append(rideId).append("\n");
    localStringBuilder.append("  rideStatus: ").append(rideStatus).append("\n");
    localStringBuilder.append("  eta: ").append(eta).append("\n");
    localStringBuilder.append("  isInternalEta: ").append(isInternalEta).append("\n");
    localStringBuilder.append("  recorded_at: ").append(recorded_at).append("\n");
    localStringBuilder.append("  source: ").append(source).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.LocationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */