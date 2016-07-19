package me.lyft.android.navigation;

import dagger.Lazy;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.settings.INavigationSettingsService;
import me.lyft.android.common.Unit;
import me.lyft.android.rx.AsyncCall;
import rx.Observable;

public class NavigationSettings
{
  public static final int GOOGLE_NAVIGATION = 0;
  public static final int WAZE_NAVIGATION = 1;
  private ILyftPreferences lyftPreferences;
  private INavigationSettingsService navigationSettingsService;
  private final Lazy<WazeNavigation> wazeNavigation;
  
  public NavigationSettings(ILyftPreferences paramILyftPreferences, INavigationSettingsService paramINavigationSettingsService, Lazy<WazeNavigation> paramLazy)
  {
    lyftPreferences = paramILyftPreferences;
    navigationSettingsService = paramINavigationSettingsService;
    wazeNavigation = paramLazy;
  }
  
  public void changeDefaultNavigation(int paramInt)
  {
    if (paramInt == 1) {}
    for (String str = "waze";; str = "gmaps")
    {
      final int i = lyftPreferences.getSelectedNavigation(0);
      lyftPreferences.setSelectedNavigation(paramInt);
      navigationSettingsService.setDefaultNavigation(str).subscribe(new AsyncCall()
      {
        public void onFail(Throwable paramAnonymousThrowable)
        {
          lyftPreferences.setSelectedNavigation(i);
        }
      });
      return;
    }
  }
  
  public int getDefaultNavigation()
  {
    return lyftPreferences.getSelectedNavigation(0);
  }
  
  public boolean hasMultipleNavigationApps()
  {
    return ((WazeNavigation)wazeNavigation.get()).isInstalled();
  }
  
  public boolean isDefaultNavigationSet()
  {
    return lyftPreferences.isNavigationAppSelected();
  }
  
  public void setDefaultNavigation()
  {
    if (((WazeNavigation)wazeNavigation.get()).isInstalled())
    {
      changeDefaultNavigation(1);
      return;
    }
    changeDefaultNavigation(0);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NavigationType {}
}

/* Location:
 * Qualified Name:     me.lyft.android.navigation.NavigationSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */