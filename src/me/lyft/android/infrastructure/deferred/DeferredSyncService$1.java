package me.lyft.android.infrastructure.deferred;

import android.app.Activity;
import me.lyft.android.services.DeferredCallSyncService;

class DeferredSyncService$1
  implements Runnable
{
  DeferredSyncService$1(DeferredSyncService paramDeferredSyncService) {}
  
  public void run()
  {
    Activity localActivity = DeferredSyncService.access$000(this$0);
    if (localActivity != null) {
      DeferredCallSyncService.scheduleUsing(localActivity);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.DeferredSyncService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */