package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.profile.IRideProfileService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRideProfileServiceProvidesAdapter
  extends ProvidesBinding<IRideProfileService>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRideProfileServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.profile.IRideProfileService", true, "me.lyft.android.application.ApplicationServicesModule", "provideRideProfileService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IRideProfileService get()
  {
    return module.provideRideProfileService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRideProfileServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */