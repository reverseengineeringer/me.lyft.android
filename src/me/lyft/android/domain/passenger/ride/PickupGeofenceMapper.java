package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.CircleCenterDTO;
import com.lyft.android.api.dto.PickupGeofenceDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.location.SimpleLatLng;

public class PickupGeofenceMapper
{
  public static PickupGeofence from(PickupGeofenceDTO paramPickupGeofenceDTO, String paramString)
  {
    if (paramPickupGeofenceDTO == null) {
      return PickupGeofence.empty();
    }
    return new PickupGeofence(paramString, ((Integer)Objects.firstNonNull(radius, Integer.valueOf(0))).intValue(), mapCenter(center));
  }
  
  private static LatLng mapCenter(CircleCenterDTO paramCircleCenterDTO)
  {
    if ((paramCircleCenterDTO == null) || (lat == null) || (lng == null)) {
      return NullLocation.getInstance();
    }
    return new SimpleLatLng(lat.doubleValue(), lng.doubleValue());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PickupGeofenceMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */