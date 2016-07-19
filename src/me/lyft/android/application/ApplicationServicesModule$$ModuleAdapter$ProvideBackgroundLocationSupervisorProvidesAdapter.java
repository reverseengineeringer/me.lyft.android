package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.polling.IBackgroundLocationAppProcess;
import me.lyft.android.application.polling.IBackgroundLocationTracker;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideBackgroundLocationSupervisorProvidesAdapter
  extends ProvidesBinding<IBackgroundLocationAppProcess>
{
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<IBackgroundLocationTracker> backgroundLocationTracker;
  private final ApplicationServicesModule module;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideBackgroundLocationSupervisorProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.polling.IBackgroundLocationAppProcess", true, "me.lyft.android.application.ApplicationServicesModule", "provideBackgroundLocationSupervisor");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    backgroundLocationTracker = paramLinker.requestBinding("me.lyft.android.application.polling.IBackgroundLocationTracker", ApplicationServicesModule.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IBackgroundLocationAppProcess get()
  {
    return module.provideBackgroundLocationSupervisor((IBackgroundLocationTracker)backgroundLocationTracker.get(), (IAppForegroundDetector)appForegroundDetector.get(), (IUserProvider)userProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(backgroundLocationTracker);
    paramSet1.add(appForegroundDetector);
    paramSet1.add(userProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideBackgroundLocationSupervisorProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */