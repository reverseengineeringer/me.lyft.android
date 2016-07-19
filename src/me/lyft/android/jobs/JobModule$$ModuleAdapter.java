package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.autofill.AutoFillAnalytics;
import me.lyft.android.application.autofill.AutoFillResolutionService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IRideRequestSession;

public final class JobModule$$ModuleAdapter
  extends ModuleAdapter<JobModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = { "members/me.lyft.android.jobs.CourierDriverRideUpdatedJob", "members/me.lyft.android.jobs.DriverCloseToCurrentStopJob", "members/me.lyft.android.jobs.RideAssignedJob", "members/me.lyft.android.jobs.RideStatusChangedJob", "members/me.lyft.android.jobs.RideTypesMetaChangedJob", "members/me.lyft.android.jobs.UpdateGcmIdentifierJob", "members/me.lyft.android.jobs.UserModeChangeJob", "members/me.lyft.android.jobs.LyftTokenUpdateJob", "members/me.lyft.android.jobs.ThreatMetrixJob", "members/me.lyft.android.jobs.GoogleNowAuthorizationJob", "members/me.lyft.android.jobs.PollingRateChangedJob", "members/me.lyft.android.jobs.ConfigureProxyJob", "members/me.lyft.android.jobs.RideRequestSessionUpdateJob", "members/me.lyft.android.jobs.InitFacebookSdkJob", "members/me.lyft.android.jobs.DriverRideUpdateJob", "members/me.lyft.android.jobs.DriverDestinationJob", "members/me.lyft.android.jobs.PassengerRideUpdateJob", "members/me.lyft.android.jobs.AppInfoUpdateJob", "members/me.lyft.android.jobs.UserUpdateJob", "members/me.lyft.android.jobs.UpdatePassengerRideReceiptJob", "members/me.lyft.android.jobs.UpdateSplitFareJob", "members/me.lyft.android.jobs.UpdateSplitFareStateJob", "members/me.lyft.android.jobs.DriverDailyTotalsJob", "members/me.lyft.android.jobs.EtaUpdateJob", "members/me.lyft.android.jobs.LoadAppInfoJob", "members/me.lyft.android.jobs.AutoFillLocationJob", "members/me.lyft.android.jobs.UpdateShortcutsJob", "members/me.lyft.android.jobs.UpdateAppNotificationJob", "members/me.lyft.android.jobs.UpdateCarpoolRideRequestsJob", "members/me.lyft.android.jobs.RideProfilesUpdateJob" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public JobModule$$ModuleAdapter()
  {
    super(JobModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, false);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, JobModule paramJobModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.autofill.AutoFillResolutionService", new ProvidePrefillResolverServiceProvidesAdapter(paramJobModule));
  }
  
  public JobModule newModule()
  {
    return new JobModule();
  }
  
  public static final class ProvidePrefillResolverServiceProvidesAdapter
    extends ProvidesBinding<AutoFillResolutionService>
  {
    private Binding<AutoFillAnalytics> autoFillAnalytics;
    private Binding<IFeaturesProvider> featuresProvider;
    private final JobModule module;
    private Binding<IRideRequestSession> rideRequestSession;
    
    public ProvidePrefillResolverServiceProvidesAdapter(JobModule paramJobModule)
    {
      super(false, "me.lyft.android.jobs.JobModule", "providePrefillResolverService");
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
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.JobModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */