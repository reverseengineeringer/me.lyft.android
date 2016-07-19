package me.lyft.android.ui.passenger.v2.inride;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRidePassenger;
import me.lyft.android.managers.ImageLoader;

public class PassengersDetailView
  extends RelativeLayout
{
  @Inject
  AppFlow appFlow;
  @Inject
  ImageLoader imageLoader;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  LinearLayout passengersContainerView;
  
  public PassengersDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void setPassengers(List<PassengerRidePassenger> paramList)
  {
    passengersContainerView.removeAllViews();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      PassengerRidePassenger localPassengerRidePassenger = (PassengerRidePassenger)localIterator.next();
      View localView = LayoutInflater.from(getContext()).inflate(2130903319, passengersContainerView, false);
      PassengersDetailView.ViewHolder localViewHolder = new PassengersDetailView.ViewHolder(localView);
      TextView localTextView = labelView;
      if ((localPassengerRidePassenger.isSelf()) && (passengerRideProvider.getPassengerRide().isCourier()))
      {
        paramList = getResources().getString(2131166281);
        label104:
        localTextView.setText(paramList);
        numberView.setText(String.valueOf(localPassengerRidePassenger.getPartySize()));
        paramList = numberView;
        if (localPassengerRidePassenger.getPartySize() <= 1) {
          break label215;
        }
      }
      label215:
      for (int i = 0;; i = 8)
      {
        paramList.setVisibility(i);
        imageLoader.load(localPassengerRidePassenger.getPhotoUrl()).fit().centerInside().placeholder(2130838447).into(imageView);
        localView.setOnClickListener(new PassengersDetailView.1(this, localPassengerRidePassenger));
        passengersContainerView.addView(localView);
        break;
        paramList = localPassengerRidePassenger.getFirstName();
        break label104;
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.PassengersDetailView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */