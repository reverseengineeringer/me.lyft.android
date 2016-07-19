package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.autofill.AutoFillAnalytics;
import me.lyft.android.application.autofill.AutoFillResolutionService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IRideRequestSession;

public final class JobModule$$ModuleAdapter$ProvidePrefillResolverServiceProvidesAdapter
  extends ProvidesBinding<AutoFillResolutionService>
{
  private Binding<AutoFillAnalytics> autoFillAnalytics;
  private Binding<IFeaturesProvider> featuresProvider;
  private final JobModule module;
  private Binding<IRideRequestSession> rideRequestSession;
  
  public JobModule$$ModuleAdapter$ProvidePrefillResolverServiceProvidesAdapter(JobModule paramJobModule)
  {
    super("me.lyft.android.application.autofill.AutoFillResolutionService", false, "me.lyft.android.jobs.JobModule", "providePrefillResolverService");
    module = paramJobModule;
    setLibrary(false);
  }
  
  public void attach(Linker paramLinker)
  {
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", JobModule.class, getClass().getClassLoader());
    autoFillAnalytics = paramLinker.requestBinding("me.lyft.android.application.autofill.AutoFillAnalytics", JobModule.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", JobModule.class, getClass().getClassLoader());
  }
  
  public AutoFillResolutionService get()
  {
    return module.providePrefillResolverService((IRideRequestSession)rideRequestSession.get(), (AutoFillAnalytics)autoFillAnalytics.get(), (IFeaturesProvider)featuresProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(rideRequestSession);
    paramSet1.add(autoFillAnalytics);
    paramSet1.add(featuresProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.JobModule..ModuleAdapter.ProvidePrefillResolverServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */