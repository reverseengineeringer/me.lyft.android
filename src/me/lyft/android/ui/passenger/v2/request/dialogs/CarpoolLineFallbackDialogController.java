package me.lyft.android.ui.passenger.v2.request.dialogs;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.ride.flow.RequestFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class CarpoolLineFallbackDialogController
  extends StandardDialogController
{
  private final IConstantsProvider constantsProvider;
  private final IRequestFlowProvider requestFlowProvider;
  private final IRideRequestSession rideRequestSession;
  
  @Inject
  public CarpoolLineFallbackDialogController(DialogFlow paramDialogFlow, IConstantsProvider paramIConstantsProvider, IRideRequestSession paramIRideRequestSession, IRequestFlowProvider paramIRequestFlowProvider)
  {
    super(paramDialogFlow);
    constantsProvider = paramIConstantsProvider;
    rideRequestSession = paramIRideRequestSession;
    requestFlowProvider = paramIRequestFlowProvider;
  }
  
  private void fallbackToLine()
  {
    rideRequestSession.setCurrentRideTypeById("lyft_line");
    rideRequestSession.setRequestRideStep(requestFlowProvider.getRequestFlow().determineCurrentStep());
  }
  
  public void onAttach()
  {
    super.onAttach();
    Object localObject = (ImageView)addHeaderLayout(2130903236);
    ((ImageView)localObject).setBackgroundColor(getResources().getColor(2131492878));
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject).setImageResource(2130838091);
    localObject = getResources().getString(2131165394);
    String str = getResources().getString(2131165393);
    setContentTitle((String)constantsProvider.get(Constants.CARPOOL_ROUTE_FALLBACK_DIALOG_TITLE, localObject));
    setContentMessage((CharSequence)constantsProvider.get(Constants.Carpool_ROUTE_FALLBACK_DIALOG_BODY, str));
    addPositiveButton(2130903157, getResources().getString(2131165392), new CarpoolLineFallbackDialogController.1(this));
    showCloseButton(null);
  }
  
  protected int viewId()
  {
    return 2131558414;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolLineFallbackDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */