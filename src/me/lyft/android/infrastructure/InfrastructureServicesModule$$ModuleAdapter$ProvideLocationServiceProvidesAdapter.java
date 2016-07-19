package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.infrastructure.location.ILocationService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideLocationServiceProvidesAdapter
  extends ProvidesBinding<ILocationService>
{
  private Binding<IFeaturesProvider> featuresProvider;
  private Binding<LyftApplication> lyftApplication;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideLocationServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.location.ILocationService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLocationService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public ILocationService get()
  {
    return module.provideLocationService((LyftApplication)lyftApplication.get(), (IFeaturesProvider)featuresProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
    paramSet1.add(featuresProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideLocationServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */