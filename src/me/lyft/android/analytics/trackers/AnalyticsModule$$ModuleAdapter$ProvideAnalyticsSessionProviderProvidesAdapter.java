package me.lyft.android.analytics.trackers;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.session.AnalyticsSession;
import me.lyft.android.infrastructure.device.IDevice;

public final class AnalyticsModule$$ModuleAdapter$ProvideAnalyticsSessionProviderProvidesAdapter
  extends ProvidesBinding<AnalyticsSession>
{
  private Binding<IDevice> device;
  private Binding<ILyftPreferences> lyftPreferences;
  private final AnalyticsModule module;
  
  public AnalyticsModule$$ModuleAdapter$ProvideAnalyticsSessionProviderProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("me.lyft.android.analytics.session.AnalyticsSession", true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAnalyticsSessionProvider");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AnalyticsModule.class, getClass().getClassLoader());
  }
  
  public AnalyticsSession get()
  {
    return module.provideAnalyticsSessionProvider((ILyftPreferences)lyftPreferences.get(), (IDevice)device.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftPreferences);
    paramSet1.add(device);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideAnalyticsSessionProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */