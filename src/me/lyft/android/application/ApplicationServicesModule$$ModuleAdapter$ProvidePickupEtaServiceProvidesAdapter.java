package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.eta.IPickupEtaFallbackService;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePickupEtaServiceProvidesAdapter
  extends ProvidesBinding<IPickupEtaService>
{
  private Binding<IEtaAnalyticService> etaAnalyticService;
  private Binding<IPickupEtaFallbackService> fallbackService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePickupEtaServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.eta.IPickupEtaService", true, "me.lyft.android.application.ApplicationServicesModule", "providePickupEtaService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    fallbackService = paramLinker.requestBinding("me.lyft.android.application.eta.IPickupEtaFallbackService", ApplicationServicesModule.class, getClass().getClassLoader());
    etaAnalyticService = paramLinker.requestBinding("me.lyft.android.application.geo.IEtaAnalyticService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPickupEtaService get()
  {
    return module.providePickupEtaService((ILyftApi)lyftApi.get(), (IPickupEtaFallbackService)fallbackService.get(), (IEtaAnalyticService)etaAnalyticService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(fallbackService);
    paramSet1.add(etaAnalyticService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePickupEtaServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */