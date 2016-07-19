package me.lyft.android.ui.splitfare;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.scoop.HandleBack;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.domain.splitfare.SplitFareRequest;
import me.lyft.android.infrastructure.splitfare.ISplitFareService;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.persistence.splitfare.ISplitFareRequestRepository;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import rx.functions.Action0;

public class SplitPaymentRequestController
  extends RxViewController
  implements HandleBack
{
  private final AppFlow appFlow;
  private final IChargeAccountsProvider chargeAccountsProvider;
  private final IConstantsProvider constantsProvider;
  private final DialogFlow dialogFlow;
  private final ImageLoader imageLoader;
  private final IProgressController progressController;
  private final SplitFareRequest splitFareRequest;
  private final ISplitFareService splitFareService;
  TextView splitPaymentFee;
  TextView splitPaymentLabel;
  ImageView userImage;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public SplitPaymentRequestController(IConstantsProvider paramIConstantsProvider, IViewErrorHandler paramIViewErrorHandler, ImageLoader paramImageLoader, AppFlow paramAppFlow, DialogFlow paramDialogFlow, IProgressController paramIProgressController, IChargeAccountsProvider paramIChargeAccountsProvider, ISplitFareService paramISplitFareService, ISplitFareRequestRepository paramISplitFareRequestRepository)
  {
    constantsProvider = paramIConstantsProvider;
    viewErrorHandler = paramIViewErrorHandler;
    imageLoader = paramImageLoader;
    appFlow = paramAppFlow;
    dialogFlow = paramDialogFlow;
    progressController = paramIProgressController;
    chargeAccountsProvider = paramIChargeAccountsProvider;
    splitFareService = paramISplitFareService;
    splitFareRequest = paramISplitFareRequestRepository.getPendingSplitFareRequest();
  }
  
  private void respondSplitFareRequest(String paramString, boolean paramBoolean, Action0 paramAction0)
  {
    progressController.disableUI();
    binder.bindAsyncCall(splitFareService.acceptDeclineRequest(paramString, paramBoolean), new SplitPaymentRequestController.3(this, paramAction0));
  }
  
  public Dialogs.AlertDialog createInactiveSplitDialog()
  {
    return new Dialogs.AlertDialog("cannot_split_after_ride_dialog").addPositiveButton(getResources().getString(2131165939)).setMessage(getResources().getString(2131165778)).setTitle(getResources().getString(2131165779)).setTitleColorResource(2131492898);
  }
  
  protected int layoutId()
  {
    return 2130903462;
  }
  
  void onAcceptClicked()
  {
    if (!chargeAccountsProvider.hasValidChargeAccount())
    {
      appFlow.goTo(new SplitScreens.SplitPaymentAddChargeAccountScreen());
      return;
    }
    respondSplitFareRequest(splitFareRequest.getId(), true, new SplitPaymentRequestController.1(this));
  }
  
  public void onAttach()
  {
    super.onAttach();
    splitPaymentLabel.setText(getResources().getString(2131166342, new Object[] { splitFareRequest.getInitiatorName() }));
    splitPaymentFee.setText((CharSequence)constantsProvider.get(Constants.SPLIT_PAYMENT_FEE_TEXT, getResources().getString(2131165542)));
    imageLoader.load(splitFareRequest.getInitiatorPhoto()).fit().centerCrop().placeholder(2130838447).error(2130838447).into(userImage);
    if (dialogFlow.hasActiveDialog()) {
      dialogFlow.dismiss();
    }
  }
  
  public boolean onBack()
  {
    return true;
  }
  
  void onDeclineClicked()
  {
    respondSplitFareRequest(splitFareRequest.getId(), false, new SplitPaymentRequestController.2(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.splitfare.SplitPaymentRequestController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */