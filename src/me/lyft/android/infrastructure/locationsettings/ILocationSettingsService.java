package me.lyft.android.infrastructure.locationsettings;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface ILocationSettingsService
{
  public abstract boolean mockLocationEnabled();
  
  public abstract Observable<Unit> observeLocationSettingsEnabled();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.locationsettings.ILocationSettingsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */