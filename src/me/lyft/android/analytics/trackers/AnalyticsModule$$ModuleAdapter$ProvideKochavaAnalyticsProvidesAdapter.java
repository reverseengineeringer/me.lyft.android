package me.lyft.android.analytics.trackers;

import com.kochava.android.tracker.Feature;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;

public final class AnalyticsModule$$ModuleAdapter$ProvideKochavaAnalyticsProvidesAdapter
  extends ProvidesBinding<Feature>
{
  private Binding<LyftApplication> lyftApplication;
  private final AnalyticsModule module;
  
  public AnalyticsModule$$ModuleAdapter$ProvideKochavaAnalyticsProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("com.kochava.android.tracker.Feature", false, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideKochavaAnalytics");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", AnalyticsModule.class, getClass().getClassLoader());
  }
  
  public Feature get()
  {
    return module.provideKochavaAnalytics((LyftApplication)lyftApplication.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideKochavaAnalyticsProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */