package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.infrastructure.androidpay.IAndroidPayService;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideWalletServiceProvidesAdapter
  extends ProvidesBinding<IAndroidPayService>
{
  private Binding<IGoogleApiProvider> googleApiProvider;
  private final InfrastructureServicesModule module;
  private Binding<ILyftPreferences> preferences;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideWalletServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.androidpay.IAndroidPayService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideWalletService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    googleApiProvider = paramLinker.requestBinding("me.lyft.android.infrastructure.googleplay.IGoogleApiProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IAndroidPayService get()
  {
    return module.provideWalletService((IGoogleApiProvider)googleApiProvider.get(), (ILyftPreferences)preferences.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(googleApiProvider);
    paramSet1.add(preferences);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideWalletServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */