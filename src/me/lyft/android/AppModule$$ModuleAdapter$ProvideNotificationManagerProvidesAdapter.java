package me.lyft.android;

import android.app.NotificationManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideNotificationManagerProvidesAdapter
  extends ProvidesBinding<NotificationManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideNotificationManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.app.NotificationManager", true, "me.lyft.android.AppModule", "provideNotificationManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public NotificationManager get()
  {
    return module.provideNotificationManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideNotificationManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */