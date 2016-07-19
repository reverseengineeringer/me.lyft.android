package me.lyft.android.application.settings;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface INavigationSettingsService
{
  public static final String GOOGLE = "gmaps";
  public static final String WAZE = "waze";
  
  public abstract Observable<Unit> setDefaultNavigation(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.INavigationSettingsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */