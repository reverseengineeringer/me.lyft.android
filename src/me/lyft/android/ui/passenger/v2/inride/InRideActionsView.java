package me.lyft.android.ui.passenger.v2.inride;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.domain.splitfare.SplitFareState;
import me.lyft.android.infrastructure.share.IShareService;
import me.lyft.android.persistence.splitfare.ISplitFareStateRepository;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import rx.functions.Action1;

public class InRideActionsView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  InRideActionItem cancelRideButton;
  InRideActionItem contactDriverButton;
  @Inject
  DialogFlow dialogFlow;
  private final Action1<Unit> onRideUpdate = new InRideActionsView.5(this);
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  IPassengerRideService passengerRideService;
  @Inject
  IProgressController progressController;
  @Inject
  IRideTypeMetaService rideTypeMetaService;
  InRideActionItem shareRouteButton;
  @Inject
  IShareService smsService;
  InRideActionItem splitFareButton;
  @Inject
  ISplitFareStateRepository splitFareStateRepository;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public InRideActionsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903317, this, true);
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  private void shareRoute()
  {
    progressController.showProgress();
    progressController.disableUI();
    binder.bind(passengerRideService.shareRoute(), new InRideActionsView.6(this));
  }
  
  private void updateActionItems()
  {
    int j = 8;
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    int i;
    if (localPassengerRide.hasFeatures())
    {
      setVisibility(0);
      Object localObject = cancelRideButton;
      if (localPassengerRide.isFeatureEnabled(RideFeature.PASSENGER_CANCEL))
      {
        i = 0;
        ((InRideActionItem)localObject).setVisibility(i);
        localObject = splitFareButton;
        if (!localPassengerRide.isFeatureEnabled(RideFeature.SPLIT_PAY)) {
          break label187;
        }
        i = 0;
        label67:
        ((InRideActionItem)localObject).setVisibility(i);
        localObject = localPassengerRide.getStatus();
        if ((!localPassengerRide.isRealTimeMatching()) && (!((RideStatus)localObject).isPickedUp()) && (!((RideStatus)localObject).isArrived()) && (!((RideStatus)localObject).isAccepted())) {
          break label193;
        }
        i = 1;
        label112:
        localObject = shareRouteButton;
        if ((!localPassengerRide.isFeatureEnabled(RideFeature.SHARE_ROUTE)) || (i == 0)) {
          break label198;
        }
        i = 0;
        label134:
        ((InRideActionItem)localObject).setVisibility(i);
        localObject = contactDriverButton;
        if (!localPassengerRide.isFeatureEnabled(RideFeature.CALL_DRIVER))
        {
          i = j;
          if (!localPassengerRide.isFeatureEnabled(RideFeature.SMS_DRIVER)) {}
        }
        else
        {
          i = 0;
        }
        ((InRideActionItem)localObject).setVisibility(i);
      }
    }
    for (;;)
    {
      updateSplitFareButton();
      return;
      i = 8;
      break;
      label187:
      i = 8;
      break label67;
      label193:
      i = 0;
      break label112;
      label198:
      i = 8;
      break label134;
      setVisibility(8);
    }
  }
  
  private void updateSplitFareButton()
  {
    Object localObject = splitFareStateRepository.getSplitFareState();
    int j = rideTypeMetaService.getMaximumContributorsForRideType(passengerRideProvider.getPassengerRide().getRideType().getType());
    int k = ((SplitFareState)localObject).getInvitedContributorsCount();
    int m = ((SplitFareState)localObject).getAcceptedContributorsCount();
    int i;
    if (k >= j)
    {
      i = 1;
      localObject = splitFareButton;
      if ((j <= 0) || (i != 0)) {
        break label125;
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      ((InRideActionItem)localObject).setEnabled(bool);
      if (k <= 0) {
        break label131;
      }
      splitFareButton.setTitle(getResources().getString(2131166345, new Object[] { Integer.valueOf(m), Integer.valueOf(k) }));
      return;
      i = 0;
      break;
    }
    label131:
    splitFareButton.setTitle(getResources().getString(2131166344));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    binder.bind(passengerRideProvider.observeRideUpdateEvent(), onRideUpdate);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    contactDriverButton.setOnClickListener(new InRideActionsView.1(this));
    splitFareButton.setOnClickListener(new InRideActionsView.2(this));
    shareRouteButton.setOnClickListener(new InRideActionsView.3(this));
    cancelRideButton.setOnClickListener(new InRideActionsView.4(this));
    contactDriverButton.setIconId(2130838304);
    splitFareButton.setIconId(2130838355);
    shareRouteButton.setIconId(2130838343);
    cancelRideButton.setIconId(2130838160);
    contactDriverButton.setTitle(getResources().getString(2131165354));
    shareRouteButton.setTitle(getResources().getString(2131166323));
    cancelRideButton.setTitle(getResources().getString(2131165361));
    updateSplitFareButton();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.InRideActionsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */