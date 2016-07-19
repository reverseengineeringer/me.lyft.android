package me.lyft.android.navigation;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.settings.INavigationSettingsService;

@Module(complete=false, library=true)
public class NavigationModule
{
  @Provides
  @Singleton
  GoogleNavigation provideGoogleNavigation(LyftApplication paramLyftApplication)
  {
    return new GoogleNavigation(paramLyftApplication);
  }
  
  @Provides
  @Singleton
  NavigationSettings provideNavigationSettings(ILyftPreferences paramILyftPreferences, INavigationSettingsService paramINavigationSettingsService, Lazy<WazeNavigation> paramLazy)
  {
    return new NavigationSettings(paramILyftPreferences, paramINavigationSettingsService, paramLazy);
  }
  
  @Provides
  @Singleton
  Navigator provideNavigator(NavigationSettings paramNavigationSettings, Lazy<GoogleNavigation> paramLazy, Lazy<WazeNavigation> paramLazy1)
  {
    return new UserNavigation(paramNavigationSettings, paramLazy, paramLazy1);
  }
  
  @Provides
  @Singleton
  WazeIntentNavigation provideWazeIntentNavigation(LyftApplication paramLyftApplication)
  {
    return new WazeIntentNavigation(paramLyftApplication);
  }
  
  @Provides
  @Singleton
  WazeNavigation provideWazeNavigation(LyftApplication paramLyftApplication, IConstantsProvider paramIConstantsProvider, Lazy<WazeSDK> paramLazy, Lazy<WazeIntentNavigation> paramLazy1)
  {
    return new WazeNavigation(paramLyftApplication, paramIConstantsProvider, paramLazy, paramLazy1);
  }
  
  @Provides
  @Singleton
  WazeSDK provideWazeSDK(LyftApplication paramLyftApplication)
  {
    return new WazeSDK(paramLyftApplication);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.navigation.NavigationModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */