package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.ride.GooglePlaceTypeAnalytics;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideGooglePlaceTypeAnalyticsProvidesAdapter
  extends ProvidesBinding<GooglePlaceTypeAnalytics>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideGooglePlaceTypeAnalyticsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.GooglePlaceTypeAnalytics", true, "me.lyft.android.application.ApplicationServicesModule", "provideGooglePlaceTypeAnalytics");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public GooglePlaceTypeAnalytics get()
  {
    return module.provideGooglePlaceTypeAnalytics();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideGooglePlaceTypeAnalyticsProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */