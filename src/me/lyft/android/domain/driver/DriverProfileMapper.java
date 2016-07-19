package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.DriverProfileDTO;
import me.lyft.android.common.Objects;

public class DriverProfileMapper
{
  public static DriverProfile fromDriverProfileDto(DriverProfileDTO paramDriverProfileDTO)
  {
    if (paramDriverProfileDTO == null) {
      return DriverProfile.empty();
    }
    return new DriverProfile(((Boolean)Objects.firstNonNull(driver_shortcut_enabled, Boolean.valueOf(false))).booleanValue());
  }
  
  public static DriverProfileDTO toDriverProfileDto(DriverProfile paramDriverProfile)
  {
    return new DriverProfileDTO(Boolean.valueOf(paramDriverProfile.isDriverShortcutEnabled()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverProfileMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */