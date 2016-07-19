package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.servertimestamp.IServerTimestampService;
import me.lyft.android.jobs.JobManager;

public final class AppModule$$ModuleAdapter$ProvideIUserSessionProvidesAdapter
  extends ProvidesBinding<IUserSession>
{
  private Binding<JobManager> jobManager;
  private final AppModule module;
  private Binding<ILyftPreferences> preferences;
  private Binding<IServerTimestampService> serverTimestampService;
  
  public AppModule$$ModuleAdapter$ProvideIUserSessionProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.IUserSession", true, "me.lyft.android.AppModule", "provideIUserSession");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AppModule.class, getClass().getClassLoader());
    jobManager = paramLinker.requestBinding("me.lyft.android.jobs.JobManager", AppModule.class, getClass().getClassLoader());
    serverTimestampService = paramLinker.requestBinding("me.lyft.android.infrastructure.servertimestamp.IServerTimestampService", AppModule.class, getClass().getClassLoader());
  }
  
  public IUserSession get()
  {
    return module.provideIUserSession((ILyftPreferences)preferences.get(), (JobManager)jobManager.get(), (IServerTimestampService)serverTimestampService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(preferences);
    paramSet1.add(jobManager);
    paramSet1.add(serverTimestampService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideIUserSessionProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */