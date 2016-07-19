package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.ats.IAtsService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideAtsServiceProvidesAdapter
  extends ProvidesBinding<IAtsService>
{
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideAtsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ats.IAtsService", true, "me.lyft.android.application.ApplicationServicesModule", "provideAtsService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IAtsService get()
  {
    return module.provideAtsService((ILyftApi)lyftApi.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideAtsServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */