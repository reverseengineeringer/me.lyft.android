package me.lyft.android.ui.driver;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.UserImageView;
import me.lyft.android.ui.dialogs.DialogContainerView;
import rx.functions.Action1;

public class SkipPassengerDialogView
  extends DialogContainerView
{
  @Inject
  MessageBus bus;
  @Inject
  DialogFlow dialogFlow;
  Button dismissButton;
  private Action1<DriverRide> onRouteUpdated = new SkipPassengerDialogView.3(this);
  private Integer partySize;
  private final DriverRidePassenger passenger;
  @Inject
  IDriverRideProvider routeProvider;
  TextView secondaryMessageTextView;
  Button skipPassengerButton;
  private DriverStop stop;
  UserImageView userImageView;
  
  public SkipPassengerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    paramContext = (DriverDialogs.SkipPassengerDialog)Screen.fromView(this);
    passenger = paramContext.getPassenger();
    partySize = paramContext.getPartySize();
  }
  
  private void confirmSkip()
  {
    bus.post(SkipPassengerDialogView.PassengerSkipResultEvent.class, partySize);
    dialogFlow.dismiss();
  }
  
  private void displaySkipConfirmation()
  {
    secondaryMessageTextView.setText(getContext().getString(2131166329, new Object[] { partySize, passenger.getFirstName() }));
    userImageView.loadPhoto(passenger.getPhotoUrl());
    userImageView.setUserPartySize(partySize);
    skipPassengerButton.setText(getContext().getString(2131166327, new Object[] { passenger.getFirstName() }));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    Binder localBinder = Binder.attach(this);
    stop = routeProvider.getDriverRide().getCurrentStop();
    localBinder.bind(routeProvider.observeRide(), onRouteUpdated);
    dismissButton.setOnClickListener(new SkipPassengerDialogView.1(this));
    skipPassengerButton.setOnClickListener(new SkipPassengerDialogView.2(this));
    displaySkipConfirmation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.SkipPassengerDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */