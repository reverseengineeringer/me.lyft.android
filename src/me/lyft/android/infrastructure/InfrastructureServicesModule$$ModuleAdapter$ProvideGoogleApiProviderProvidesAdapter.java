package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideGoogleApiProviderProvidesAdapter
  extends ProvidesBinding<IGoogleApiProvider>
{
  private Binding<ILyftPreferences> lyftPreferences;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideGoogleApiProviderProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.googleplay.IGoogleApiProvider", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGoogleApiProvider");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IGoogleApiProvider get()
  {
    return module.provideGoogleApiProvider((ILyftPreferences)lyftPreferences.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftPreferences);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideGoogleApiProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */