package me.lyft.android.infrastructure.locationsettings;

import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class LocationSettingsService$3
  implements Func1<Boolean, Observable<Unit>>
{
  LocationSettingsService$3(LocationSettingsService paramLocationSettingsService) {}
  
  public Observable<Unit> call(Boolean paramBoolean)
  {
    return LocationSettingsService.access$200(this$0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.locationsettings.LocationSettingsService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */