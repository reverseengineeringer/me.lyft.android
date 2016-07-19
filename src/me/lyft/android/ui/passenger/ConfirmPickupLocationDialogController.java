package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import com.lyft.rx.MessageBus;
import javax.inject.Inject;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.location.Location;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class ConfirmPickupLocationDialogController
  extends StandardDialogController
{
  private final MessageBus messageBus;
  private final IRideRequestSession rideRequestSession;
  
  @Inject
  public ConfirmPickupLocationDialogController(DialogFlow paramDialogFlow, MessageBus paramMessageBus, IRideRequestSession paramIRideRequestSession)
  {
    super(paramDialogFlow);
    messageBus = paramMessageBus;
    rideRequestSession = paramIRideRequestSession;
  }
  
  private void setupButtons()
  {
    addPositiveButton(2130903156, getResources().getString(2131165463), new ConfirmPickupLocationDialogController.1(this));
    addNegativeButton(2130903152, getResources().getString(2131165358), new ConfirmPickupLocationDialogController.2(this));
  }
  
  private void setupContent()
  {
    setContentTitle(getResources().getString(2131165465));
    setContentFooterMessage(getResources().getString(2131166135));
    setContentGraphic(2130838459);
    if (rideRequestSession.hasVenuePickupLocation()) {}
    for (String str = rideRequestSession.getVenuePickupLocationAddress();; str = rideRequestSession.getPickupLocation().getDisplayName())
    {
      setContentMessage(str);
      return;
    }
  }
  
  public void onAttach()
  {
    super.onAttach();
    setupContent();
    setupButtons();
  }
  
  public int viewId()
  {
    return 2131558418;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.ConfirmPickupLocationDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */