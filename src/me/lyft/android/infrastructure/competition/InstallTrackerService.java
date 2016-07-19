package me.lyft.android.infrastructure.competition;

import android.app.Activity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.lyft.android.analytics.studies.AppAnalytics;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.logging.L;

public class InstallTrackerService
  extends ActivityService
{
  private IConstantsProvider constantsProvider;
  private IDevice device;
  private boolean eventsTracked;
  
  public InstallTrackerService(IConstantsProvider paramIConstantsProvider, IDevice paramIDevice)
  {
    constantsProvider = paramIConstantsProvider;
    device = paramIDevice;
    eventsTracked = false;
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    if (eventsTracked) {}
    for (;;)
    {
      return;
      try
      {
        paramActivity = constantsProvider.getCheckBundleIds();
        if (!paramActivity.isEmpty())
        {
          Object localObject = new HashSet();
          ((Set)localObject).addAll(paramActivity.keySet());
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str1 = (String)((Iterator)localObject).next();
            String str2 = (String)paramActivity.get(str1);
            if (!Strings.isNullOrEmpty(str2)) {
              AppAnalytics.trackCompetitiveAppInstalled(str1, str2, device.isPackageInstalled(str2));
            }
          }
          eventsTracked = true;
        }
      }
      catch (Throwable paramActivity)
      {
        L.e(paramActivity, "failed to track install", new Object[0]);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.competition.InstallTrackerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */