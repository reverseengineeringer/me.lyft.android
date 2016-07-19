package me.lyft.android.ui.passenger.v2.inride;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRidePassenger;
import me.lyft.android.ui.passenger.v2.PickupAndDestinationAddressView;

public class RideFooterView
  extends LinearLayout
{
  TextView bannerTextView;
  @Inject
  PassengerAddressActions passengerAddressActions;
  PickupAndDestinationAddressView pickupAndDestinationAddressView;
  RideDetailView rideDetailView;
  
  public RideFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903250, this, true);
    ButterKnife.bind(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    pickupAndDestinationAddressView.setPickupAddressFieldClickListener(passengerAddressActions.pickupClicked);
    pickupAndDestinationAddressView.setDestinationAddressFieldClickListener(passengerAddressActions.dropoffClicked);
  }
  
  public void setBannerMessage(String paramString)
  {
    bannerTextView.setText(paramString);
  }
  
  public void setBannerMessageTextColor(int paramInt)
  {
    bannerTextView.setTextColor(getResources().getColor(paramInt));
  }
  
  public void setDestinationLocation(Location paramLocation)
  {
    pickupAndDestinationAddressView.setDestinationAddress(paramLocation);
  }
  
  public void setPickupEditable(boolean paramBoolean)
  {
    pickupAndDestinationAddressView.setPickupEditable(paramBoolean);
  }
  
  public void setPickupLocation(Location paramLocation)
  {
    pickupAndDestinationAddressView.setPickupAddress(paramLocation);
  }
  
  public void updateDriver(Driver paramDriver)
  {
    rideDetailView.updateDriver(paramDriver);
  }
  
  public void updatePassengers(List<PassengerRidePassenger> paramList)
  {
    rideDetailView.updatePassengers(paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.RideFooterView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */