package me.lyft.android.ui.driver;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.googlemaps.core.util.Objects;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.EditTextWithoutEnter;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.NullMoney;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.tooltips.TooltipContainerView;

public class DriverRideRatingAndEarningsView
  extends ScrollView
{
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IDriverRideProvider driverRideProvider;
  @Inject
  IDriverRouteService driverRouteService;
  TextView feedbackCaptionTextView;
  EditTextWithoutEnter feedbackCommentsInput;
  @Inject
  ImageLoader imageLoader;
  private final RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = new DriverRideRatingAndEarningsView.4(this);
  View passengerPhotoContainer;
  ImageView passengerPhotoImageView;
  RatingBar passengerRatingBar;
  TextView primeTimeLabel;
  @Inject
  IProgressController progressController;
  TextView ratingCaptionTextView;
  View ratingSectionFeedback;
  TextView ratingSubtitleTextView;
  LinearLayout rideEarningLayout;
  private ReactiveProperty<String> rideIdProperty;
  TextView rideTotalLabel;
  TextView rideTotalTextView;
  Button submitRatingButton;
  View tooltipAnchorRatingStar;
  TooltipContainerView tooltipContainer;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public DriverRideRatingAndEarningsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private DriverRidePassenger getPassenger()
  {
    return driverRideProvider.getDriverRide().getUnratedPassenger();
  }
  
  private void resolveRatingButtonColor()
  {
    DriverRide localDriverRide = driverRideProvider.getDriverRide();
    int i;
    if (localDriverRide.isCourier()) {
      i = 2130837615;
    }
    for (;;)
    {
      submitRatingButton.setBackgroundResource(i);
      return;
      if (localDriverRide.isPlus()) {
        i = 2130837585;
      } else {
        i = 2130837588;
      }
    }
  }
  
  private void restoreRatingData()
  {
    ratingSectionFeedback.setVisibility(8);
    submitRatingButton.setVisibility(8);
    passengerPhotoContainer.setVisibility(0);
    setRatingSubtitleVisibility(0);
  }
  
  private void setRatingSubtitleVisibility(int paramInt)
  {
    if (!driverRideProvider.getDriverRide().isFeatureEnabled(RideFeature.UNPAIR_DISABLED)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ratingSubtitleTextView.setVisibility(paramInt);
      }
      return;
    }
  }
  
  private void showTooltips()
  {
    if (!driverRideProvider.getDriverRide().showHints()) {
      return;
    }
    tooltipContainer.tryToShowAndMarkShown("star_5_button", tooltipAnchorRatingStar, 80);
    tooltipContainer.tryToShowAndMarkShown("submit_button", submitRatingButton, 48);
  }
  
  private void submitRating()
  {
    int i = (int)passengerRatingBar.getRating();
    String str = feedbackCommentsInput.getText().toString();
    progressController.disableUI();
    binder.bind(driverRouteService.rate(getPassenger(), Integer.valueOf(i).intValue(), str), new DriverRideRatingAndEarningsView.3(this));
    if (driverRideProvider.getDriverRide().isTrainingRide()) {
      dialogFlow.show(new DriverDialogs.TrainingRideCompletedDialog(getPassenger().getPhotoUrl()));
    }
  }
  
  private void updateRatingAndFeedbackCaption(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      i = 2131166213;
    }
    for (;;)
    {
      ratingCaptionTextView.setText(getContext().getString(i));
      if (paramInt >= 5) {
        break;
      }
      feedbackCaptionTextView.setText(getContext().getString(2131166221, new Object[] { getPassenger().getFirstName() }));
      return;
      i = 2131166215;
      continue;
      i = 2131166216;
      continue;
      i = 2131166217;
      continue;
      i = 2131166218;
    }
    feedbackCaptionTextView.setText(getContext().getString(2131166228));
  }
  
  private void updateRatingBar()
  {
    passengerRatingBar.setOnRatingBarChangeListener(null);
    passengerRatingBar.setRating(0.0F);
    passengerRatingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
  }
  
  private void updateRideEarnings()
  {
    Money localMoney = (Money)Objects.firstNonNull(driverRideProvider.getDriverRide().getProfitMinusTip(), NullMoney.getInstance());
    if (localMoney.isNull())
    {
      rideEarningLayout.setVisibility(8);
      return;
    }
    rideTotalTextView.setText(localMoney.format());
    if (driverRideProvider.getDriverRide().supportsTips()) {
      rideTotalLabel.setText(2131165645);
    }
    for (;;)
    {
      rideEarningLayout.setVisibility(0);
      int i = driverRideProvider.getDriverRide().getPrimeTimePercent();
      if (i == 0) {
        break;
      }
      primeTimeLabel.setText(getContext().getString(2131165643, new Object[] { Integer.valueOf(i) }));
      primeTimeLabel.setVisibility(0);
      return;
      rideTotalLabel.setText(2131165646);
    }
    primeTimeLabel.setVisibility(8);
  }
  
  private void updateView()
  {
    imageLoader.load(getPassenger().getPhotoUrl()).placeholder(2130838447).fit().centerCrop().into(passengerPhotoImageView);
    updateRideEarnings();
    resolveRatingButtonColor();
    updateRatingBar();
    submitRatingButton.setOnClickListener(new DriverRideRatingAndEarningsView.2(this));
    feedbackCommentsInput.setText("");
    setRatingSubtitleVisibility(0);
    passengerPhotoContainer.setVisibility(0);
    ratingSectionFeedback.setVisibility(8);
    submitRatingButton.setVisibility(8);
    ratingCaptionTextView.setText(getContext().getString(2131165644, new Object[] { getPassenger().getFirstName() }));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    rideIdProperty = ReactiveProperty.create(getPassenger().getRideId());
    binder.bind(rideIdProperty, new DriverRideRatingAndEarningsView.1(this));
    showTooltips();
    DriverRide localDriverRide = driverRideProvider.getDriverRide();
    TextView localTextView = ratingSubtitleTextView;
    if (localDriverRide.isFeatureEnabled(RideFeature.UNPAIR_DISABLED)) {}
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
    }
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
 * Qualified Name:     me.lyft.android.ui.driver.DriverRideRatingAndEarningsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */