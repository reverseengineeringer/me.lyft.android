package me.lyft.android.ui.driver.carpool;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.profile.ProfileFormatter;

public class DriverCarpoolRequestFooterView
  extends LinearLayout
{
  TextView earningsTextView;
  TextView footerHeadingTextView;
  @Inject
  ImageLoader imageLoader;
  TextView passengerNameTextView;
  TextView passengerRatingTextView;
  @Inject
  ProfileFlow profileFlow;
  ImageView profileImageView;
  
  public DriverCarpoolRequestFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void displayEarnings(Money paramMoney)
  {
    earningsTextView.setText(paramMoney.format());
  }
  
  private void displayPassengerInfo(DriverRidePassenger paramDriverRidePassenger)
  {
    passengerNameTextView.setText(paramDriverRidePassenger.getFirstName());
    passengerRatingTextView.setText(ProfileFormatter.getFormattedRating(paramDriverRidePassenger, getResources()));
    imageLoader.load(paramDriverRidePassenger.getPhotoUrl()).fit().centerCrop().placeholder(2130838447).into(profileImageView);
    profileImageView.setOnClickListener(new DriverCarpoolRequestFooterView.1(this, paramDriverRidePassenger));
    footerHeadingTextView.setText(getResources().getString(2131165376, new Object[] { paramDriverRidePassenger.getFirstName() }));
  }
  
  public void displayDriverRide(DriverRide paramDriverRide)
  {
    displayEarnings(paramDriverRide.getProfitMinusTip());
    displayPassengerInfo(paramDriverRide.getCurrentPassenger());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.DriverCarpoolRequestFooterView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */