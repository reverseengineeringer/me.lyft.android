package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.ICancellationOptionsProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideCancellationOptionsProviderProvidesAdapter
  extends ProvidesBinding<ICancellationOptionsProvider>
{
  private Binding<IConstantsProvider> constantsProvider;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideCancellationOptionsProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.ICancellationOptionsProvider", true, "me.lyft.android.application.ApplicationServicesModule", "provideCancellationOptionsProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ICancellationOptionsProvider get()
  {
    return module.provideCancellationOptionsProvider((IConstantsProvider)constantsProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(constantsProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideCancellationOptionsProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */