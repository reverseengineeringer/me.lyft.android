package me.lyft.android.ui.passenger.autofill;

import android.content.res.Resources;
import android.view.View;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class AutoFillConfirmationDialogController
  extends StandardDialogController
{
  @Inject
  public AutoFillConfirmationDialogController(DialogFlow paramDialogFlow)
  {
    super(paramDialogFlow);
  }
  
  public void onAttach()
  {
    super.onAttach();
    setHeaderGraphic(2130838074);
    setContentTitle(getResources().getString(2131165308));
    setContentMessage(getResources().getString(2131165307));
    showCloseButton().setOnClickListener(new AutoFillConfirmationDialogController.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.autofill.AutoFillConfirmationDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */