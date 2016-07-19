package me.lyft.android.ui.passenger;

import android.text.Html;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lyft.scoop.Scoop;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.PassengerAnalytics;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.ride.ICancellationOptionsProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import rx.functions.Action1;

public class PassengerCancelRideDialogViewController
  extends RxViewController
{
  LinearLayout cancellationOptionsContainer;
  private final ICancellationOptionsProvider cancellationOptionsProvider;
  private final IConstantsProvider constantsProvider;
  private int currentCancelPenalty = -1;
  private RideStatus currentRideStatus;
  private final DialogFlow dialogFlow;
  Button doNotCancelButton;
  TextView multiOptionsMessageTextView;
  private Action1<Unit> onCancellationOptionsChanged = new PassengerCancelRideDialogViewController.4(this);
  private Action1<Unit> onPassengerRideUpdated = new PassengerCancelRideDialogViewController.3(this);
  private final IPassengerRideProvider passengerRideProvider;
  private final IPassengerRideService passengerRideService;
  TextView penaltyDetailTextView;
  TextView penaltyMessageTextView;
  private final IProgressController progressController;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public PassengerCancelRideDialogViewController(IConstantsProvider paramIConstantsProvider, DialogFlow paramDialogFlow, IProgressController paramIProgressController, IViewErrorHandler paramIViewErrorHandler, IPassengerRideService paramIPassengerRideService, IPassengerRideProvider paramIPassengerRideProvider, ICancellationOptionsProvider paramICancellationOptionsProvider)
  {
    constantsProvider = paramIConstantsProvider;
    dialogFlow = paramDialogFlow;
    progressController = paramIProgressController;
    viewErrorHandler = paramIViewErrorHandler;
    passengerRideService = paramIPassengerRideService;
    passengerRideProvider = paramIPassengerRideProvider;
    cancellationOptionsProvider = paramICancellationOptionsProvider;
  }
  
  private void cancelRide(CancellationOption paramCancellationOption)
  {
    progressController.disableUI();
    binder.bindAsyncCall(passengerRideService.cancelRide(paramCancellationOption, currentCancelPenalty), new PassengerCancelRideDialogViewController.5(this));
  }
  
  private void createCancellationOptions()
  {
    cancellationOptionsContainer.removeAllViews();
    Iterator localIterator = cancellationOptionsProvider.getCancellationOptions().iterator();
    while (localIterator.hasNext())
    {
      CancellationOption localCancellationOption = (CancellationOption)localIterator.next();
      Button localButton = (Button)Scoop.fromView(getView()).inflate(2130903161, cancellationOptionsContainer, false);
      localButton.setText(localCancellationOption.getString());
      localButton.setOnClickListener(new PassengerCancelRideDialogViewController.2(this, localCancellationOption));
      cancellationOptionsContainer.addView(localButton);
    }
  }
  
  private String getPenaltyMessageText()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    String str1 = (String)constantsProvider.get(Constants.CANCEL_SUBTITLE_TEXT_CHARGE);
    if (localPassengerRide.getStatus().isPending()) {
      str1 = (String)constantsProvider.get(Constants.CANCEL_SUBTITLE_TEXT_UNASSIGNED);
    }
    for (;;)
    {
      String str2 = (String)constantsProvider.get(Constants.CANCEL_DETAIL_TEXT_CHARGE);
      if ((localPassengerRide.getCancelPenalty() == 0) || (Strings.isNullOrEmpty(str2))) {
        break;
      }
      penaltyDetailTextView.setText(str2);
      penaltyDetailTextView.setVisibility(0);
      return str1;
      if (localPassengerRide.getCancelPenalty() == 0) {
        str1 = Strings.nullToEmpty(localPassengerRide.getCancelSubtitleText());
      } else if (!Strings.isNullOrEmpty(str1)) {
        str1 = MessageFormat.format(str1, new Object[] { Integer.valueOf(localPassengerRide.getCancelPenalty()) });
      } else {
        str1 = "";
      }
    }
    penaltyDetailTextView.setVisibility(8);
    return str1;
  }
  
  private void updateImprovementsMessageText()
  {
    String str = (String)constantsProvider.get(Constants.CANCEL_SUBTITLE_MULTIPLE_OPTIONS);
    if ((Strings.isNullOrEmpty(str)) || (cancellationOptionsProvider.getCancellationOptions().isEmpty()))
    {
      multiOptionsMessageTextView.setVisibility(8);
      return;
    }
    multiOptionsMessageTextView.setText(str);
    multiOptionsMessageTextView.setVisibility(0);
  }
  
  private void updatePenaltyMessageText()
  {
    Object localObject = Integer.valueOf(passengerRideProvider.getPassengerRide().getCancelPenalty());
    if (((Integer)localObject).intValue() == currentCancelPenalty) {
      return;
    }
    currentCancelPenalty = ((Integer)localObject).intValue();
    localObject = getPenaltyMessageText();
    if (!Strings.isNullOrEmpty((String)localObject))
    {
      penaltyMessageTextView.setText(Html.fromHtml((String)localObject));
      penaltyMessageTextView.setVisibility(0);
      return;
    }
    penaltyMessageTextView.setVisibility(8);
  }
  
  protected int layoutId()
  {
    return 2130903309;
  }
  
  public void onAttach()
  {
    super.onAttach();
    PassengerAnalytics.trackCancellationShown();
    currentRideStatus = passengerRideProvider.getPassengerRide().getStatus();
    createCancellationOptions();
    doNotCancelButton.setOnClickListener(new PassengerCancelRideDialogViewController.1(this));
    binder.bindAction(passengerRideProvider.observeRideUpdateEvent(), onPassengerRideUpdated);
    binder.bindAction(cancellationOptionsProvider.observeCancellationOptionChange(), onCancellationOptionsChanged);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerCancelRideDialogViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */