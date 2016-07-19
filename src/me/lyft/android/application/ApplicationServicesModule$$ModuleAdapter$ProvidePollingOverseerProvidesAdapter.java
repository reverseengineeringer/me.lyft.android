package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.polling.IPollingAppProcess;
import me.lyft.android.application.polling.IPollingService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePollingOverseerProvidesAdapter
  extends ProvidesBinding<IPollingAppProcess>
{
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private final ApplicationServicesModule module;
  private Binding<IPollingService> pollingService;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePollingOverseerProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.polling.IPollingAppProcess", true, "me.lyft.android.application.ApplicationServicesModule", "providePollingOverseer");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    pollingService = paramLinker.requestBinding("me.lyft.android.application.polling.IPollingService", ApplicationServicesModule.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPollingAppProcess get()
  {
    return module.providePollingOverseer((IPollingService)pollingService.get(), (IAppForegroundDetector)appForegroundDetector.get(), (IUserProvider)userProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(pollingService);
    paramSet1.add(appForegroundDetector);
    paramSet1.add(userProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePollingOverseerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */