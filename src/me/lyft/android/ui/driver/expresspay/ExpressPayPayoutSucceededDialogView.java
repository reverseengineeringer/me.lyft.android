package me.lyft.android.ui.driver.expresspay;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ViewExtensions;
import me.lyft.android.ui.MainScreensRouter;
import rx.functions.Action1;

public class ExpressPayPayoutSucceededDialogView
  extends LinearLayout
{
  private static final int ALPHA_IN_DURATION = 300;
  private static final int ANIM_OUT_DURATION = 300;
  private static final int ANIM_OUT_START_DELAY_DURATION = 0;
  private static final Interpolator BOUNCE_IN_INTERPOLATOR = new AnticipateOvershootInterpolator(1.4F);
  private static final int SCALE_RATIO = 80;
  private static final int SLIDE_ANIM_IN_DURATION = 300;
  private static final Interpolator SLIDE_OUT_INTERPOLATOR = new AccelerateInterpolator();
  final Animator.AnimatorListener animatorEndListener = new ExpressPayPayoutSucceededDialogView.3(this);
  @Inject
  AppFlow appFlow;
  ImageView bolt;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IFeaturesProvider featuresProvider;
  @Inject
  MainScreensRouter mainScreensRouter;
  final Action1<Unit> readyToAnimateAction = new ExpressPayPayoutSucceededDialogView.1(this);
  final Animator.AnimatorListener removeScreenAnimationListener = new ExpressPayPayoutSucceededDialogView.2(this);
  
  public ExpressPayPayoutSucceededDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Binder.attach(this).bind(ViewExtensions.onLoadedObservable(this), readyToAnimateAction);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.expresspay.ExpressPayPayoutSucceededDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */