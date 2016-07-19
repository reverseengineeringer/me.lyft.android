package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.List;
import java.util.Set;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.ISimpleRepository;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRequestRideTypeServiceProvidesAdapter
  extends ProvidesBinding<IRequestRideTypeService>
{
  private Binding<IAppInfoService> appInfoService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<ISimpleRepository<List<RequestRideType>>> rideTypesRepository;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRequestRideTypeServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.requestridetypes.IRequestRideTypeService", true, "me.lyft.android.application.ApplicationServicesModule", "provideRequestRideTypeService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", ApplicationServicesModule.class, getClass().getClassLoader());
    rideTypesRepository = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepository<java.util.List<me.lyft.android.domain.passenger.ridetypes.RequestRideType>>", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IRequestRideTypeService get()
  {
    return module.provideRequestRideTypeService((ILyftApi)lyftApi.get(), (IAppInfoService)appInfoService.get(), (ISimpleRepository)rideTypesRepository.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(appInfoService);
    paramSet1.add(rideTypesRepository);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRequestRideTypeServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */