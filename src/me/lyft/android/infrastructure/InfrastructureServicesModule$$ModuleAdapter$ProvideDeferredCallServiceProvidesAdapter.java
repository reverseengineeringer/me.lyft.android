package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.infrastructure.deferred.IDeferredCallService;
import me.lyft.android.infrastructure.deferred.IDeferredSyncService;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideDeferredCallServiceProvidesAdapter
  extends ProvidesBinding<IDeferredCallService>
{
  private Binding<LyftApplication> application;
  private Binding<IDeferredSyncService> deferredSyncService;
  private Binding<IJsonSerializer> jsonSerializer;
  private Binding<ILyftApi> lyftApi;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideDeferredCallServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.deferred.IDeferredCallService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideDeferredCallService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", InfrastructureServicesModule.class, getClass().getClassLoader());
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    deferredSyncService = paramLinker.requestBinding("me.lyft.android.infrastructure.deferred.IDeferredSyncService", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IDeferredCallService get()
  {
    return module.provideDeferredCallService((LyftApplication)application.get(), (ILyftApi)lyftApi.get(), (IJsonSerializer)jsonSerializer.get(), (IDeferredSyncService)deferredSyncService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(application);
    paramSet1.add(lyftApi);
    paramSet1.add(jsonSerializer);
    paramSet1.add(deferredSyncService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideDeferredCallServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */