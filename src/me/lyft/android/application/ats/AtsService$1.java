package me.lyft.android.application.ats;

import com.lyft.android.api.dto.DriverApplicationDataDTO;
import me.lyft.android.domain.ats.DriverApplicationData;
import me.lyft.android.domain.ats.DriverApplicationDataMapper;
import rx.functions.Func1;

class AtsService$1
  implements Func1<DriverApplicationDataDTO, DriverApplicationData>
{
  AtsService$1(AtsService paramAtsService) {}
  
  public DriverApplicationData call(DriverApplicationDataDTO paramDriverApplicationDataDTO)
  {
    return DriverApplicationDataMapper.fromDriverApplicationDataDto(paramDriverApplicationDataDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ats.AtsService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */