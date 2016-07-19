package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.geo.GoogleGeoAnalytics;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideGoogleGeoAnalyticsProvidesAdapter
  extends ProvidesBinding<GoogleGeoAnalytics>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideGoogleGeoAnalyticsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.geo.GoogleGeoAnalytics", true, "me.lyft.android.application.ApplicationServicesModule", "provideGoogleGeoAnalytics");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public GoogleGeoAnalytics get()
  {
    return module.provideGoogleGeoAnalytics();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideGoogleGeoAnalyticsProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */