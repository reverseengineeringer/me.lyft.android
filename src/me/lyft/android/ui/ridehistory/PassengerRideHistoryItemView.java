package me.lyft.android.ui.ridehistory;

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
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryItem;
import me.lyft.android.managers.ImageLoader;

public class PassengerRideHistoryItemView
  extends LinearLayout
{
  ImageView drivePhotoImageView;
  @Inject
  IFeaturesProvider featuresProvider;
  @Inject
  ImageLoader imageLoader;
  ImageView itemIcon;
  TextView rideDistanceAndDurationTextView;
  TextView rideEndDateTimeTextView;
  TextView rideTotalTextView;
  TextView rideTypeTextView;
  
  public PassengerRideHistoryItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  public void setItem(PassengerRideHistoryItem paramPassengerRideHistoryItem)
  {
    int i = 0;
    imageLoader.load(paramPassengerRideHistoryItem.getDriverPhotoUrl()).centerCrop().fit().placeholder(2130838447).into(drivePhotoImageView);
    rideTotalTextView.setText(paramPassengerRideHistoryItem.getTotalMoney());
    rideEndDateTimeTextView.setText(paramPassengerRideHistoryItem.getPickupTime());
    label128:
    ImageView localImageView;
    if (Strings.isNullOrEmpty(paramPassengerRideHistoryItem.getRideTypeLabel()))
    {
      rideTypeTextView.setVisibility(8);
      if ((Strings.isNullOrEmpty(paramPassengerRideHistoryItem.getDistance())) || (Strings.isNullOrEmpty(paramPassengerRideHistoryItem.getRideDuration()))) {
        break label214;
      }
      rideDistanceAndDurationTextView.setText(paramPassengerRideHistoryItem.getDistance() + " • " + paramPassengerRideHistoryItem.getRideDuration());
      localImageView = itemIcon;
      if (!featuresProvider.isEnabled(Features.SHOW_BUSINESS_RIDE_HISTORY)) {
        break label233;
      }
    }
    for (;;)
    {
      localImageView.setVisibility(i);
      if ((featuresProvider.isEnabled(Features.SHOW_BUSINESS_RIDE_HISTORY)) && (paramPassengerRideHistoryItem.isBusinessRide())) {
        itemIcon.setImageDrawable(getResources().getDrawable(2130838140));
      }
      return;
      rideTypeTextView.setText(paramPassengerRideHistoryItem.getRideTypeLabel());
      rideTypeTextView.setVisibility(0);
      break;
      label214:
      rideDistanceAndDurationTextView.setText(getResources().getString(2131165989));
      break label128;
      label233:
      i = 8;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ridehistory.PassengerRideHistoryItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */