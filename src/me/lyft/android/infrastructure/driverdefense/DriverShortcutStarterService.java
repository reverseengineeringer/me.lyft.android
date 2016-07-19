package me.lyft.android.infrastructure.driverdefense;

import android.app.Activity;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.services.DriverShortcutService;
import me.lyft.android.services.LyftDriverToggleService;

public class DriverShortcutStarterService
  extends ActivityService
{
  private IFeaturesProvider featuresProvider;
  private ILyftPreferences lyftPreferences;
  private IUserProvider userProvider;
  
  public DriverShortcutStarterService(IUserProvider paramIUserProvider, ILyftPreferences paramILyftPreferences, IFeaturesProvider paramIFeaturesProvider)
  {
    userProvider = paramIUserProvider;
    lyftPreferences = paramILyftPreferences;
    featuresProvider = paramIFeaturesProvider;
  }
  
  private boolean shouldShowDriverDefense()
  {
    return (userProvider.getUser().isApprovedDriver()) && (lyftPreferences.isDriverShortcutEnabled());
  }
  
  private void startDriverShortcutService(Activity paramActivity)
  {
    if (featuresProvider.isEnabled(Features.DRIVER_SHORTCUT_V2))
    {
      DriverShortcutService.startService(paramActivity);
      return;
    }
    LyftDriverToggleService.startService(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (shouldShowDriverDefense()) {
      startDriverShortcutService(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (featuresProvider.isEnabled(Features.DRIVER_SHORTCUT_V2))
    {
      DriverShortcutService.stopService(paramActivity);
      return;
    }
    LyftDriverToggleService.stopService(paramActivity);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */