package me.lyft.android.ui.passenger.rateandpay;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ride.PassengerRideExpense;
import me.lyft.android.domain.passenger.ride.PassengerRideRating;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.passenger.PassengerDialogs.PostRideSocialShareDialog;
import rx.Observable;
import rx.subjects.PublishSubject;

public class PassengerSubmitRatingButton
  extends Button
{
  private Binder binder;
  @Inject
  ICheckoutSession checkoutSession;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  MainScreensRouter mainScreensRouter;
  PublishSubject<Unit> onSubmitPressedSubject = PublishSubject.create();
  @Inject
  IPassengerRideService passengerRideService;
  @Inject
  IProgressController progressController;
  @Inject
  IRatingSession ratingSession;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public PassengerSubmitRatingButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private boolean shouldShowPostRideSocialDialog(int paramInt)
  {
    if (paramInt != 5) {
      return false;
    }
    paramInt = ((Long)constantsProvider.get(Constants.PG_SOCIAL_PROMPT_FREQUENCY)).intValue();
    int i = ((Long)constantsProvider.get(Constants.PG_SOCIAL_PROMPT_TOTAL_TIMES)).intValue();
    int j = lyftPreferences.getShareDialogShowCount();
    int k = lyftPreferences.getNumRidesSinceShareDialogLastShown();
    if ((j < i) && (k >= paramInt - 1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void showPostRideSocialDialog()
  {
    dialogFlow.show(new PassengerDialogs.PostRideSocialShareDialog(false));
  }
  
  public Observable<Unit> observeOnSubmitPressed()
  {
    return onSubmitPressedSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public boolean performClick()
  {
    super.performClick();
    onSubmitPressedSubject.onNext(Unit.create());
    return true;
  }
  
  protected void submitRating()
  {
    submitRating(PassengerRideExpense.empty());
  }
  
  protected void submitRating(PassengerRideExpense paramPassengerRideExpense)
  {
    int i = ratingSession.getRating();
    Object localObject = Strings.nullToEmpty(ratingSession.getFeedback());
    progressController.disableUI();
    localObject = new PassengerRideRating(i, (String)localObject, ratingSession.getImprovementAreas());
    binder.bind(passengerRideService.rateAndPayDriver((PassengerRideRating)localObject, paramPassengerRideExpense, checkoutSession.getPayment()), new PassengerSubmitRatingButton.1(this, i));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.rateandpay.PassengerSubmitRatingButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */