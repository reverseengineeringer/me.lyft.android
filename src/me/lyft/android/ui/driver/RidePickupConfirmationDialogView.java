package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.rx.ReactiveUI;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.RideFlags;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.ui.dialogs.DialogContainerView;
import rx.functions.Action1;

public class RidePickupConfirmationDialogView
  extends DialogContainerView
{
  private static final int ONE_PERSON_PARTY_SIZE = 1;
  private static final int THREE_PEOPLE_PARTY_SIZE = 3;
  private static final int TWO_PEOPLE_PARTY_SIZE = 2;
  @Inject
  MessageBus bus;
  Button confirmOnePersonButton;
  Button confirmThreePeopleButton;
  Button confirmTwoPeopleButton;
  @Inject
  DialogFlow dialogFlow;
  Button dismissButton;
  @Inject
  ILyftPreferences lyftPreferences;
  private Action1<DriverRide> onRouteUpdated = new RidePickupConfirmationDialogView.6(this);
  private DriverRidePassenger passenger;
  TextView primaryMessage;
  @Inject
  IDriverRideProvider routeProvider;
  private ReactiveProperty<Boolean> samePassengerArrived = ReactiveProperty.create();
  
  public RidePickupConfirmationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    passenger = ((DriverDialogs.RidePickupConfirmationDialog)Screen.fromView(this)).getPassenger();
  }
  
  private void confirmPickup(int paramInt)
  {
    RideFlags localRideFlags = lyftPreferences.getRideFlags();
    localRideFlags.setPickupConfirmationDialogShown(true);
    lyftPreferences.setRideFlags(localRideFlags);
    bus.post(RidePickupConfirmationDialogView.RidePickupConfirmationResultEvent.class, Integer.valueOf(paramInt));
  }
  
  private void displayPickupConfirmation()
  {
    primaryMessage.setText(getResources().getString(2131165469, new Object[] { passenger.getFirstName() }));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    Binder localBinder = Binder.attach(this);
    localBinder.bind(routeProvider.observeRide(), onRouteUpdated);
    localBinder.bind(ReactiveUI.isFalse(samePassengerArrived), new RidePickupConfirmationDialogView.1(this));
    dismissButton.setOnClickListener(new RidePickupConfirmationDialogView.2(this));
    confirmOnePersonButton.setOnClickListener(new RidePickupConfirmationDialogView.3(this));
    confirmTwoPeopleButton.setOnClickListener(new RidePickupConfirmationDialogView.4(this));
    confirmThreePeopleButton.setOnClickListener(new RidePickupConfirmationDialogView.5(this));
    displayPickupConfirmation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.RidePickupConfirmationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */