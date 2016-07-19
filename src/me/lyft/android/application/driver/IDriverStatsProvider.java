package me.lyft.android.application.driver;

import me.lyft.android.domain.driver.DriverAchievements;
import rx.Observable;

public abstract interface IDriverStatsProvider
{
  public abstract Observable<DriverAchievements> getDriverAchievements(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.IDriverStatsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */