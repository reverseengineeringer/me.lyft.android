package me.lyft.android.ui.driver.ridescreens;

import com.lyft.rx.MessageBus;
import dagger.Module;
import dagger.Provides;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.services.TimerManager;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.driver.DriverActiveRideZoomingController;
import me.lyft.android.ui.ride.RideMap;
import me.lyft.android.utils.Telephony;

@Module(addsTo=DriverRideModule.class, injects={DriverRideArrivedController.class})
public class DriverRideArrivedModule
{
  @Provides
  public DriverRideArrivedController provideDriverRideArrivedController(IProgressController paramIProgressController, IDriverRideProvider paramIDriverRideProvider, ILyftPreferences paramILyftPreferences, ILocationService paramILocationService, MessageBus paramMessageBus, DialogFlow paramDialogFlow, RideMap paramRideMap, IViewErrorHandler paramIViewErrorHandler, ProfileFlow paramProfileFlow, IDriverRouteService paramIDriverRouteService, TimerManager paramTimerManager, Telephony paramTelephony, IConstantsProvider paramIConstantsProvider, PinTextRenderer paramPinTextRenderer, DriverActiveRideZoomingController paramDriverActiveRideZoomingController)
  {
    return new DriverRideArrivedController(paramIProgressController, paramIDriverRideProvider, paramILyftPreferences, paramILocationService, paramMessageBus, paramDialogFlow, paramRideMap, paramIViewErrorHandler, paramProfileFlow, paramIDriverRouteService, paramTimerManager, paramTelephony, paramIConstantsProvider, paramPinTextRenderer, paramDriverActiveRideZoomingController);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRideArrivedModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */