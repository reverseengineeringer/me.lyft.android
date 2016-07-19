package me.lyft.android.ui.passenger.rateandpay;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.ui.passenger.PassengerScreens.PassengerRateRideScreen;
import rx.functions.Action1;

public class PassengerRateView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  ICheckoutSession checkoutSession;
  TextView driverImproveCaption;
  RatingBar driverRatingBar;
  @Inject
  IEtaAnalyticService etaAnalyticService;
  @Inject
  IExpenseNoteSession expenseNoteSession;
  private AnimatorSet feedbackAnimation;
  EditText feedbackText;
  @Inject
  ImageLoader imageLoader;
  ToggleButton improveCleanliness;
  ToggleButton improveFriendliness;
  private View.OnClickListener improveListener = new PassengerRateView.7(this);
  ToggleButton improveNavigation;
  View improveOptions;
  ToggleButton improveSafety;
  final Set<String> improvementAreas = new HashSet();
  private final RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = new PassengerRateView.3(this);
  final ReactiveProperty<Integer> onRatingChange = ReactiveProperty.create();
  final PassengerScreens.PassengerRateRideScreen params;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  IPassengerRideReceiptService passengerRideReceiptService;
  TextView ratingCaption;
  private final Action1<Integer> ratingChange = new PassengerRateView.2(this);
  TextView ratingDriverNameTxt;
  ImageView ratingDriverPhotoImageView;
  TextView ratingFeedback;
  View ratingPhotoContainer;
  View ratingSectionFeedback;
  @Inject
  IRatingSession ratingSession;
  TextView ratingSubtitle;
  PassengerSubmitRatingButton submitDriverRatingButton;
  Toolbar toolbar;
  @Inject
  IUserProvider userProvider;
  TextView whatYouLovedCaption;
  
  public PassengerRateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((PassengerScreens.PassengerRateRideScreen)Screen.fromView(this));
  }
  
  private ObjectAnimator createFadeInAnimator(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setDuration(300L);
    return paramView;
  }
  
  private ObjectAnimator createFadeOutAnimator(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
    paramView.setDuration(300L);
    return paramView;
  }
  
  private void hideDriverPhoto()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ratingPhotoContainer.getHeight(), 0 });
    localValueAnimator.addUpdateListener(new PassengerRateView.5(this));
    localValueAnimator.addListener(new PassengerRateView.6(this));
    localValueAnimator.setInterpolator(new DecelerateInterpolator(1.25F));
    localValueAnimator.setDuration(400L);
    localValueAnimator.start();
  }
  
  private void hideFeedbackArea()
  {
    ratingPhotoContainer.setVisibility(0);
    ratingSectionFeedback.setAlpha(0.0F);
    ratingSectionFeedback.setVisibility(8);
    submitDriverRatingButton.setAlpha(0.0F);
    submitDriverRatingButton.setVisibility(8);
    if (isRatingSubtitleEnabled())
    {
      ratingSubtitle.setAlpha(1.0F);
      ratingSubtitle.setVisibility(0);
    }
  }
  
  private void initView()
  {
    ButterKnife.bind(this);
    improveSafety.setOnClickListener(improveListener);
    improveCleanliness.setOnClickListener(improveListener);
    improveNavigation.setOnClickListener(improveListener);
    improveFriendliness.setOnClickListener(improveListener);
    resetRatingToggles();
    driverRatingBar.setRating(0.0F);
    feedbackText.setText("");
    etaAnalyticService.clear();
    imageLoader.load(passengerRideReceiptService.getRideReceipt().getDriverPhoto()).placeholder(2130838466).centerInside().fit().into(ratingDriverPhotoImageView);
    String str = passengerRideReceiptService.getRideReceipt().getDriverName();
    driverImproveCaption.setText(String.format(getContext().getString(2131166221), new Object[] { str }));
    ratingCaption.setText(String.format(getContext().getString(2131166227), new Object[] { str }));
    ratingDriverNameTxt.setText(str);
    if (showExpenseNoteScreen()) {
      submitDriverRatingButton.setText(2131165933);
    }
    for (;;)
    {
      restoreRatingData();
      driverRatingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
      return;
      submitDriverRatingButton.setText(2131166357);
    }
  }
  
  private boolean isRatingSubtitleEnabled()
  {
    return !passengerRideProvider.getPassengerRide().isFeatureEnabled(RideFeature.UNPAIR_DISABLED);
  }
  
  private boolean isSameRide()
  {
    return (ratingSession.getRideId().equals(passengerRideProvider.getPassengerRide().getId())) && (ratingSession.getRating() > 0);
  }
  
  private void persistRatingData()
  {
    ratingSession.setRideId(passengerRideProvider.getPassengerRide().getId());
    ratingSession.setFeedback(feedbackText.getText().toString());
    ratingSession.setRating((int)driverRatingBar.getRating());
    ratingSession.setImprovementAreas(improvementAreas);
  }
  
  private void resetRatingToggles()
  {
    improveFriendliness.setChecked(false);
    improveNavigation.setChecked(false);
    improveCleanliness.setChecked(false);
    improveSafety.setChecked(false);
    improvementAreas.clear();
  }
  
  private void restoreRatingData()
  {
    if (isSameRide())
    {
      ratingPhotoContainer.setVisibility(8);
      driverRatingBar.setRating(ratingSession.getRating());
      updateRatingCaptionAndToggles(ratingSession.getRating());
      feedbackText.setText(ratingSession.getFeedback());
      improvementAreas.addAll(ratingSession.getImprovementAreas());
      Iterator localIterator = ratingSession.getImprovementAreas().iterator();
      while (localIterator.hasNext())
      {
        ToggleButton localToggleButton = (ToggleButton)findViewWithTag((String)localIterator.next());
        if (localToggleButton != null) {
          localToggleButton.setChecked(true);
        }
      }
      showFeedbackArea(false);
      return;
    }
    hideFeedbackArea();
  }
  
  private boolean showExpenseNoteScreen()
  {
    return (checkoutSession.requireExpenseNote()) || ((expenseNoteSession.isConcurEnabled()) && (!userProvider.getUser().hasBusinessProfile()));
  }
  
  private void showFeedbackArea(boolean paramBoolean)
  {
    if (ratingSectionFeedback.getVisibility() == 0) {
      return;
    }
    if (paramBoolean)
    {
      if (feedbackAnimation != null) {
        feedbackAnimation.cancel();
      }
      Object localObject = createFadeInAnimator(ratingSectionFeedback);
      ObjectAnimator localObjectAnimator = createFadeInAnimator(submitDriverRatingButton);
      feedbackAnimation = new AnimatorSet();
      localObject = feedbackAnimation.play((Animator)localObject).with(localObjectAnimator);
      if (isRatingSubtitleEnabled())
      {
        localObjectAnimator = createFadeOutAnimator(ratingSubtitle);
        localObjectAnimator.addListener(new PassengerRateView.4(this));
        ((AnimatorSet.Builder)localObject).after(localObjectAnimator);
      }
      feedbackAnimation.start();
    }
    for (;;)
    {
      ratingSectionFeedback.setVisibility(0);
      submitDriverRatingButton.setVisibility(0);
      return;
      submitDriverRatingButton.setAlpha(1.0F);
      ratingSectionFeedback.setAlpha(1.0F);
      if (isRatingSubtitleEnabled())
      {
        ratingSubtitle.setAlpha(0.0F);
        ratingSubtitle.setVisibility(8);
      }
    }
  }
  
  private void updateRatingCaptionAndToggles(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      i = 2131166214;
      label41:
      ratingCaption.setText(getContext().getString(i));
      if (paramInt < 5)
      {
        whatYouLovedCaption.setVisibility(8);
        improveOptions.setVisibility(0);
      }
      break;
    }
    while (paramInt >= 5)
    {
      resetRatingToggles();
      return;
      i = 2131166215;
      break label41;
      i = 2131166216;
      break label41;
      i = 2131166217;
      break label41;
      i = 2131166218;
      break label41;
      whatYouLovedCaption.setVisibility(0);
      improveOptions.setVisibility(8);
    }
  }
  
  protected void onAttachedToWindow()
  {
    int j = 8;
    super.onAttachedToWindow();
    toolbar.setTitle(getContext().getString(2131166206));
    binder = Binder.attach(this);
    binder.bind(onRatingChange.distinctUntilChanged(), ratingChange);
    binder.bind(submitDriverRatingButton.observeOnSubmitPressed(), new PassengerRateView.1(this));
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    TextView localTextView = ratingFeedback;
    if (localPassengerRide.isFeatureEnabled(RideFeature.FEEDBACK_DISABLED))
    {
      i = 8;
      localTextView.setVisibility(i);
      localTextView = ratingSubtitle;
      if (!localPassengerRide.isFeatureEnabled(RideFeature.UNPAIR_DISABLED)) {
        break label140;
      }
    }
    label140:
    for (int i = j;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    persistRatingData();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    initView();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.rateandpay.PassengerRateView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */