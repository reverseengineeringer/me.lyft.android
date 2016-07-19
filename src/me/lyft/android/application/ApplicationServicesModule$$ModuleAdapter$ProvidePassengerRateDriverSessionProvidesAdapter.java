package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.persistence.rating.IRatingStateStorage;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePassengerRateDriverSessionProvidesAdapter
  extends ProvidesBinding<IRatingSession>
{
  private final ApplicationServicesModule module;
  private Binding<IRatingStateStorage> stateStorage;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePassengerRateDriverSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IRatingSession", true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerRateDriverSession");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    stateStorage = paramLinker.requestBinding("me.lyft.android.persistence.rating.IRatingStateStorage", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IRatingSession get()
  {
    return module.providePassengerRateDriverSession((IRatingStateStorage)stateStorage.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(stateStorage);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePassengerRateDriverSessionProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */