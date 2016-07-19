package me.lyft.android.analytics.trackers;

import com.kochava.android.tracker.Feature;
import com.mobileapptracker.MobileAppTracker;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.providers.AdvertisingIdProvider;

public final class AnalyticsModule$$ModuleAdapter$ProvideAppEventTrackerProvidesAdapter
  extends ProvidesBinding<AppEventTracker>
{
  private Binding<AdvertisingIdProvider> advertisingIdProvider;
  private Binding<IDevice> device;
  private Binding<Feature> feature;
  private Binding<IJsonSerializer> jsonSerializer;
  private Binding<ILyftPreferences> lyftPreferences;
  private Binding<MobileAppTracker> mobileAppTracker;
  private final AnalyticsModule module;
  
  public AnalyticsModule$$ModuleAdapter$ProvideAppEventTrackerProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("me.lyft.android.analytics.trackers.AppEventTracker", false, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAppEventTracker");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    feature = paramLinker.requestBinding("com.kochava.android.tracker.Feature", AnalyticsModule.class, getClass().getClassLoader());
    mobileAppTracker = paramLinker.requestBinding("com.mobileapptracker.MobileAppTracker", AnalyticsModule.class, getClass().getClassLoader());
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", AnalyticsModule.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AnalyticsModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
    advertisingIdProvider = paramLinker.requestBinding("me.lyft.android.providers.AdvertisingIdProvider", AnalyticsModule.class, getClass().getClassLoader());
  }
  
  public AppEventTracker get()
  {
    return module.provideAppEventTracker((Feature)feature.get(), (MobileAppTracker)mobileAppTracker.get(), (IJsonSerializer)jsonSerializer.get(), (IDevice)device.get(), (ILyftPreferences)lyftPreferences.get(), (AdvertisingIdProvider)advertisingIdProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(feature);
    paramSet1.add(mobileAppTracker);
    paramSet1.add(jsonSerializer);
    paramSet1.add(device);
    paramSet1.add(lyftPreferences);
    paramSet1.add(advertisingIdProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideAppEventTrackerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */