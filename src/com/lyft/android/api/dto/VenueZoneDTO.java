package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class VenueZoneDTO
{
  @SerializedName("confirmDetail")
  public final String confirmDetail;
  @SerializedName("confirmMessage")
  public final String confirmMessage;
  @SerializedName("name")
  public final String name;
  @SerializedName("pickupDetail")
  public final String pickupDetail;
  @SerializedName("pickupInfo")
  public final String pickupInfo;
  @SerializedName("pickupLocations")
  public final List<VenuePickupLocationDTO> pickupLocations;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class VenueZoneDTO {\n");
    localStringBuilder.append("  name: ").append(name).append("\n");
    localStringBuilder.append("  pickupInfo: ").append(pickupInfo).append("\n");
    localStringBuilder.append("  pickupDetail: ").append(pickupDetail).append("\n");
    localStringBuilder.append("  pickupLocations: ").append(pickupLocations).append("\n");
    localStringBuilder.append("  confirmMessage: ").append(confirmMessage).append("\n");
    localStringBuilder.append("  confirmDetail: ").append(confirmDetail).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.VenueZoneDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */