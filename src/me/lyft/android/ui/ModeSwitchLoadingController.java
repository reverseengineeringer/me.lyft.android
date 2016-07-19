package me.lyft.android.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.DriverConsoleAnalytics;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.domain.driver.UiState;

public class ModeSwitchLoadingController
  extends RxViewController
{
  private static final long INITIAL_ZOOM_TIME = 100L;
  private static final long PROGRESS_LOAD_TIME = 2000L;
  private static final long SECONDARY_ZOOM_TIME = 750L;
  private final AppFlow appFlow;
  private final DriverConsoleAnalytics driverConsoleAnalytics;
  View modeSwitchLoadingProgressBar;
  TextView modeSwitchTextView;
  private final IUserUiService userService;
  
  @Inject
  public ModeSwitchLoadingController(IUserUiService paramIUserUiService, AppFlow paramAppFlow, DriverConsoleAnalytics paramDriverConsoleAnalytics)
  {
    userService = paramIUserUiService;
    appFlow = paramAppFlow;
    driverConsoleAnalytics = paramDriverConsoleAnalytics;
  }
  
  private void animate(Screen paramScreen)
  {
    animateProgressBar(paramScreen);
    animateTextZoom();
  }
  
  private void animateProgressBar(Screen paramScreen)
  {
    Animator localAnimator = createFirstProgressAnimator();
    paramScreen = createSecondProgressAnimator(paramScreen);
    localAnimator.start();
    paramScreen.start();
  }
  
  private void animateTextZoom()
  {
    Animator localAnimator = createFirstZoomAnimator();
    localAnimator.addListener(new ModeSwitchLoadingController.1(this));
    localAnimator.start();
  }
  
  private Animator createFirstProgressAnimator()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(getScaleInAnimator(modeSwitchLoadingProgressBar, View.SCALE_X, 0.1F, 0.1F, 100L));
    return localAnimatorSet;
  }
  
  private Animator createFirstZoomAnimator()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(getScaleInAnimator(modeSwitchTextView, View.SCALE_X, 0.0F, 0.75F, 100L)).with(getScaleInAnimator(modeSwitchTextView, View.SCALE_Y, 0.0F, 0.75F, 100L));
    return localAnimatorSet;
  }
  
  private Animator createSecondProgressAnimator(Screen paramScreen)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(getScaleInAnimator(modeSwitchLoadingProgressBar, View.SCALE_X, 0.1F, 1.0F, 2000L));
    localAnimatorSet.addListener(new ModeSwitchLoadingController.2(this, paramScreen));
    return localAnimatorSet;
  }
  
  private Animator createSecondZoomAnimator()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(getScaleInAnimator(modeSwitchTextView, View.SCALE_X, 0.75F, 1.0F, 750L)).with(getScaleInAnimator(modeSwitchTextView, View.SCALE_Y, 0.75F, 1.0F, 750L));
    return localAnimatorSet;
  }
  
  private static ObjectAnimator getScaleInAnimator(View paramView, Property<View, Float> paramProperty, float paramFloat1, float paramFloat2, long paramLong)
  {
    return ObjectAnimator.ofFloat(paramView, paramProperty, new float[] { paramFloat1, paramFloat2 }).setDuration(paramLong);
  }
  
  private void switchMode(Screen paramScreen, boolean paramBoolean, String paramString)
  {
    userService.updateUiState(new UiState(paramBoolean));
    animate(paramScreen);
    modeSwitchTextView.setText(paramString);
  }
  
  protected int layoutId()
  {
    return 2130903294;
  }
  
  public void onAttach()
  {
    super.onAttach();
    if (userService.getUiState().isDriverUi())
    {
      switchMode(new MainScreens.PassengerRideScreen(), false, getResources().getString(2131165917));
      return;
    }
    switchMode(new MainScreens.DriverRideScreen(), true, getResources().getString(2131165916));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ModeSwitchLoadingController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */