package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.analytics.EditPickupAnalytics;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideEditPickupAnalyticsProvidesAdapter
  extends ProvidesBinding<EditPickupAnalytics>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideEditPickupAnalyticsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.analytics.EditPickupAnalytics", true, "me.lyft.android.application.ApplicationServicesModule", "provideEditPickupAnalytics");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public EditPickupAnalytics get()
  {
    return module.provideEditPickupAnalytics();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideEditPickupAnalyticsProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */