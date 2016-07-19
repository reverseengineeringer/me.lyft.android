package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.RideVehicleDTO;

public class DriverVehicleMapper
{
  public static DriverVehicle fromRideVehicleDTO(RideVehicleDTO paramRideVehicleDTO)
  {
    if (paramRideVehicleDTO == null) {
      return DriverVehicle.empty();
    }
    return new DriverVehicle(make, model, color, licensePlate, photo, transparentPhoto);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.DriverVehicleMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */