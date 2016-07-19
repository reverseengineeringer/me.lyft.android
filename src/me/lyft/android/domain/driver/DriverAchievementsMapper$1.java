package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.DriverActivityDTO;
import rx.functions.Func1;

final class DriverAchievementsMapper$1
  implements Func1<DriverActivityDTO, DriverActivities>
{
  public DriverActivities call(DriverActivityDTO paramDriverActivityDTO)
  {
    return DriverAchievementsMapper.fromDriverActivityDTO(paramDriverActivityDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverAchievementsMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */