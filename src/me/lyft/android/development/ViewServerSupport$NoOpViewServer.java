package me.lyft.android.development;

import android.app.Activity;
import me.lyft.android.infrastructure.viewserver.IViewServer;

class ViewServerSupport$NoOpViewServer
  implements IViewServer
{
  public void addWindow(Activity paramActivity) {}
  
  public void removeWindow(Activity paramActivity) {}
  
  public void setFocusedWindow(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.development.ViewServerSupport.NoOpViewServer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */