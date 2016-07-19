package me.lyft.android.ui.passenger.v2.request;

import android.content.res.Resources;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.IAppStore;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class PromptToRateDialogController
  extends StandardDialogController
{
  private final IAppStore appStore;
  private final ILyftPreferences preferences;
  
  @Inject
  public PromptToRateDialogController(DialogFlow paramDialogFlow, ILyftPreferences paramILyftPreferences, IAppStore paramIAppStore)
  {
    super(paramDialogFlow);
    preferences = paramILyftPreferences;
    appStore = paramIAppStore;
  }
  
  private void setRateAppPromptTimestampAndDismiss(long paramLong)
  {
    preferences.setRateAppPromptTimestamp(paramLong);
    dismissDialog();
  }
  
  public void onAttach()
  {
    super.onAttach();
    setContentTitle(getResources().getString(2131166209));
    setContentMessage(getResources().getString(2131166208));
    addPositiveButton(2130903152, getResources().getString(2131166212), new PromptToRateDialogController.1(this));
    addNeutralButton(2130903152, getResources().getString(2131166211), new PromptToRateDialogController.2(this));
    addNegativeButton(2130903152, getResources().getString(2131166210), new PromptToRateDialogController.3(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.PromptToRateDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */