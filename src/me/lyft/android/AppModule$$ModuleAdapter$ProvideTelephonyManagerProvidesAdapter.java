package me.lyft.android;

import android.telephony.TelephonyManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideTelephonyManagerProvidesAdapter
  extends ProvidesBinding<TelephonyManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideTelephonyManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.telephony.TelephonyManager", true, "me.lyft.android.AppModule", "provideTelephonyManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public TelephonyManager get()
  {
    return module.provideTelephonyManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideTelephonyManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */