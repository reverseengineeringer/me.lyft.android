package me.lyft.android.ui.passenger.v2.request.confirm;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.tooltip.ITooltipService;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.PassengerToolbar;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.time.Time;
import me.lyft.android.domain.tooltips.Tooltip;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.tooltips.TooltipContainerView;
import me.lyft.android.utils.DrawableUtils;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

public class ConfirmPickupAndDestinationView
  extends RelativeLayout
  implements HandleBack, ConfirmPresenter.ConfirmView, RequestRideButtonPresenter.RequestRideButton
{
  ImageButton backButton;
  ImageButton centerToCurrentLocationButton;
  final PublishSubject<Unit> centerToCurrentLocationClickSubject = PublishSubject.create();
  @Inject
  ConfirmPresenter confirmPresenter;
  Button confirmRideButton;
  ProgressBar confirmingRideProgressBar;
  HeightObservableLayout containerBottom;
  final PublishSubject<Unit> destinationAddressClickSubject = PublishSubject.create();
  TextView destinationAddressField;
  @Inject
  IFeaturesProvider featuresProvider;
  final PublishSubject<Unit> onBackButtonClickSubject = PublishSubject.create();
  final PublishSubject<Unit> pickupAddressClickSubject = PublishSubject.create();
  TextView pickupAddressField;
  View pickupAddressFieldTapArea;
  @Inject
  RequestRideButtonPresenter requestRideButtonController;
  @Inject
  IRideRequestSession rideRequestSession;
  PassengerToolbar toolbar;
  TooltipContainerView tooltipContainer;
  @Inject
  ITooltipService tooltipService;
  
  public ConfirmPickupAndDestinationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void showRideTypeTooltipIfNeeded()
  {
    ExperimentAnalytics.trackExposure(Experiment.GR_RIDE_TYPE_HINT);
    if (featuresProvider.isEnabled(Features.RIDE_TYPE_TOOLTIP_ENABLED))
    {
      Tooltip localTooltip = tooltipService.getTooltip("ride_type_tip");
      if (!localTooltip.isNull()) {
        tooltipContainer.tryToShowAndMarkShown(localTooltip, findViewById(2131559683), 48);
      }
    }
  }
  
  public String getDestinationMarkerLabel()
  {
    return getContext().getString(2131165663);
  }
  
  public String getPickupMarkerLabel(Time paramTime)
  {
    return getContext().getString(2131166136, new Object[] { paramTime.formatDay() });
  }
  
  public String getRequestButtonText()
  {
    return confirmRideButton.getText().toString();
  }
  
  public String getScheduledButtonLabel(RequestRideType paramRequestRideType)
  {
    if (paramRequestRideType.isPlus()) {
      return getResources().getString(2131166016);
    }
    if (paramRequestRideType.isCourier()) {
      return getResources().getString(2131166015);
    }
    if (paramRequestRideType.isStandard()) {
      return getResources().getString(2131166017);
    }
    return "";
  }
  
  public void hideDriverModeToggle()
  {
    toolbar.hideDriverModeToggle();
  }
  
  public Observable<Unit> observeBackButtonClick()
  {
    return onBackButtonClickSubject.asObservable();
  }
  
  public Observable<Integer> observeBottomContainerHeight()
  {
    return containerBottom.observeHeightChange();
  }
  
  public Observable<Unit> observeCenterToCurrentLocationClick()
  {
    return centerToCurrentLocationClickSubject.asObservable();
  }
  
  public Observable<Unit> observeDestinationAddressClick()
  {
    return destinationAddressClickSubject.asObservable();
  }
  
  public Observable<Unit> observePickupAddressFieldClick()
  {
    return pickupAddressClickSubject.asObservable();
  }
  
  public Observable<Integer> observeTopContainerHeight()
  {
    return BehaviorSubject.create(Integer.valueOf(getResources().getDimensionPixelSize(2131230823)));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    Binder.attach(this).bind(rideRequestSession.observeForceDestination(), new ConfirmPickupAndDestinationView.6(this));
    confirmPresenter.attachView(this);
    requestRideButtonController.attachView(this);
    showRideTypeTooltipIfNeeded();
  }
  
  public boolean onBack()
  {
    onBackButtonClickSubject.onNext(Unit.create());
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    requestRideButtonController.detachView(this);
    confirmPresenter.detachView(this);
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    confirmRideButton.setOnClickListener(new ConfirmPickupAndDestinationView.1(this));
    centerToCurrentLocationButton.setOnClickListener(new ConfirmPickupAndDestinationView.2(this));
    pickupAddressFieldTapArea.setOnClickListener(new ConfirmPickupAndDestinationView.3(this));
    destinationAddressField.setOnClickListener(new ConfirmPickupAndDestinationView.4(this));
    backButton.setOnClickListener(new ConfirmPickupAndDestinationView.5(this));
  }
  
  public void resetDestinationAddress()
  {
    destinationAddressField.setText(getResources().getString(2131165969));
  }
  
  public void setDestinationAddress(String paramString)
  {
    destinationAddressField.setText(paramString);
  }
  
  public void setDestinationAddressLoading()
  {
    destinationAddressField.setText(getResources().getString(2131166019));
  }
  
  public void setDestinationAddressUnavailable()
  {
    destinationAddressField.setText(getResources().getString(2131165292));
  }
  
  public void setPickupAddress(String paramString)
  {
    pickupAddressField.setText(paramString);
  }
  
  public void setPickupAddressLoading()
  {
    pickupAddressField.setText(getResources().getString(2131166019));
  }
  
  public void setPickupAddressUnavailable()
  {
    pickupAddressField.setText(getResources().getString(2131165292));
  }
  
  public void setRequestButtonBackground(String paramString1, String paramString2)
  {
    paramString1 = DrawableUtils.getButtonDrawableForHexColors(getContext(), paramString1, paramString2, getResources().getDimensionPixelSize(2131230838));
    confirmRideButton.setBackgroundDrawable(paramString1);
  }
  
  public void setRequestButtonText(String paramString)
  {
    confirmRideButton.setText(paramString);
  }
  
  public void showDriverModeToggle()
  {
    toolbar.showDriverModeToggle();
  }
  
  public void showRequestProgressBar(boolean paramBoolean)
  {
    ProgressBar localProgressBar = confirmingRideProgressBar;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.confirm.ConfirmPickupAndDestinationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */