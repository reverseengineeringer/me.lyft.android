package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.persistence.ISimpleRepositoryFactory;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideleanplumOverrideServiceProvidesAdapter
  extends ProvidesBinding<ILeanplumOverrideService>
{
  private final ApplicationServicesModule module;
  private Binding<ISimpleRepositoryFactory> simpleRepositoryFactory;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideleanplumOverrideServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.constants.ILeanplumOverrideService", true, "me.lyft.android.application.ApplicationServicesModule", "provideleanplumOverrideService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    simpleRepositoryFactory = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepositoryFactory", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ILeanplumOverrideService get()
  {
    return module.provideleanplumOverrideService((ISimpleRepositoryFactory)simpleRepositoryFactory.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(simpleRepositoryFactory);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideleanplumOverrideServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */