package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.autofill.AutoFillAnalytics;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvidePrefillAnalyticsServiceProvidesAdapter
  extends ProvidesBinding<AutoFillAnalytics>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvidePrefillAnalyticsServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.application.autofill.AutoFillAnalytics", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "providePrefillAnalyticsService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public AutoFillAnalytics get()
  {
    return module.providePrefillAnalyticsService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvidePrefillAnalyticsServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */