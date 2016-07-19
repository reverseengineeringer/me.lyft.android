package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.invite.IWarmWelcomeService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.ISimpleRepositoryFactory;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideWarmWelcomeServiceProvidesAdapter
  extends ProvidesBinding<IWarmWelcomeService>
{
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<ISimpleRepositoryFactory> simpleRepositoryFactory;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideWarmWelcomeServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.invite.IWarmWelcomeService", true, "me.lyft.android.application.ApplicationServicesModule", "provideWarmWelcomeService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    simpleRepositoryFactory = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepositoryFactory", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IWarmWelcomeService get()
  {
    return module.provideWarmWelcomeService((ILyftApi)lyftApi.get(), (ISimpleRepositoryFactory)simpleRepositoryFactory.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(simpleRepositoryFactory);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideWarmWelcomeServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */