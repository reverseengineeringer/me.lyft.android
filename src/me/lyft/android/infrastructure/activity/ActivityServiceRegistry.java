package me.lyft.android.infrastructure.activity;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import me.lyft.android.utils.ActivityResult;
import me.lyft.android.utils.IActivityService;

public class ActivityServiceRegistry
  implements IActivityService
{
  private Activity currentActivity;
  private Activity nextActivity;
  private Bundle nextActivityState;
  private ArrayList<IActivityService> services = new ArrayList();
  
  public ActivityServiceRegistry(Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      add(paramVarArgs[i]);
      i += 1;
    }
  }
  
  private void add(Object paramObject)
  {
    if ((paramObject instanceof IActivityService))
    {
      paramObject = (IActivityService)paramObject;
      services.add(paramObject);
      return;
    }
    throw new IllegalArgumentException(String.format("Service %s should implement IActivityService interface", new Object[] { paramObject.getClass().getSimpleName() }));
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (currentActivity != null) {
      nextActivity = paramActivity;
    }
    for (nextActivityState = paramBundle; nextActivity == null; nextActivityState = null)
    {
      Iterator localIterator = services.iterator();
      while (localIterator.hasNext()) {
        ((IActivityService)localIterator.next()).onActivityCreated(paramActivity, paramBundle);
      }
      currentActivity = paramActivity;
      nextActivity = null;
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = services.iterator();
    while (localIterator.hasNext()) {
      ((IActivityService)localIterator.next()).onActivityDestroyed(paramActivity);
    }
    currentActivity = null;
    if (nextActivity != null)
    {
      paramActivity = nextActivity;
      nextActivity = null;
      onActivityCreated(paramActivity, nextActivityState);
      onActivityStarted(paramActivity);
      onActivityResumed(paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = services.iterator();
    while (localIterator.hasNext()) {
      ((IActivityService)localIterator.next()).onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResult(Activity paramActivity, ActivityResult paramActivityResult)
  {
    Iterator localIterator = services.iterator();
    while (localIterator.hasNext()) {
      ((IActivityService)localIterator.next()).onActivityResult(paramActivity, paramActivityResult);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (nextActivity == null)
    {
      Iterator localIterator = services.iterator();
      while (localIterator.hasNext()) {
        ((IActivityService)localIterator.next()).onActivityResumed(paramActivity);
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = services.iterator();
    while (localIterator.hasNext()) {
      ((IActivityService)localIterator.next()).onActivitySaveInstanceState(paramActivity, paramBundle);
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (nextActivity == null)
    {
      Iterator localIterator = services.iterator();
      while (localIterator.hasNext()) {
        ((IActivityService)localIterator.next()).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = services.iterator();
    while (localIterator.hasNext()) {
      ((IActivityService)localIterator.next()).onActivityStopped(paramActivity);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.activity.ActivityServiceRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */