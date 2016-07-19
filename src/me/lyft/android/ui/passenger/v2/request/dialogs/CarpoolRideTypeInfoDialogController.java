package me.lyft.android.ui.passenger.v2.request.dialogs;

import android.content.res.Resources;
import android.widget.ImageView;
import javax.inject.Inject;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.passenger.ridetypes.Popup;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class CarpoolRideTypeInfoDialogController
  extends StandardDialogController
{
  private final IRideTypeMetaService rideTypeMetaService;
  
  @Inject
  public CarpoolRideTypeInfoDialogController(DialogFlow paramDialogFlow, IRideTypeMetaService paramIRideTypeMetaService)
  {
    super(paramDialogFlow);
    rideTypeMetaService = paramIRideTypeMetaService;
  }
  
  public void onAttach()
  {
    super.onAttach();
    ((ImageView)addHeaderLayout(2130903236)).setImageResource(2130838079);
    Popup localPopup = rideTypeMetaService.getPopupForRideType("lyft_carpool");
    String str1 = getResources().getString(2131165389);
    String str2 = getResources().getString(2131165388);
    setContentTitle(Strings.firstNonEmpty(new String[] { localPopup.getTitle(), str1 }));
    setContentMessage(Strings.firstNonEmpty(new String[] { localPopup.getDescription(), str2 }));
    showCloseButton(null);
  }
  
  public int viewId()
  {
    return 2131558415;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolRideTypeInfoDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */