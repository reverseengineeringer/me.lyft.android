package me.lyft.android;

import android.content.pm.PackageManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvidePackageManagerProvidesAdapter
  extends ProvidesBinding<PackageManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvidePackageManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.content.pm.PackageManager", true, "me.lyft.android.AppModule", "providePackageManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public PackageManager get()
  {
    return module.providePackageManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvidePackageManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */