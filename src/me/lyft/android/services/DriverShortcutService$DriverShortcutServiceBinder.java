package me.lyft.android.services;

import android.os.Binder;
import java.lang.ref.WeakReference;

public class DriverShortcutService$DriverShortcutServiceBinder
  extends Binder
{
  private final WeakReference<DriverShortcutService> service;
  
  DriverShortcutService$DriverShortcutServiceBinder(DriverShortcutService paramDriverShortcutService)
  {
    service = new WeakReference(paramDriverShortcutService);
  }
  
  public DriverShortcutService getService()
  {
    return (DriverShortcutService)service.get();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.DriverShortcutService.DriverShortcutServiceBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */