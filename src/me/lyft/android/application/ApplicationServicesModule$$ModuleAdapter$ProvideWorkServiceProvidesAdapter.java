package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideWorkServiceProvidesAdapter
  extends ProvidesBinding<IEnterpriseService>
{
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<ILyftPreferences> preferences;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideWorkServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.enterprise.IEnterpriseService", true, "me.lyft.android.application.ApplicationServicesModule", "provideWorkService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IEnterpriseService get()
  {
    return module.provideWorkService((ILyftApi)lyftApi.get(), (ILyftPreferences)preferences.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(preferences);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideWorkServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */