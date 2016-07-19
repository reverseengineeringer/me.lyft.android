package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRideRequestSessionProvidesAdapter
  extends ProvidesBinding<IRideRequestSession>
{
  private final ApplicationServicesModule module;
  private Binding<ILyftPreferences> preferences;
  private Binding<IRequestRideTypeService> requestRideTypeProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRideRequestSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IRideRequestSession", true, "me.lyft.android.application.ApplicationServicesModule", "provideRideRequestSession");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
    requestRideTypeProvider = paramLinker.requestBinding("me.lyft.android.application.requestridetypes.IRequestRideTypeService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IRideRequestSession get()
  {
    return module.provideRideRequestSession((ILyftPreferences)preferences.get(), (IRequestRideTypeService)requestRideTypeProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(preferences);
    paramSet1.add(requestRideTypeProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRideRequestSessionProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */