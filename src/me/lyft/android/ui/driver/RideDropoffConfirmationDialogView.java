package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
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
import me.lyft.android.ui.tooltips.TooltipContainerView;
import rx.functions.Action1;

public class RideDropoffConfirmationDialogView
  extends DialogContainerView
{
  @Inject
  MessageBus bus;
  Button confirmDropoffButton;
  @Inject
  DialogFlow dialogFlow;
  Button dismissButton;
  private Action1<DriverRide> onRouteUpdated = new RideDropoffConfirmationDialogView.3(this);
  UserImageView passengerPhoto;
  TextView primaryMessage;
  @Inject
  IDriverRideProvider routeProvider;
  private DriverStop stop;
  TooltipContainerView tooltipContainer;
  
  public RideDropoffConfirmationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void showTooltips()
  {
    if (!routeProvider.getDriverRide().showHints()) {
      return;
    }
    tooltipContainer.tryToShowAndMarkShown("confirm_drop_off", confirmDropoffButton, 80);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    stop = routeProvider.getDriverRide().getCurrentStop();
    DriverRidePassenger localDriverRidePassenger = routeProvider.getDriverRide().getCurrentPassenger();
    Resources localResources = getResources();
    passengerPhoto.setUserPartySize(Integer.valueOf(localDriverRidePassenger.getPartySize()));
    passengerPhoto.loadPhoto(localDriverRidePassenger.getPhotoUrl());
    confirmDropoffButton.setBackgroundResource(2130837611);
    confirmDropoffButton.setTextColor(localResources.getColorStateList(2131493093));
    dismissButton.setOnClickListener(new RideDropoffConfirmationDialogView.1(this));
    primaryMessage.setText(localResources.getString(2131165569, new Object[] { localDriverRidePassenger.getFirstName() }));
    confirmDropoffButton.setVisibility(0);
    confirmDropoffButton.setText(2131165459);
    confirmDropoffButton.setOnClickListener(new RideDropoffConfirmationDialogView.2(this));
    Binder.attach(this).bind(routeProvider.observeRide(), onRouteUpdated);
    showTooltips();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.RideDropoffConfirmationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */