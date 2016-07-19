package me.lyft.android;

import android.app.AlarmManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideAlarmManagerProvidesAdapter
  extends ProvidesBinding<AlarmManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideAlarmManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.app.AlarmManager", true, "me.lyft.android.AppModule", "provideAlarmManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public AlarmManager get()
  {
    return module.provideAlarmManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideAlarmManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */