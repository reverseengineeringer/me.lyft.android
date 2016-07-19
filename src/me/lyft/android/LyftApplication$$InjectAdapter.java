package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.analytics.trackers.IAnalyticsService;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.jobs.JobManager;

public final class LyftApplication$$InjectAdapter
  extends Binding<LyftApplication>
{
  private Binding<IAnalyticsService> analyticsService;
  private Binding<IDeveloperTools> developerTools;
  private Binding<IDevice> device;
  private Binding<JobManager> jobManager;
  private Binding<ILogoutService> logoutService;
  private Binding<ILyftPreferences> preferences;
  
  public LyftApplication$$InjectAdapter()
  {
    super("me.lyft.android.LyftApplication", "members/me.lyft.android.LyftApplication", false, LyftApplication.class);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", LyftApplication.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", LyftApplication.class, getClass().getClassLoader());
    jobManager = paramLinker.requestBinding("me.lyft.android.jobs.JobManager", LyftApplication.class, getClass().getClassLoader());
    analyticsService = paramLinker.requestBinding("me.lyft.android.analytics.trackers.IAnalyticsService", LyftApplication.class, getClass().getClassLoader());
    logoutService = paramLinker.requestBinding("me.lyft.android.application.ILogoutService", LyftApplication.class, getClass().getClassLoader());
    developerTools = paramLinker.requestBinding("me.lyft.android.development.IDeveloperTools", LyftApplication.class, getClass().getClassLoader());
  }
  
  public LyftApplication get()
  {
    LyftApplication localLyftApplication = new LyftApplication();
    injectMembers(localLyftApplication);
    return localLyftApplication;
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(preferences);
    paramSet2.add(device);
    paramSet2.add(jobManager);
    paramSet2.add(analyticsService);
    paramSet2.add(logoutService);
    paramSet2.add(developerTools);
  }
  
  public void injectMembers(LyftApplication paramLyftApplication)
  {
    preferences = ((ILyftPreferences)preferences.get());
    device = ((IDevice)device.get());
    jobManager = ((JobManager)jobManager.get());
    analyticsService = ((IAnalyticsService)analyticsService.get());
    logoutService = ((ILogoutService)logoutService.get());
    developerTools = ((IDeveloperTools)developerTools.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.LyftApplication..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */