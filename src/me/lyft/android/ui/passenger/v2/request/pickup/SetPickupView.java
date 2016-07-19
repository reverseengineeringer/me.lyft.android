package me.lyft.android.ui.passenger.v2.request.pickup;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.jakewharton.rxrelay.PublishRelay;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.PassengerToolbar;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.HeightObservableLayout;
import rx.Observable;

public class SetPickupView
  extends RelativeLayout
  implements HandleBack, SetPickupPresenter.PickupView
{
  RideTypePickupAddressView addressView;
  @Inject
  IAssetLoadingService assetLoadingService;
  private Binder binder;
  ImageButton centerToCurrentLocationButton;
  private final PublishRelay<Unit> centerToCurrentLocationClickSubject = PublishRelay.create();
  HeightObservableLayout containerBottom;
  HeightObservableLayout containerTop;
  private final PublishRelay<Unit> inviteFriendsToolbarItemClickSubject = PublishRelay.create();
  private final PublishRelay<Unit> pickupAddressFieldClickSubject = PublishRelay.create();
  private final PublishRelay<Unit> pickupButtonClickSubject = PublishRelay.create();
  PickupEtaPin pickupEtaPin;
  @Inject
  PickupPinPresenter pickupPinPresenter;
  private final PublishRelay<RequestRideType> rideTypeSelectionSubject = PublishRelay.create();
  RideTypeSelectionView rideTypeSelectionView;
  private final PublishRelay<Unit> rideTypeSelectorButtonSubject = PublishRelay.create();
  private final PublishRelay<Unit> scheduledRidesDismissToolbarItemSubject = PublishRelay.create();
  ScheduledRidesPicker scheduledRidesPicker;
  private final PublishRelay<Unit> scheduledRidesToolbarItemSubject = PublishRelay.create();
  Button setPickupButton;
  @Inject
  SetPickupPresenter setPickupPresenter;
  PassengerToolbar toolbar;
  
  public SetPickupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void updateAddressView(RequestRideType paramRequestRideType)
  {
    binder.bind(assetLoadingService.loadMarkerBitmap(paramRequestRideType.getIcon()), new SetPickupView.8(this));
    int i = getResources().getColor(2131492990);
    int j = getResources().getColor(2131492989);
    addressView.setRingColor(i, j);
    addressView.setRideTypeSelectorLabel(paramRequestRideType.getShortTitle());
  }
  
  public void hideRideTypeButton()
  {
    addressView.hideRideTypeButton();
  }
  
  public void hideRideTypeSwitcherView()
  {
    rideTypeSelectionView.setVisibility(8);
  }
  
  public void hideScheduledRides()
  {
    scheduledRidesPicker.setVisibility(8);
  }
  
  public boolean isRideTypeSelectorShowing()
  {
    return rideTypeSelectionView.getVisibility() == 0;
  }
  
  public Observable<Integer> observeBottomContainerHeight()
  {
    return containerBottom.observeHeightChange();
  }
  
  public Observable<Unit> observeCenterToCurrentLocationClick()
  {
    return centerToCurrentLocationClickSubject.asObservable();
  }
  
  public Observable<Unit> observeDismissScheduledRidesToolbarItemClick()
  {
    return scheduledRidesDismissToolbarItemSubject.asObservable();
  }
  
  public Observable<Unit> observeInviteFriendsToolbarItemClick()
  {
    return inviteFriendsToolbarItemClickSubject.asObservable();
  }
  
  public Observable<Unit> observePickupAddressFieldClick()
  {
    return pickupAddressFieldClickSubject.asObservable();
  }
  
  public Observable<Unit> observePickupButtonClick()
  {
    return pickupButtonClickSubject.asObservable();
  }
  
  public Observable<RequestRideType> observeRideTypeSelectionChanged()
  {
    return rideTypeSelectionSubject.asObservable();
  }
  
  public Observable<Unit> observeRideTypeSelectorButtonClick()
  {
    return rideTypeSelectorButtonSubject.asObservable();
  }
  
  public Observable<Unit> observeScheduledRidesToolbarItemClick()
  {
    return scheduledRidesToolbarItemSubject.asObservable();
  }
  
  public Observable<Integer> observeTopContainerHeight()
  {
    return containerTop.observeHeightChange();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    setPickupPresenter.attachView(this);
    pickupPinPresenter.attachView(pickupEtaPin);
  }
  
  public boolean onBack()
  {
    return setPickupPresenter.onBack();
  }
  
  protected void onDetachedFromWindow()
  {
    pickupPinPresenter.detachView(pickupEtaPin);
    setPickupPresenter.detachView(this);
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    toolbar.setOnItemClickAction(new SetPickupView.1(this));
    setPickupButton.setOnClickListener(new SetPickupView.2(this));
    addressView.setPickupAddressFieldClickListener(new SetPickupView.3(this));
    centerToCurrentLocationButton.setOnClickListener(new SetPickupView.4(this));
    rideTypeSelectionView.setOnSelectionChanged(new SetPickupView.5(this));
    addressView.setHideSelectionButtonClickListener(new SetPickupView.6(this));
    addressView.setRideTypeSelectorButtonClickListener(new SetPickupView.7(this));
  }
  
  public void setPickupAddress(String paramString)
  {
    addressView.setPickupAddressText(paramString);
  }
  
  public void setPickupAddressLoading()
  {
    addressView.setPickupAddressText(getResources().getString(2131166019));
  }
  
  public void setPickupAddressUnavailable()
  {
    addressView.setPickupAddressText(getResources().getString(2131165292));
  }
  
  public void setRegionUnavailable()
  {
    hideRideTypeSwitcherView();
    addressView.hideRideTypeSelectionViews();
  }
  
  public void setRideType(RequestRideType paramRequestRideType)
  {
    rideTypeSelectionView.selectRideType(paramRequestRideType);
    updateAddressView(paramRequestRideType);
  }
  
  public void setRideTypeSwitcherItems(List<RequestRideType> paramList)
  {
    rideTypeSelectionView.setRideTypes(paramList);
  }
  
  public void showDismissScheduledRidesToolbarItem(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      toolbar.setSecondaryItem(2131558454, 2130838394);
      return;
    }
    toolbar.removeToolbarItem(2131558454);
  }
  
  public void showDriverModeToggle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      toolbar.showDriverModeToggle();
      return;
    }
    toolbar.hideDriverModeToggle();
  }
  
  public void showInviteFriendsToolbarItem(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      toolbar.setSecondaryItem(2131558440, 2130838237);
      return;
    }
    toolbar.removeToolbarItem(2131558440);
  }
  
  public void showRideTypeButton()
  {
    addressView.showRideTypeButton();
  }
  
  public void showRideTypeSwitcherView()
  {
    rideTypeSelectionView.setVisibility(0);
    addressView.hideRideTypeButton();
  }
  
  public void showRideTypesLoading()
  {
    hideRideTypeSwitcherView();
    addressView.hideRideTypeSelectionViews();
    addressView.displayLoading();
  }
  
  public void showScheduledRides()
  {
    scheduledRidesPicker.setVisibility(0);
  }
  
  public void showScheduledRidesToolbarItem(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      toolbar.showScheduledRidesButton();
      return;
    }
    toolbar.hideScheduledRidesButton();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.pickup.SetPickupView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */