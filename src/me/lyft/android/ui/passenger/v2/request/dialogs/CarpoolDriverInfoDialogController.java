package me.lyft.android.ui.passenger.v2.request.dialogs;

import android.content.res.Resources;
import android.widget.ImageView;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.dialogs.StandardDialogController;
import me.lyft.android.utils.WebBrowser;

public class CarpoolDriverInfoDialogController
  extends StandardDialogController
{
  private final IConstantsProvider constantsProvider;
  private final ILyftPreferences lyftPreferences;
  private final WebBrowser webBrowser;
  
  @Inject
  public CarpoolDriverInfoDialogController(DialogFlow paramDialogFlow, IConstantsProvider paramIConstantsProvider, ILyftPreferences paramILyftPreferences, WebBrowser paramWebBrowser)
  {
    super(paramDialogFlow);
    constantsProvider = paramIConstantsProvider;
    lyftPreferences = paramILyftPreferences;
    webBrowser = paramWebBrowser;
  }
  
  private void openCarpoolDriverFaq()
  {
    dismissDialog();
    webBrowser.open(lyftPreferences.getLyftWebRoot() + "/carpool/help");
  }
  
  public void onAttach()
  {
    super.onAttach();
    ((ImageView)addHeaderLayout(2130903236)).setImageResource(2130838083);
    String str1 = getResources().getString(2131165383);
    String str2 = getResources().getString(2131165382);
    setContentTitle((String)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_COMPLETE_TITLE, str1));
    setContentMessage((CharSequence)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_COMPLETE_BODY, str2));
    showCloseButton(null);
    addPositiveButton(2130903157, getResources().getString(2131165879), new CarpoolDriverInfoDialogController.1(this));
  }
  
  public int viewId()
  {
    return 2131558413;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolDriverInfoDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */