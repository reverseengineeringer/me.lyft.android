package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.analytics.studies.SplitFareAnalytics;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideSplitFareAnalyticsProvidesAdapter
  extends ProvidesBinding<SplitFareAnalytics>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideSplitFareAnalyticsProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.analytics.studies.SplitFareAnalytics", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideSplitFareAnalytics");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public SplitFareAnalytics get()
  {
    return module.provideSplitFareAnalytics();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideSplitFareAnalyticsProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */