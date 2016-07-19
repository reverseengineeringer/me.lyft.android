package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ActivityLifecycleManager$ActivityLifecycleCallbacksWrapper
{
  private final Application application;
  private final Set<Application.ActivityLifecycleCallbacks> registeredCallbacks = new HashSet();
  
  ActivityLifecycleManager$ActivityLifecycleCallbacksWrapper(Application paramApplication)
  {
    application = paramApplication;
  }
  
  @TargetApi(14)
  private void clearCallbacks()
  {
    Iterator localIterator = registeredCallbacks.iterator();
    while (localIterator.hasNext())
    {
      Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)localIterator.next();
      application.unregisterActivityLifecycleCallbacks(localActivityLifecycleCallbacks);
    }
  }
  
  @TargetApi(14)
  private boolean registerLifecycleCallbacks(final ActivityLifecycleManager.Callbacks paramCallbacks)
  {
    if (application != null)
    {
      paramCallbacks = new Application.ActivityLifecycleCallbacks()
      {
        public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          paramCallbacks.onActivityCreated(paramAnonymousActivity, paramAnonymousBundle);
        }
        
        public void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          paramCallbacks.onActivityDestroyed(paramAnonymousActivity);
        }
        
        public void onActivityPaused(Activity paramAnonymousActivity)
        {
          paramCallbacks.onActivityPaused(paramAnonymousActivity);
        }
        
        public void onActivityResumed(Activity paramAnonymousActivity)
        {
          paramCallbacks.onActivityResumed(paramAnonymousActivity);
        }
        
        public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          paramCallbacks.onActivitySaveInstanceState(paramAnonymousActivity, paramAnonymousBundle);
        }
        
        public void onActivityStarted(Activity paramAnonymousActivity)
        {
          paramCallbacks.onActivityStarted(paramAnonymousActivity);
        }
        
        public void onActivityStopped(Activity paramAnonymousActivity)
        {
          paramCallbacks.onActivityStopped(paramAnonymousActivity);
        }
      };
      application.registerActivityLifecycleCallbacks(paramCallbacks);
      registeredCallbacks.add(paramCallbacks);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */