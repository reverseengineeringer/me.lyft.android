package me.lyft.android.infrastructure.deferred;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.services.DeferredCallSyncService;

public class DeferredSyncService
  extends ActivityService
  implements IDeferredSyncService
{
  private final Handler mainThreadHandler;
  private final Runnable scheduleSyncRunnable = new Runnable()
  {
    public void run()
    {
      Activity localActivity = getCurrentActivity();
      if (localActivity != null) {
        DeferredCallSyncService.scheduleUsing(localActivity);
      }
    }
  };
  
  public DeferredSyncService(Handler paramHandler)
  {
    mainThreadHandler = paramHandler;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    scheduleSync();
  }
  
  public void scheduleSync()
  {
    mainThreadHandler.removeCallbacks(scheduleSyncRunnable);
    mainThreadHandler.post(scheduleSyncRunnable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.DeferredSyncService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */