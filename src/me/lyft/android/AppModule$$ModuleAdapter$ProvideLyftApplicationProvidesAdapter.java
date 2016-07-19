package me.lyft.android;

import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideLyftApplicationProvidesAdapter
  extends ProvidesBinding<LyftApplication>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideLyftApplicationProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.LyftApplication", false, "me.lyft.android.AppModule", "provideLyftApplication");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public LyftApplication get()
  {
    return module.provideLyftApplication();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideLyftApplicationProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */