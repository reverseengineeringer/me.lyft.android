package me.lyft.android.application.driver;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.DriverProfile;
import rx.Observable;

public abstract interface IDriverProfileService
{
  public abstract Observable<DriverProfile> getDriverProfile();
  
  public abstract Observable<Unit> updateDriverProfile(DriverProfile paramDriverProfile);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.IDriverProfileService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */