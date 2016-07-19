package me.lyft.android.analytics.trackers;

import com.mobileapptracker.MobileAppTracker;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.common.IAppStore;

public final class AnalyticsModule$$ModuleAdapter$ProvideMobileAppTrackerProvidesAdapter
  extends ProvidesBinding<MobileAppTracker>
{
  private Binding<IAppStore> appStore;
  private Binding<LyftApplication> lyftApplication;
  private Binding<ILyftPreferences> lyftPreferences;
  private final AnalyticsModule module;
  
  public AnalyticsModule$$ModuleAdapter$ProvideMobileAppTrackerProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("com.mobileapptracker.MobileAppTracker", true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideMobileAppTracker");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", AnalyticsModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
    appStore = paramLinker.requestBinding("me.lyft.android.common.IAppStore", AnalyticsModule.class, getClass().getClassLoader());
  }
  
  public MobileAppTracker get()
  {
    return module.provideMobileAppTracker((LyftApplication)lyftApplication.get(), (ILyftPreferences)lyftPreferences.get(), (IAppStore)appStore.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
    paramSet1.add(lyftPreferences);
    paramSet1.add(appStore);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideMobileAppTrackerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */