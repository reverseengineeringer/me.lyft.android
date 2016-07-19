package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.ColorStateList;
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
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.ui.UserImageView;
import me.lyft.android.ui.dialogs.DialogContainerView;
import me.lyft.android.ui.tooltips.TooltipContainerView;

public class RideArrivalConfirmationDialogView
  extends DialogContainerView
{
  @Inject
  MessageBus bus;
  Button confirmButton;
  @Inject
  DialogFlow dialogFlow;
  UserImageView passengerPhoto;
  TextView primaryMessage;
  @Inject
  IDriverRideProvider routeProvider;
  TextView secondaryMessage;
  TooltipContainerView tooltipContainer;
  
  public RideArrivalConfirmationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private int getConfirmButtonBackground()
  {
    if (routeProvider.getDriverRide().isCourier()) {
      return 2130837606;
    }
    return 2130837586;
  }
  
  private String getPrimaryMessage()
  {
    String str = routeProvider.getDriverRide().getCurrentStop().getLocation().getDisplayName();
    if (Strings.isNullOrEmpty(str)) {
      return getResources().getString(2131165750);
    }
    return getResources().getString(2131165749, new Object[] { str });
  }
  
  private String getSecondaryMessage()
  {
    String str = routeProvider.getDriverRide().getCurrentPassenger().getFirstName();
    if (Strings.isNullOrEmpty(str)) {
      return getResources().getString(2131165483);
    }
    return getResources().getString(2131165482, new Object[] { str });
  }
  
  private ColorStateList getTextColor()
  {
    Resources localResources = getResources();
    if (routeProvider.getDriverRide().isCourier()) {}
    for (int i = 2131493014;; i = 2131492875) {
      return localResources.getColorStateList(i);
    }
  }
  
  private void initialize()
  {
    primaryMessage.setText(getPrimaryMessage());
    if (routeProvider.getDriverRide().isCourier())
    {
      secondaryMessage.setText(getSecondaryMessage());
      secondaryMessage.setVisibility(0);
    }
    confirmButton.setVisibility(0);
    confirmButton.setText(2131165457);
    confirmButton.setOnClickListener(new RideArrivalConfirmationDialogView.1(this));
    if (routeProvider.getDriverRide().showHints()) {
      tooltipContainer.tryToShowAndMarkShown("confirm_arrival_button", confirmButton, 80);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    initialize();
    DriverRidePassenger localDriverRidePassenger = routeProvider.getDriverRide().getCurrentPassenger();
    passengerPhoto.setUserPartySize(Integer.valueOf(localDriverRidePassenger.getPartySize()));
    passengerPhoto.loadPhoto(localDriverRidePassenger.getPhotoUrl());
    confirmButton.setBackgroundResource(getConfirmButtonBackground());
    confirmButton.setTextColor(getTextColor());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.RideArrivalConfirmationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */