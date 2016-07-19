package me.lyft.android.ui.passenger.v2.request.dialogs;

import android.content.res.Resources;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.CarpoolOnboardingAnalytics;
import me.lyft.android.application.terms.ITermsService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.StandardDialogController;
import me.lyft.android.ui.passenger.PassengerDialogs.AboutCarpoolDriversDialog;

public class CarpoolDriverAboutDialogController
  extends StandardDialogController
{
  private final MessageBus bus;
  private final IViewErrorHandler errorHandler;
  private final IProgressController progressController;
  private final ITermsService termsService;
  private String termsUrl;
  
  @Inject
  public CarpoolDriverAboutDialogController(DialogFlow paramDialogFlow, MessageBus paramMessageBus, ITermsService paramITermsService, IViewErrorHandler paramIViewErrorHandler, IProgressController paramIProgressController)
  {
    super(paramDialogFlow);
    bus = paramMessageBus;
    termsService = paramITermsService;
    errorHandler = paramIViewErrorHandler;
    progressController = paramIProgressController;
  }
  
  private void onAgree()
  {
    CarpoolOnboardingAnalytics.trackPassengerToSAccept();
    progressController.showProgress();
    binder.bindAsyncCall(termsService.acceptTermsOfService(termsUrl), new CarpoolDriverAboutDialogController.3(this));
  }
  
  private void onCancel()
  {
    CarpoolOnboardingAnalytics.trackPassengerToSDismissed();
    dismissDialog();
  }
  
  public void onAttach()
  {
    super.onAttach();
    termsUrl = Strings.firstNonEmpty(new String[] { ((PassengerDialogs.AboutCarpoolDriversDialog)Screen.fromController(this)).getTermsUrl(), "https://www.lyft.com/carpool/terms" });
    setHeaderGraphic(2130838392);
    setContentTitle(getResources().getString(2131165374));
    TextView localTextView = setContentMessage(Html.fromHtml(getResources().getString(2131165373, new Object[] { termsUrl })));
    localTextView.setTextSize(0, getResources().getDimension(2131230749));
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    addPositiveButton(2130903157, getResources().getString(2131165372), new CarpoolDriverAboutDialogController.1(this));
    addNegativeButton(2130903152, getResources().getString(2131165358), new CarpoolDriverAboutDialogController.2(this));
  }
  
  public int viewId()
  {
    return 2131558411;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolDriverAboutDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */