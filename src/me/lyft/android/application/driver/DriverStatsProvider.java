package me.lyft.android.application.driver;

import com.lyft.android.api.dto.DriverStatsDTO;
import me.lyft.android.domain.driver.DriverAchievements;
import me.lyft.android.domain.driver.DriverAchievementsMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class DriverStatsProvider
  implements IDriverStatsProvider
{
  private ILyftApi lyftApi;
  
  public DriverStatsProvider(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Observable<DriverAchievements> getDriverAchievements(String paramString)
  {
    lyftApi.getDriverStats(paramString).map(new Func1()
    {
      public DriverAchievements call(DriverStatsDTO paramAnonymousDriverStatsDTO)
      {
        return DriverAchievementsMapper.fromDto(paramAnonymousDriverStatsDTO);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.DriverStatsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */