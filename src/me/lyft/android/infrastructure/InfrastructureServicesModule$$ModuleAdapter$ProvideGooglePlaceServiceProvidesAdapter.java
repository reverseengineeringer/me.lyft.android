package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.googleplaces.IGooglePlaceService;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideGooglePlaceServiceProvidesAdapter
  extends ProvidesBinding<IGooglePlaceService>
{
  private Binding<IGoogleApiProvider> googleApiProvider;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideGooglePlaceServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.googleplaces.IGooglePlaceService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGooglePlaceService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    googleApiProvider = paramLinker.requestBinding("me.lyft.android.infrastructure.googleplay.IGoogleApiProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IGooglePlaceService get()
  {
    return module.provideGooglePlaceService((IGoogleApiProvider)googleApiProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(googleApiProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideGooglePlaceServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */