package me.lyft.android.jobs;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.AppModule;
import me.lyft.android.application.autofill.AutoFillAnalytics;
import me.lyft.android.application.autofill.AutoFillResolutionService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IRideRequestSession;

@Module(addsTo=AppModule.class, injects={CourierDriverRideUpdatedJob.class, DriverCloseToCurrentStopJob.class, RideAssignedJob.class, RideStatusChangedJob.class, RideTypesMetaChangedJob.class, UpdateGcmIdentifierJob.class, UserModeChangeJob.class, LyftTokenUpdateJob.class, ThreatMetrixJob.class, GoogleNowAuthorizationJob.class, PollingRateChangedJob.class, ConfigureProxyJob.class, RideRequestSessionUpdateJob.class, InitFacebookSdkJob.class, DriverRideUpdateJob.class, DriverDestinationJob.class, PassengerRideUpdateJob.class, AppInfoUpdateJob.class, UserUpdateJob.class, UpdatePassengerRideReceiptJob.class, UpdateSplitFareJob.class, UpdateSplitFareStateJob.class, DriverDailyTotalsJob.class, EtaUpdateJob.class, LoadAppInfoJob.class, AutoFillLocationJob.class, UpdateShortcutsJob.class, UpdateAppNotificationJob.class, UpdateCarpoolRideRequestsJob.class, RideProfilesUpdateJob.class})
public class JobModule
{
  @Provides
  AutoFillResolutionService providePrefillResolverService(IRideRequestSession paramIRideRequestSession, AutoFillAnalytics paramAutoFillAnalytics, IFeaturesProvider paramIFeaturesProvider)
  {
    return new AutoFillResolutionService(paramIRideRequestSession, paramAutoFillAnalytics, paramIFeaturesProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.JobModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */