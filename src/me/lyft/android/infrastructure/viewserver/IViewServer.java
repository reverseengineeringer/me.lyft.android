package me.lyft.android.infrastructure.viewserver;

import android.app.Activity;

public abstract interface IViewServer
{
  public abstract void addWindow(Activity paramActivity);
  
  public abstract void removeWindow(Activity paramActivity);
  
  public abstract void setFocusedWindow(Activity paramActivity);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.viewserver.IViewServer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */