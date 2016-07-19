package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import javax.inject.Inject;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class PrimeTimeInfoDialogController
  extends StandardDialogController
{
  private final ICostService costService;
  private final IRideRequestSession rideRequestSession;
  
  @Inject
  public PrimeTimeInfoDialogController(DialogFlow paramDialogFlow, ICostService paramICostService, IRideRequestSession paramIRideRequestSession)
  {
    super(paramDialogFlow);
    costService = paramICostService;
    rideRequestSession = paramIRideRequestSession;
  }
  
  public void onAttach()
  {
    super.onAttach();
    View localView = addHeaderLayout(2130903399);
    int i = costService.getPrimeTime(rideRequestSession.getCurrentRideType().getPublicId());
    ((TextView)localView.findViewById(2131559599)).setText(getResources().getString(2131166158, new Object[] { Integer.valueOf(i) }));
    setContentMessage(getResources().getString(2131166157, new Object[] { Integer.valueOf(i) }));
    showCloseButton();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PrimeTimeInfoDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */