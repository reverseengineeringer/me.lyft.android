package me.lyft.android.development;

import android.app.Activity;
import me.lyft.android.infrastructure.viewserver.IViewServer;

public class ViewServerSupport
{
  private static IViewServer instance;
  
  private static IViewServer createViewServer()
  {
    try
    {
      IViewServer localIViewServer = (IViewServer)getViewServerProxyClass().newInstance();
      return localIViewServer;
    }
    catch (Throwable localThrowable) {}
    return new NoOpViewServer();
  }
  
  public static IViewServer getViewServer()
  {
    if (instance == null) {
      instance = createViewServer();
    }
    return instance;
  }
  
  private static Class<? extends IViewServer> getViewServerProxyClass()
    throws ClassNotFoundException
  {
    return Class.forName("me.lyft.android.development.proxies.ViewServerProxy");
  }
  
  static class NoOpViewServer
    implements IViewServer
  {
    public void addWindow(Activity paramActivity) {}
    
    public void removeWindow(Activity paramActivity) {}
    
    public void setFocusedWindow(Activity paramActivity) {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.development.ViewServerSupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */