package me.lyft.android.application.ats;

import com.lyft.android.api.dto.DriverApplicationDTO;
import me.lyft.android.domain.ats.DriverApplication;
import me.lyft.android.domain.ats.DriverApplicationMapper;
import rx.functions.Func1;

class AtsService$3
  implements Func1<DriverApplicationDTO, DriverApplication>
{
  AtsService$3(AtsService paramAtsService) {}
  
  public DriverApplication call(DriverApplicationDTO paramDriverApplicationDTO)
  {
    return DriverApplicationMapper.fromDriverApplicationDto(paramDriverApplicationDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ats.AtsService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */