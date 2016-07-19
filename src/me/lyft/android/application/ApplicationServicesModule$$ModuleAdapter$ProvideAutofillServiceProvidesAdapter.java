package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.autofill.AutoFillService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideAutofillServiceProvidesAdapter
  extends ProvidesBinding<AutoFillService>
{
  private Binding<IAppInfoService> appInfoService;
  private Binding<ILocationService> locationService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IRideRequestSession> rideRequestSession;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideAutofillServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.autofill.AutoFillService", true, "me.lyft.android.application.ApplicationServicesModule", "provideAutofillService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public AutoFillService get()
  {
    return module.provideAutofillService((ILocationService)locationService.get(), (ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (IRideRequestSession)rideRequestSession.get(), (IAppInfoService)appInfoService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(locationService);
    paramSet1.add(lyftApi);
    paramSet1.add(userProvider);
    paramSet1.add(rideRequestSession);
    paramSet1.add(appInfoService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideAutofillServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */