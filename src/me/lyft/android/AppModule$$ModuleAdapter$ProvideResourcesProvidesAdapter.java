package me.lyft.android;

import android.content.res.Resources;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideResourcesProvidesAdapter
  extends ProvidesBinding<Resources>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideResourcesProvidesAdapter(AppModule paramAppModule)
  {
    super("android.content.res.Resources", false, "me.lyft.android.AppModule", "provideResources");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public Resources get()
  {
    return module.provideResources();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideResourcesProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */