package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.RideFlags;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.dialogs.DialogContainerView;
import rx.functions.Action1;

public class NoShowConfirmationDialogView
  extends DialogContainerView
{
  @Inject
  MessageBus bus;
  @Inject
  DialogFlow dialogFlow;
  Button dismissButton;
  @Inject
  ILyftPreferences lyftPreferences;
  private Action1<DriverRide> onRouteUpdated = new NoShowConfirmationDialogView.3(this);
  TextView passengerNameTextView;
  Button passengerNoShowButton;
  ImageView passengerNoShowImage;
  @Inject
  IDriverRideProvider routeProvider;
  private DriverStop stop;
  
  public NoShowConfirmationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void displayNoShowConfirmation()
  {
    passengerNoShowImage.setVisibility(0);
    passengerNameTextView.setText(getResources().getString(2131165468, new Object[] { routeProvider.getDriverRide().getCurrentPassenger().getFirstName() }));
    passengerNoShowButton.setVisibility(0);
    passengerNoShowButton.setOnClickListener(new NoShowConfirmationDialogView.1(this));
    dismissButton.setOnClickListener(new NoShowConfirmationDialogView.2(this));
  }
  
  private void passengerNoShow()
  {
    RideFlags localRideFlags = lyftPreferences.getRideFlags();
    localRideFlags.setPickupConfirmationDialogShown(true);
    lyftPreferences.setRideFlags(localRideFlags);
    bus.post(NoShowConfirmationDialogView.NoShowConfirmationResultEvent.class, Unit.create());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    stop = routeProvider.getDriverRide().getCurrentStop();
    displayNoShowConfirmation();
    Binder.attach(this).bind(routeProvider.observeRide(), onRouteUpdated);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.NoShowConfirmationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */