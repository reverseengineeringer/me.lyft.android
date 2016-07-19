package me.lyft.android;

import android.os.Handler;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideHandlerProvidesAdapter
  extends ProvidesBinding<Handler>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideHandlerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.os.Handler", true, "me.lyft.android.AppModule", "provideHandler");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public Handler get()
  {
    return module.provideHandler();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideHandlerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */