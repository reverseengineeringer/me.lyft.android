package me.lyft.android.ui.passenger.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.rx.Binder;

public class RideTypeInfoHeaderView
  extends LinearLayout
{
  @Inject
  IAssetLoadingService assetLoadingService;
  private Binder binder;
  @Inject
  PassengerAnalytics passengerAnalytics;
  @Inject
  IRideRequestSession rideRequestSession;
  ImageView rideTypeIcon;
  TextView rideTypeInfoLabel;
  TextView rideTypeInfoSubLabel;
  @Inject
  PassengerRideRouter router;
  
  public RideTypeInfoHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void setRequestRideType(RequestRideType paramRequestRideType)
  {
    updateIcon(paramRequestRideType);
    updateLabel(paramRequestRideType);
    updateSecondaryLabel(paramRequestRideType);
  }
  
  private void updateIcon(RequestRideType paramRequestRideType)
  {
    binder.bind(assetLoadingService.loadMarkerBitmap(paramRequestRideType.getHeroImage()), new RideTypeInfoHeaderView.3(this));
  }
  
  private void updateLabel(RequestRideType paramRequestRideType)
  {
    rideTypeInfoLabel.setText(paramRequestRideType.getLabel());
  }
  
  private void updateSecondaryLabel(RequestRideType paramRequestRideType)
  {
    rideTypeInfoSubLabel.setText(paramRequestRideType.getDescription());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    binder.bind(rideRequestSession.observeCurrentRideType(), new RideTypeInfoHeaderView.2(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    setOnClickListener(new RideTypeInfoHeaderView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.RideTypeInfoHeaderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */