package me.lyft.android.ui.landing;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.widgets.animators.FadeAnimator;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.UiElement;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.invite.IWarmWelcomeService;
import me.lyft.android.application.landing.ILoginChallengeService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.domain.invite.WarmWelcome;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.rx.RxUIBinder;
import rx.functions.Action1;

public class IntroductionViewController
  extends RxViewController
{
  TextView amountTextView;
  private final AppFlow appFlow;
  private final IConstantsProvider constantsProvider;
  private final IDeveloperTools developerTools;
  TextView developmentView;
  TextView environmentName;
  private final ImageLoader imageLoader;
  private final LandingFlow landingFlow;
  private ActionAnalytics loadImageAction = null;
  private final ILoginChallengeService loginChallengeService;
  View loginView;
  View loginViewReferral;
  View lyftLogo;
  private final ILyftPreferences lyftPreferences;
  private final Action1<Boolean> onDeveloperModeChanged = new IntroductionViewController.9(this);
  ViewGroup referralBox;
  ImageView referralGiftboxView;
  ImageView referralPicture;
  TextView referrerTextView;
  private final ISignUpUserRepository signUpUserRepository;
  View signupView;
  View signupViewReferral;
  TextView takerideTextView;
  private final IWarmWelcomeService warmWelcomeService;
  
  @Inject
  public IntroductionViewController(AppFlow paramAppFlow, LandingFlow paramLandingFlow, ILyftPreferences paramILyftPreferences, IDeveloperTools paramIDeveloperTools, ISignUpUserRepository paramISignUpUserRepository, IWarmWelcomeService paramIWarmWelcomeService, ImageLoader paramImageLoader, IConstantsProvider paramIConstantsProvider, ILoginChallengeService paramILoginChallengeService)
  {
    appFlow = paramAppFlow;
    landingFlow = paramLandingFlow;
    lyftPreferences = paramILyftPreferences;
    developerTools = paramIDeveloperTools;
    signUpUserRepository = paramISignUpUserRepository;
    warmWelcomeService = paramIWarmWelcomeService;
    imageLoader = paramImageLoader;
    constantsProvider = paramIConstantsProvider;
    loginChallengeService = paramILoginChallengeService;
  }
  
  private void displayReferrerView(WarmWelcome paramWarmWelcome)
  {
    setProfileImage(paramWarmWelcome);
    referrerTextView.setText(paramWarmWelcome.getAttribution());
    amountTextView.setText(paramWarmWelcome.getCredit());
    takerideTextView.setText(paramWarmWelcome.getPromo());
    startEntryAnimation();
  }
  
  private void setProfileImage(WarmWelcome paramWarmWelcome)
  {
    boolean bool = paramWarmWelcome.hasPhoto();
    UxAnalytics localUxAnalytics = UxAnalytics.displayed(UiElement.REFERRAL_WELCOME_VIEW);
    if (bool) {}
    for (String str = "has_profile_image";; str = "no_profile_image")
    {
      localUxAnalytics.setParameter(str).track();
      loadImageAction = OnBoardingAnalytics.trackReferralImage();
      if ((!bool) || (!((Boolean)constantsProvider.get(Constants.WARM_WELCOME_PROFILE_VISIBLE)).booleanValue())) {
        break;
      }
      referralPicture.setVisibility(0);
      referralGiftboxView.setVisibility(8);
      imageLoader.load(paramWarmWelcome.getPhotoUrl()).into(referralPicture, new IntroductionViewController.10(this));
      return;
    }
    trackImageLoadNotAttempted();
    referralPicture.setVisibility(8);
    referralGiftboxView.setVisibility(0);
  }
  
  private void startEntryAnimation()
  {
    referralBox.setVisibility(0);
    referralBox.setAlpha(0.0F);
    Object localObject = new LinearInterpolator();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(referralBox, View.SCALE_X, new float[] { 1.1F, 1.0F });
    localObjectAnimator1.setDuration('Ĭ');
    localObjectAnimator1.setInterpolator((TimeInterpolator)localObject);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(referralBox, View.SCALE_Y, new float[] { 1.1F, 1.0F });
    localObjectAnimator2.setDuration('Ĭ');
    localObjectAnimator2.setInterpolator((TimeInterpolator)localObject);
    localObject = FadeAnimator.getFadeInAnimator(referralBox);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject);
    localAnimatorSet.setStartDelay(100L);
    localAnimatorSet.start();
  }
  
  private void trackImageLoadAborted()
  {
    if (loadImageAction != null)
    {
      loadImageAction.trackAborted();
      loadImageAction = null;
    }
  }
  
  private void trackImageLoadFailure()
  {
    if (loadImageAction != null)
    {
      loadImageAction.trackFailure();
      loadImageAction = null;
    }
  }
  
  private void trackImageLoadNotAttempted()
  {
    if (loadImageAction != null)
    {
      loadImageAction.trackCanceled();
      loadImageAction = null;
    }
  }
  
  private void trackImageLoadSuccess()
  {
    if (loadImageAction != null)
    {
      loadImageAction.trackSuccess();
      loadImageAction = null;
    }
  }
  
  protected int layoutId()
  {
    return 2130903265;
  }
  
  public void onAttach()
  {
    super.onAttach();
    loginView.setOnClickListener(new IntroductionViewController.1(this));
    signupView.setOnClickListener(new IntroductionViewController.2(this));
    loginViewReferral.setOnClickListener(new IntroductionViewController.3(this));
    signupViewReferral.setOnClickListener(new IntroductionViewController.4(this));
    environmentName.setOnClickListener(new IntroductionViewController.5(this));
    developmentView.setOnClickListener(new IntroductionViewController.6(this));
    lyftLogo.setSoundEffectsEnabled(false);
    lyftLogo.setOnClickListener(new IntroductionViewController.7(this));
    OnBoardingAnalytics.trackInitiateOnboarding();
    binder.bindAction(developerTools.observeDeveloperMode(), onDeveloperModeChanged);
    binder.bindAsyncCall(warmWelcomeService.observeWarmWelcome(), new IntroductionViewController.8(this));
    signUpUserRepository.reset();
    loginChallengeService.reset();
  }
  
  public void onDetach()
  {
    super.onDetach();
    trackImageLoadAborted();
    imageLoader.cancelRequest(referralPicture);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.IntroductionViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */