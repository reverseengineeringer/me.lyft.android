package me.lyft.android.ui.passenger.v2.inride;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.DriverVehicle;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.profile.ProfileFormatter;

public class DriverDetailView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  ImageView carImageView;
  TextView carLicenseTextView;
  TextView carNameTextView;
  RoundedImageView driverImageView;
  TextView driverNameTextView;
  TextView driverRatingTextView;
  @Inject
  ImageLoader imageLoader;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  
  public DriverDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  public void setDriver(Driver paramDriver)
  {
    DriverVehicle localDriverVehicle = paramDriver.getVehicle();
    carNameTextView.setText(Strings.joinWithDelimiter(" ", new String[] { localDriverVehicle.getMake(), localDriverVehicle.getModel() }));
    carLicenseTextView.setText(localDriverVehicle.getLicensePlate());
    imageLoader.load(localDriverVehicle.getPhotoUrl()).fit().centerInside().placeholder(2130838048).into(carImageView);
    imageLoader.load(paramDriver.getPhoto()).fit().centerInside().placeholder(2130838447).into(driverImageView);
    driverNameTextView.setText(paramDriver.getName());
    if (passengerRideProvider.getPassengerRide().isFeatureEnabled(RideFeature.HIDE_DRIVER_RATING)) {
      driverRatingTextView.setVisibility(8);
    }
    for (;;)
    {
      setOnClickListener(new DriverDetailView.1(this));
      return;
      driverRatingTextView.setText(ProfileFormatter.getFormattedRating(paramDriver.getRating(), getResources()));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.DriverDetailView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */