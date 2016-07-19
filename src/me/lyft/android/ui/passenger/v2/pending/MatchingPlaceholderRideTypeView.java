package me.lyft.android.ui.passenger.v2.pending;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.rx.Binder;

public class MatchingPlaceholderRideTypeView
  extends LinearLayout
{
  @Inject
  IAssetLoadingService assetLoadingService;
  private Binder binder;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  IRequestRideTypeService requestRideTypeRepository;
  ImageView rideTypeIcon;
  TextView rideTypeInfoLabel;
  TextView rideTypeInfoSubLabel;
  
  public MatchingPlaceholderRideTypeView(Context paramContext, AttributeSet paramAttributeSet)
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
    binder.bind(assetLoadingService.loadMarkerBitmap(paramRequestRideType.getHeroImage()), new MatchingPlaceholderRideTypeView.1(this));
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
    RideType localRideType = passengerRideProvider.getPassengerRide().getRideType();
    setRequestRideType(requestRideTypeRepository.findRideTypeById(localRideType.getType()));
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
 * Qualified Name:     me.lyft.android.ui.passenger.v2.pending.MatchingPlaceholderRideTypeView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */