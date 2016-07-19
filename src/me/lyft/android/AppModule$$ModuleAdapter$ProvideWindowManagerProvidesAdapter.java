package me.lyft.android;

import android.view.WindowManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideWindowManagerProvidesAdapter
  extends ProvidesBinding<WindowManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideWindowManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.view.WindowManager", true, "me.lyft.android.AppModule", "provideWindowManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public WindowManager get()
  {
    return module.provideWindowManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideWindowManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */