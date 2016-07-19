package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.infrastructure.leanplum.ILeanplumService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideLeanplumServiceProvidesAdapter
  extends ProvidesBinding<ILeanplumService>
{
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<ILeanplumOverrideService> leanplumOverrideService;
  private Binding<LyftApplication> lyftApplication;
  private Binding<ILyftPreferences> lyftPreferences;
  private final InfrastructureServicesModule module;
  private Binding<IUserProvider> userProvider;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideLeanplumServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.leanplum.ILeanplumService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLeanplumService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
    leanplumOverrideService = paramLinker.requestBinding("me.lyft.android.application.constants.ILeanplumOverrideService", InfrastructureServicesModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public ILeanplumService get()
  {
    return module.provideLeanplumService((LyftApplication)lyftApplication.get(), (ILeanplumOverrideService)leanplumOverrideService.get(), (ILyftPreferences)lyftPreferences.get(), (IConstantsProvider)constantsProvider.get(), (IUserProvider)userProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
    paramSet1.add(leanplumOverrideService);
    paramSet1.add(lyftPreferences);
    paramSet1.add(constantsProvider);
    paramSet1.add(userProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideLeanplumServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */