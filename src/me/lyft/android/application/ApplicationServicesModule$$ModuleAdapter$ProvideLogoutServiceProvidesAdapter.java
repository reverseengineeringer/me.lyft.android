package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.IUserSession;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.cleanup.ICleanupRegistry;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.infrastructure.facebook.IFacebookTokenService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideLogoutServiceProvidesAdapter
  extends ProvidesBinding<ILogoutService>
{
  private Binding<ICleanupRegistry> cleanupRegistry;
  private Binding<IFacebookTokenService> facebookService;
  private Binding<ILyftApi> lyftApi;
  private Binding<LyftApplication> lyftApplication;
  private final ApplicationServicesModule module;
  private Binding<ILyftPreferences> preferences;
  private Binding<IRideRequestSession> rideRequestSession;
  private Binding<IUserProvider> userProvider;
  private Binding<IUserSession> userSession;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideLogoutServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ILogoutService", true, "me.lyft.android.application.ApplicationServicesModule", "provideLogoutService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", ApplicationServicesModule.class, getClass().getClassLoader());
    userSession = paramLinker.requestBinding("me.lyft.android.IUserSession", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
    facebookService = paramLinker.requestBinding("me.lyft.android.infrastructure.facebook.IFacebookTokenService", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    cleanupRegistry = paramLinker.requestBinding("me.lyft.android.application.cleanup.ICleanupRegistry", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ILogoutService get()
  {
    return module.provideLogoutService((LyftApplication)lyftApplication.get(), (IUserSession)userSession.get(), (IRideRequestSession)rideRequestSession.get(), (ILyftApi)lyftApi.get(), (ILyftPreferences)preferences.get(), (IFacebookTokenService)facebookService.get(), (IUserProvider)userProvider.get(), (ICleanupRegistry)cleanupRegistry.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
    paramSet1.add(userSession);
    paramSet1.add(rideRequestSession);
    paramSet1.add(lyftApi);
    paramSet1.add(preferences);
    paramSet1.add(facebookService);
    paramSet1.add(userProvider);
    paramSet1.add(cleanupRegistry);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideLogoutServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */