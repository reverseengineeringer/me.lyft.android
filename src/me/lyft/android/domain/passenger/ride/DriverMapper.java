package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.LocationDTO;
import com.lyft.android.api.dto.PhoneDTO;
import com.lyft.android.api.dto.RideUserDTO;
import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.location.NullLocation;
import rx.functions.Func1;

public class DriverMapper
{
  public static Driver createDriver(RideUserDTO paramRideUserDTO, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramRideUserDTO == null) {
      return Driver.empty();
    }
    Location localLocation;
    List localList;
    String str1;
    label52:
    String str2;
    String str3;
    String str4;
    DriverVehicle localDriverVehicle;
    if (paramBoolean)
    {
      localLocation = NullLocation.getInstance();
      localList = Iterables.map((Iterable)Objects.firstNonNull(recentLocations, Collections.emptyList()), new Func1()
      {
        public Location call(LocationDTO paramAnonymousLocationDTO)
        {
          return LocationMapper.fromLocationDTO(paramAnonymousLocationDTO);
        }
      });
      if (phone != null) {
        break label129;
      }
      str1 = null;
      str2 = id;
      str3 = firstName;
      str4 = userPhoto;
      localDriverVehicle = DriverVehicleMapper.fromRideVehicleDTO(vehicle);
      if (!localList.isEmpty()) {
        break label141;
      }
    }
    for (;;)
    {
      return new Driver(str2, str3, str4, str1, localDriverVehicle, localLocation, driverRating, localList, paramString1, paramString2);
      localLocation = LocationMapper.fromLocationDTO(location);
      break;
      label129:
      str1 = phone.number;
      break label52;
      label141:
      localLocation = (Location)localList.get(localList.size() - 1);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.DriverMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */