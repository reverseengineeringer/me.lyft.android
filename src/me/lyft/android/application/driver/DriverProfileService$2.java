package me.lyft.android.application.driver;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.DriverProfile;
import me.lyft.android.persistence.ISimpleRepository;
import rx.functions.Func1;

class DriverProfileService$2
  implements Func1<Unit, Unit>
{
  DriverProfileService$2(DriverProfileService paramDriverProfileService, DriverProfile paramDriverProfile) {}
  
  public Unit call(Unit paramUnit)
  {
    DriverProfileService.access$000(this$0).update(val$driverProfile);
    return paramUnit;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.DriverProfileService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */