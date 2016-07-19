package me.lyft.android.analytics.trackers;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public final class AnalyticsModule$$ModuleAdapter$ProvideAnalyticsApiProvidesAdapter
  extends ProvidesBinding<AnalyticsApi>
{
  private Binding<LyftApplication> appContext;
  private Binding<IDeveloperTools> developerTools;
  private Binding<IJsonSerializer> jsonSerializer;
  private Binding<ILyftPreferences> lyftPreferences;
  private final AnalyticsModule module;
  
  public AnalyticsModule$$ModuleAdapter$ProvideAnalyticsApiProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("me.lyft.android.analytics.trackers.AnalyticsApi", true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAnalyticsApi");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    appContext = paramLinker.requestBinding("me.lyft.android.LyftApplication", AnalyticsModule.class, getClass().getClassLoader());
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", AnalyticsModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
    developerTools = paramLinker.requestBinding("me.lyft.android.development.IDeveloperTools", AnalyticsModule.class, getClass().getClassLoader());
  }
  
  public AnalyticsApi get()
  {
    return module.provideAnalyticsApi((LyftApplication)appContext.get(), (IJsonSerializer)jsonSerializer.get(), (ILyftPreferences)lyftPreferences.get(), (IDeveloperTools)developerTools.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(appContext);
    paramSet1.add(jsonSerializer);
    paramSet1.add(lyftPreferences);
    paramSet1.add(developerTools);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideAnalyticsApiProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */