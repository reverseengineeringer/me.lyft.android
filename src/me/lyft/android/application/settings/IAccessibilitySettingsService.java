package me.lyft.android.application.settings;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IAccessibilitySettingsService
{
  public abstract Observable<Unit> setAccessibilityEnabled(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.IAccessibilitySettingsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */