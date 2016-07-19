package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.business.BusinessOnboardingAnalytics;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideBusinessOnboardAnalyticsProvidesAdapter
  extends ProvidesBinding<BusinessOnboardingAnalytics>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideBusinessOnboardAnalyticsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.business.BusinessOnboardingAnalytics", true, "me.lyft.android.application.ApplicationServicesModule", "provideBusinessOnboardAnalytics");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public BusinessOnboardingAnalytics get()
  {
    return module.provideBusinessOnboardAnalytics();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideBusinessOnboardAnalyticsProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */