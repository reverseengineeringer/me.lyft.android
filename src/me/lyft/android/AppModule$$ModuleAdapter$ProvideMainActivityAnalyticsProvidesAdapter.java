package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.ui.MainActivityAnalytics;

public final class AppModule$$ModuleAdapter$ProvideMainActivityAnalyticsProvidesAdapter
  extends ProvidesBinding<MainActivityAnalytics>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideMainActivityAnalyticsProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.ui.MainActivityAnalytics", true, "me.lyft.android.AppModule", "provideMainActivityAnalytics");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public MainActivityAnalytics get()
  {
    return module.provideMainActivityAnalytics();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideMainActivityAnalyticsProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */