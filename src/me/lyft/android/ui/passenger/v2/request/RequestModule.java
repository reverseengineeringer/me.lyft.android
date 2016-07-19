package me.lyft.android.ui.passenger.v2.request;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.riderequest.IRideRequestPollingService;
import me.lyft.android.infrastructure.appboy.IAppboyService;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.persistence.splitfare.ISplitFareRequestRepository;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter;
import me.lyft.android.ui.passenger.v2.PassengerAnalytics;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.ride.PassengerRideModule;
import me.lyft.android.ui.ride.RideMap;

@Module(addsTo=PassengerRideModule.class, complete=false, injects={PassengerRequestRideViewV2.class, ScheduleRideButton.class}, library=true)
public class RequestModule
{
  @Provides
  @Singleton
  PassengerRequestRidePresenterV2 providePassengerRequestRidePresenterV2(SlideMenuController paramSlideMenuController, IRideRequestSession paramIRideRequestSession, RideMap paramRideMap, IRequestRideTypeService paramIRequestRideTypeService, ISplitFareRequestRepository paramISplitFareRequestRepository, SplitFareAnalytics paramSplitFareAnalytics, IUserProvider paramIUserProvider, ILyftPreferences paramILyftPreferences, IAppboyService paramIAppboyService, InAppNotificationService paramInAppNotificationService, PassengerRideRouter paramPassengerRideRouter, IRequestFlowProvider paramIRequestFlowProvider, CarpoolDriverOnboardingRouter paramCarpoolDriverOnboardingRouter, INearbyDriversService paramINearbyDriversService, IRideRequestPollingService paramIRideRequestPollingService, PassengerAnalytics paramPassengerAnalytics)
  {
    return new PassengerRequestRidePresenterV2(paramSlideMenuController, paramIRideRequestSession, paramRideMap, paramIRequestRideTypeService, paramISplitFareRequestRepository, paramSplitFareAnalytics, paramIUserProvider, paramILyftPreferences, paramIAppboyService, paramInAppNotificationService, paramPassengerRideRouter, paramIRequestFlowProvider, paramCarpoolDriverOnboardingRouter, paramINearbyDriversService, paramIRideRequestPollingService, paramPassengerAnalytics);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.RequestModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */