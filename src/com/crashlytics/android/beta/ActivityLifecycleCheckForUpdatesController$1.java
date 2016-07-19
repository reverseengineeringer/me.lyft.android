package com.crashlytics.android.beta;

import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import java.util.concurrent.ExecutorService;

class ActivityLifecycleCheckForUpdatesController$1
  extends ActivityLifecycleManager.Callbacks
{
  ActivityLifecycleCheckForUpdatesController$1(ActivityLifecycleCheckForUpdatesController paramActivityLifecycleCheckForUpdatesController) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (this$0.signalExternallyReady()) {
      ActivityLifecycleCheckForUpdatesController.access$000(this$0).submit(new Runnable()
      {
        public void run()
        {
          this$0.checkForUpdates();
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */