package me.lyft.android.analytics.trackers;

import dagger.internal.ProvidesBinding;

public final class AnalyticsModule$$ModuleAdapter$ProvideLogEventTrackerProvidesAdapter
  extends ProvidesBinding<LogEventTracker>
{
  private final AnalyticsModule module;
  
  public AnalyticsModule$$ModuleAdapter$ProvideLogEventTrackerProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("me.lyft.android.analytics.trackers.LogEventTracker", false, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideLogEventTracker");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public LogEventTracker get()
  {
    return module.provideLogEventTracker();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideLogEventTrackerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */