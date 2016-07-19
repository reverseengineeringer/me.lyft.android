package me.lyft.android.infrastructure.viewserver;

import android.app.Activity;
import android.os.Bundle;
import me.lyft.android.development.ViewServerSupport;
import me.lyft.android.infrastructure.activity.ActivityService;

public class ViewServerService
  extends ActivityService
  implements IViewServerService
{
  private final IViewServer viewServer = ViewServerSupport.getViewServer();
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    viewServer.addWindow(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    viewServer.removeWindow(paramActivity);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    viewServer.setFocusedWindow(paramActivity);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.viewserver.ViewServerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */