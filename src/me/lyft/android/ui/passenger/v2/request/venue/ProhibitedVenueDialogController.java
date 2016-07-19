package me.lyft.android.ui.passenger.v2.request.venue;

import android.content.res.Resources;
import android.text.util.Linkify;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Unit;
import me.lyft.android.ui.dialogs.StandardDialogController;
import me.lyft.android.ui.passenger.PassengerDialogs.ProhibitedVenueDialog;

public class ProhibitedVenueDialogController
  extends StandardDialogController
{
  private final MessageBus bus;
  private PassengerDialogs.ProhibitedVenueDialog dialog;
  
  @Inject
  public ProhibitedVenueDialogController(DialogFlow paramDialogFlow, MessageBus paramMessageBus)
  {
    super(paramDialogFlow);
    bus = paramMessageBus;
  }
  
  private void onCallToActionClicked()
  {
    if (dialog.hasPickupSuggestion()) {
      bus.post(ProhibitedVenueDialogController.SuggestPickup.class, Unit.create());
    }
    dismissDialog();
  }
  
  public void onAttach()
  {
    super.onAttach();
    dialog = ((PassengerDialogs.ProhibitedVenueDialog)Screen.fromController(this));
    Object localObject = dialog.getMessage();
    if (localObject == null)
    {
      localObject = "";
      String str = (String)Objects.firstNonNull(dialog.getDetail(), getResources().getString(2131166416));
      Linkify.addLinks(setContentMessage((String)localObject + str), 15);
      localObject = getResources();
      if (!dialog.hasPickupSuggestion()) {
        break label155;
      }
    }
    label155:
    for (int i = 2131166415;; i = 2131165939)
    {
      addPositiveButton(2130903156, ((Resources)localObject).getString(i), new ProhibitedVenueDialogController.1(this));
      setHeaderGraphic(2130838072);
      showCloseButton();
      return;
      localObject = (String)localObject + "\n\n";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.venue.ProhibitedVenueDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */