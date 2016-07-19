package me.lyft.android.ui.passenger.v2.request.venue;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.controls.CustomPicker;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.passenger.v2.request.pickup.PickupEtaPin;
import me.lyft.android.ui.passenger.v2.request.pickup.PickupPinPresenter;
import rx.Observable;

public class VenueRideView
  extends RelativeLayout
  implements HandleBack, VenuePresenter.VenueView
{
  ImageButton backButton;
  View confirmLocationView;
  HeightObservableLayout containerBottom;
  HeightObservableLayout containerTop;
  CustomPicker locationPicker;
  LinearLayout pickerLayout;
  PickupEtaPin pickupEtaPin;
  @Inject
  PickupPinPresenter pickupPinPresenter;
  TextView singleLocation;
  TextView subtitleTextView;
  TextView titleTextView;
  @Inject
  VenuePresenter venuePresenter;
  CustomPicker zonePicker;
  
  public VenueRideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  public Observable<Integer> observeBottomContainerHeight()
  {
    return containerBottom.observeHeightChange();
  }
  
  public Observable<Integer> observeTopContainerHeight()
  {
    return containerTop.observeHeightChange();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    venuePresenter.attachView(this);
    pickupPinPresenter.attachView(pickupEtaPin);
    zonePicker.setOnValueChangedListener(new VenueRideView.1(this));
    locationPicker.setOnValueChangedListener(new VenueRideView.2(this));
    confirmLocationView.setOnClickListener(new VenueRideView.3(this));
  }
  
  public boolean onBack()
  {
    venuePresenter.onBack();
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    pickupPinPresenter.detachView(pickupEtaPin);
    venuePresenter.detachView(this);
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    backButton.setOnClickListener(new VenueRideView.4(this));
  }
  
  public void selectPositions(int paramInt1, int paramInt2)
  {
    zonePicker.setValue(paramInt1);
    locationPicker.setValue(paramInt2);
  }
  
  public void setZoneInformation(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    titleTextView.setText(paramString1);
    subtitleTextView.setText(paramString2);
    locationPicker.updateValues(paramArrayOfString);
  }
  
  public void setZoneInformationSinglePickup(String paramString1, String paramString2, String paramString3)
  {
    pickerLayout.setVisibility(8);
    titleTextView.setText(paramString1);
    subtitleTextView.setText(paramString2);
    singleLocation.setVisibility(0);
    singleLocation.setText(paramString3);
  }
  
  public void setZones(String[] paramArrayOfString)
  {
    zonePicker.updateValues(paramArrayOfString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.venue.VenueRideView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */