package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.UserImageView;
import me.lyft.android.ui.dialogs.DialogContainerView;
import rx.functions.Action1;

public class DriverEndRideConfirmationDialogView
  extends DialogContainerView
{
  private Binder binder;
  Button closeDialogButton;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  DialogFlow dialogFlow;
  Button notPickedUpButton;
  private Action1<DriverRide> onRouteUpdated = new DriverEndRideConfirmationDialogView.4(this);
  Button pickedUpButton;
  @Inject
  IDriverRideProvider routeProvider;
  private final DriverStop stop;
  TextView titleTextView;
  UserImageView userImageView;
  
  public DriverEndRideConfirmationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    stop = routeProvider.getDriverRide().getCurrentStop();
  }
  
  private void initView()
  {
    Object localObject = getResources();
    titleTextView.setText((CharSequence)constantsProvider.get(Constants.END_RIDE_CONFIRMATION_TITLE, ((Resources)localObject).getString(2131165596)));
    pickedUpButton.setText((CharSequence)constantsProvider.get(Constants.END_RIDE_CONFIRMATION_PASSENGER_PICKED_UP_BUTTON, ((Resources)localObject).getString(2131165598)));
    notPickedUpButton.setText((CharSequence)constantsProvider.get(Constants.END_RIDE_CONFIRMATION_PASSENGER_NOT_PICKED_UP_BUTTON, ((Resources)localObject).getString(2131165597)));
    closeDialogButton.setText((CharSequence)constantsProvider.get(Constants.END_RIDE_CONFIRMATION_CANCEL_BUTTON, ((Resources)localObject).getString(2131165595)));
    localObject = routeProvider.getDriverRide().getCurrentPassenger();
    userImageView.loadPhoto(((DriverRidePassenger)localObject).getPhotoUrl());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(routeProvider.observeRide(), onRouteUpdated);
    initView();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    pickedUpButton.setOnClickListener(new DriverEndRideConfirmationDialogView.1(this));
    notPickedUpButton.setOnClickListener(new DriverEndRideConfirmationDialogView.2(this));
    closeDialogButton.setOnClickListener(new DriverEndRideConfirmationDialogView.3(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverEndRideConfirmationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */