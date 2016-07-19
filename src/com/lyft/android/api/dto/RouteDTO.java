package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RouteDTO
{
  @SerializedName("currentStopRideId")
  public final String currentStopRideId;
  @SerializedName("driver")
  public final RideUserDTO driver;
  @SerializedName("isQueuedRoute")
  public final Boolean isQueuedRoute;
  @SerializedName("passengers")
  public final List<RideUserDTO> passengers;
  @SerializedName("stops")
  public final List<StopDTO> stops;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RouteDTO {\n");
    localStringBuilder.append("  stops: ").append(stops).append("\n");
    localStringBuilder.append("  passengers: ").append(passengers).append("\n");
    localStringBuilder.append("  driver: ").append(driver).append("\n");
    localStringBuilder.append("  currentStopRideId: ").append(currentStopRideId).append("\n");
    localStringBuilder.append("  isQueuedRoute: ").append(isQueuedRoute).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RouteDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */