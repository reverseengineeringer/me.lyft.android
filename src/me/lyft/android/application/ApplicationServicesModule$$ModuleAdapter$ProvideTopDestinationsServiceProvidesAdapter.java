package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.topdestinations.ITopDestinationsService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideTopDestinationsServiceProvidesAdapter
  extends ProvidesBinding<ITopDestinationsService>
{
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideTopDestinationsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.topdestinations.ITopDestinationsService", true, "me.lyft.android.application.ApplicationServicesModule", "provideTopDestinationsService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ITopDestinationsService get()
  {
    return module.provideTopDestinationsService((ILyftApi)lyftApi.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideTopDestinationsServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */