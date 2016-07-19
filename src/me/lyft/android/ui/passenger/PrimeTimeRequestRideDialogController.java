package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.lyft.rx.CountdownTimer;
import com.lyft.rx.MessageBus;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class PrimeTimeRequestRideDialogController
  extends StandardDialogController
{
  public static final long REQUEST_LYFT_PRIME_TIME_DIALOG_TIMEOUT = 30L;
  private final MessageBus bus;
  private final IRideRequestSession rideRequestSession;
  
  @Inject
  public PrimeTimeRequestRideDialogController(IRideRequestSession paramIRideRequestSession, MessageBus paramMessageBus, DialogFlow paramDialogFlow)
  {
    super(paramDialogFlow);
    rideRequestSession = paramIRideRequestSession;
    bus = paramMessageBus;
  }
  
  private void confirmLyftRequest()
  {
    rideRequestSession.confirmDynamicPricing();
    dismissDialog();
    postResult(PrimeTimeRequestRideDialogController.RequestType.LYFT);
  }
  
  private void postResult(PrimeTimeRequestRideDialogController.RequestType paramRequestType)
  {
    bus.post(PrimeTimeRequestRideDialogController.ConfirmPricingDialogResultEvent.class, paramRequestType);
  }
  
  private void runConfirmationDismissTimeout()
  {
    binder.bindAction(CountdownTimer.create(30L, TimeUnit.SECONDS, 1), new PrimeTimeRequestRideDialogController.2(this));
  }
  
  public void onAttach()
  {
    super.onAttach();
    View localView = addHeaderLayout(2130903399);
    int i = rideRequestSession.getCostEstimate().getPrimeTime();
    ((TextView)localView.findViewById(2131559599)).setText(getResources().getString(2131166158, new Object[] { Integer.valueOf(i) }));
    setContentMessage(getResources().getString(2131166157, new Object[] { Integer.valueOf(i) }));
    addPositiveButton(2130903156, getResources().getString(2131165461), new PrimeTimeRequestRideDialogController.1(this));
    showCloseButton(getResources().getString(2131165359));
    runConfirmationDismissTimeout();
  }
  
  public boolean onBack()
  {
    super.onBack();
    postResult(PrimeTimeRequestRideDialogController.RequestType.CANCEL);
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PrimeTimeRequestRideDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */