package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.UserImageView;
import me.lyft.android.ui.dialogs.DialogContainerView;
import rx.functions.Action1;

public class LastRideConfirmationDialogView
  extends DialogContainerView
{
  private Binder binder;
  Button confirmLastRideButton;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IDriverRouteService driverRouteService;
  private Action1<DriverRide> onRouteUpdated = new LastRideConfirmationDialogView.2(this);
  LinearLayout passengerPhotoListView;
  @Inject
  IProgressController progressController;
  @Inject
  IDriverRideProvider routeProvider;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public LastRideConfirmationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void addPassengerPhoto(DriverRidePassenger paramDriverRidePassenger, ViewGroup.LayoutParams paramLayoutParams)
  {
    UserImageView localUserImageView = new UserImageView(getContext());
    localUserImageView.loadPhoto(paramDriverRidePassenger.getPhotoUrl());
    passengerPhotoListView.addView(localUserImageView, paramLayoutParams);
  }
  
  private void updatePassengerPhotos()
  {
    passengerPhotoListView.removeAllViews();
    int i = getResources().getDimensionPixelOffset(2131230839);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(i, i);
    Iterator localIterator = routeProvider.getDriverRide().getNotDroppedOffPassengers().iterator();
    while (localIterator.hasNext()) {
      addPassengerPhoto((DriverRidePassenger)localIterator.next(), localLayoutParams);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    binder.bind(routeProvider.observeRide(), onRouteUpdated);
    confirmLastRideButton.setOnClickListener(new LastRideConfirmationDialogView.1(this));
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
 * Qualified Name:     me.lyft.android.ui.driver.LastRideConfirmationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */