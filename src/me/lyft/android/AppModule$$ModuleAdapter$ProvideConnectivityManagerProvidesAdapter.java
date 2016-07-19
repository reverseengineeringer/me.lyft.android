package me.lyft.android;

import android.net.ConnectivityManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideConnectivityManagerProvidesAdapter
  extends ProvidesBinding<ConnectivityManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideConnectivityManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.net.ConnectivityManager", true, "me.lyft.android.AppModule", "provideConnectivityManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public ConnectivityManager get()
  {
    return module.provideConnectivityManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideConnectivityManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */