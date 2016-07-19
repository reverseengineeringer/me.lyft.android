package me.lyft.android.application.ats;

import com.lyft.android.api.dto.DriverApplicationDTO;
import me.lyft.android.domain.ats.DriverApplication;
import me.lyft.android.domain.ats.DriverApplicationMapper;
import rx.functions.Func1;

class AtsService$2
  implements Func1<DriverApplicationDTO, DriverApplication>
{
  AtsService$2(AtsService paramAtsService) {}
  
  public DriverApplication call(DriverApplicationDTO paramDriverApplicationDTO)
  {
    return DriverApplicationMapper.fromDriverApplicationDto(paramDriverApplicationDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ats.AtsService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */