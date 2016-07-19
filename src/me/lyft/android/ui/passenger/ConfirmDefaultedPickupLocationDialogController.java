package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class ConfirmDefaultedPickupLocationDialogController
  extends StandardDialogController
{
  private final MessageBus bus;
  private final IConstantsProvider constantsProvider;
  private final IRideRequestSession rideRequestSession;
  
  @Inject
  public ConfirmDefaultedPickupLocationDialogController(DialogFlow paramDialogFlow, IConstantsProvider paramIConstantsProvider, IRideRequestSession paramIRideRequestSession, MessageBus paramMessageBus)
  {
    super(paramDialogFlow);
    constantsProvider = paramIConstantsProvider;
    rideRequestSession = paramIRideRequestSession;
    bus = paramMessageBus;
  }
  
  private void confirmInaccuratePickupLocation()
  {
    rideRequestSession.confirmPickupLocation();
    dismissDialog();
    bus.post(ConfirmPickupLocationResult.class, Boolean.valueOf(true));
  }
  
  public void onAttach()
  {
    super.onAttach();
    String str = ((PassengerDialogs.ConfirmDefaultedPickupLocationDialog)Screen.fromController(this)).getAddress();
    setContentTitle((String)constantsProvider.get(Constants.CONFIRM_DEFAULTED_PICKUP_DIALOG_TITLE_TEXT, getResources().getString(2131165974)));
    setContentMessage(str);
    setContentGraphic(2130838459);
    setContentFooterMessage(getResources().getString(2131165464));
    addPositiveButton(2130903156, getResources().getString(2131165463), new ConfirmDefaultedPickupLocationDialogController.1(this));
    addNegativeButton(2130903152, getResources().getString(2131165358), getDismissListener());
  }
  
  public int viewId()
  {
    return 2131558417;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.ConfirmDefaultedPickupLocationDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */