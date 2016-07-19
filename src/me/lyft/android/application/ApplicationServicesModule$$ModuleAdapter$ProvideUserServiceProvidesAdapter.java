package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.persistence.ISimpleRepositoryFactory;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideUserServiceProvidesAdapter
  extends ProvidesBinding<IUserUiService>
{
  private final ApplicationServicesModule module;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  private Binding<ISimpleRepositoryFactory> simpleRepositoryFactory;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideUserServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IUserUiService", true, "me.lyft.android.application.ApplicationServicesModule", "provideUserService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    simpleRepositoryFactory = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepositoryFactory", ApplicationServicesModule.class, getClass().getClassLoader());
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IUserUiService get()
  {
    return module.provideUserService((IUserProvider)userProvider.get(), (ISimpleRepositoryFactory)simpleRepositoryFactory.get(), (IPassengerRideProvider)passengerRideProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(simpleRepositoryFactory);
    paramSet1.add(passengerRideProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideUserServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */