package me.lyft.android.application.driver;

import com.lyft.android.api.dto.DriverProfileDTO;
import me.lyft.android.domain.driver.DriverProfile;
import me.lyft.android.domain.driver.DriverProfileMapper;
import me.lyft.android.persistence.ISimpleRepository;
import rx.functions.Func1;

class DriverProfileService$1
  implements Func1<DriverProfileDTO, DriverProfile>
{
  DriverProfileService$1(DriverProfileService paramDriverProfileService) {}
  
  public DriverProfile call(DriverProfileDTO paramDriverProfileDTO)
  {
    paramDriverProfileDTO = DriverProfileMapper.fromDriverProfileDto(paramDriverProfileDTO);
    DriverProfileService.access$000(this$0).update(paramDriverProfileDTO);
    return paramDriverProfileDTO;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.DriverProfileService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */