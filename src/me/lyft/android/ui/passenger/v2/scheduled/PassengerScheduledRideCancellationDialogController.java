package me.lyft.android.ui.passenger.v2.scheduled;

import android.content.res.Resources;
import com.lyft.scoop.Screen;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.ICancellationOptionsProvider;
import me.lyft.android.application.ride.services.IScheduledRideService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.domain.ride.ScheduledRide;
import me.lyft.android.domain.time.Time;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.StandardDialogController;
import me.lyft.android.ui.passenger.PassengerDialogs.PassengerScheduledRideCancellationDialog;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;

public class PassengerScheduledRideCancellationDialogController
  extends StandardDialogController
{
  private final ICancellationOptionsProvider cancellationOptionsProvider;
  private final PassengerRideRouter passengerRideRouter;
  private final IProgressController progressController;
  private ScheduledRide scheduledRide;
  private final IScheduledRideService scheduledRideService;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public PassengerScheduledRideCancellationDialogController(DialogFlow paramDialogFlow, IProgressController paramIProgressController, ICancellationOptionsProvider paramICancellationOptionsProvider, IViewErrorHandler paramIViewErrorHandler, IScheduledRideService paramIScheduledRideService, PassengerRideRouter paramPassengerRideRouter)
  {
    super(paramDialogFlow);
    scheduledRideService = paramIScheduledRideService;
    progressController = paramIProgressController;
    cancellationOptionsProvider = paramICancellationOptionsProvider;
    viewErrorHandler = paramIViewErrorHandler;
    passengerRideRouter = paramPassengerRideRouter;
  }
  
  private void addCancelReasonButton(CancellationOption paramCancellationOption)
  {
    addPositiveButton(2130903157, paramCancellationOption.getString(), new PassengerScheduledRideCancellationDialogController.1(this, paramCancellationOption));
  }
  
  private void cancelRide(CancellationOption paramCancellationOption)
  {
    progressController.disableUI();
    binder.bindAsyncCall(scheduledRideService.cancelScheduledRide(scheduledRide), new PassengerScheduledRideCancellationDialogController.2(this));
  }
  
  public void onAttach()
  {
    super.onAttach();
    scheduledRide = ((PassengerDialogs.PassengerScheduledRideCancellationDialog)Screen.fromController(this)).getScheduledRide();
    Object localObject = scheduledRide.getPickupTime();
    setContentTitle(getResources().getString(2131166294, new Object[] { ((Time)localObject).formatTime(), ((Time)localObject).formatDate() }));
    localObject = cancellationOptionsProvider.getCancellationOptions().iterator();
    while (((Iterator)localObject).hasNext()) {
      addCancelReasonButton((CancellationOption)((Iterator)localObject).next());
    }
    addNegativeButton(2130903152, getResources().getString(2131165562), getDismissListener());
  }
  
  public int viewId()
  {
    return 2131558412;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.scheduled.PassengerScheduledRideCancellationDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */