package me.lyft.android.application.driver;

import com.lyft.android.api.dto.DriverStatsDTO;
import me.lyft.android.domain.driver.DriverAchievements;
import me.lyft.android.domain.driver.DriverAchievementsMapper;
import rx.functions.Func1;

class DriverStatsProvider$1
  implements Func1<DriverStatsDTO, DriverAchievements>
{
  DriverStatsProvider$1(DriverStatsProvider paramDriverStatsProvider) {}
  
  public DriverAchievements call(DriverStatsDTO paramDriverStatsDTO)
  {
    return DriverAchievementsMapper.fromDto(paramDriverStatsDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.DriverStatsProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */