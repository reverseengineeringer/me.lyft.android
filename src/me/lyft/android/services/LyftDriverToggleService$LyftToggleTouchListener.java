package me.lyft.android.services;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.widgets.SimpleAnimationListener;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.studies.DriverAnalytics;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.rx.ReactiveProperty;

class LyftDriverToggleService$LyftToggleTouchListener
  implements View.OnTouchListener
{
  private ValueAnimator bounceXAnimator = new ValueAnimator();
  private ValueAnimator bounceYAnimator = new ValueAnimator();
  private AnimatorSet bouncingAnimatorSet = new AnimatorSet();
  private float initialTouchX;
  private float initialTouchY;
  private int initialX;
  private int initialY;
  private boolean shouldSwitchUserMode;
  
  private LyftDriverToggleService$LyftToggleTouchListener(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  private void animateBouncingBack()
  {
    stopAnimations();
    bounceXAnimator = ValueAnimator.ofInt(new int[] { access$1700this$0).x, initialX });
    bounceYAnimator = ValueAnimator.ofInt(new int[] { access$1700this$0).y, initialY });
    bounceXAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
        access$1700this$0).x = paramAnonymousValueAnimator.intValue();
        LyftDriverToggleService.access$1900(this$0).updateViewLayout(LyftDriverToggleService.access$1800(this$0), LyftDriverToggleService.access$1700(this$0));
      }
    });
    bounceYAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
        access$1700this$0).y = paramAnonymousValueAnimator.intValue();
        LyftDriverToggleService.access$1900(this$0).updateViewLayout(LyftDriverToggleService.access$1800(this$0), LyftDriverToggleService.access$1700(this$0));
      }
    });
    bouncingAnimatorSet = new AnimatorSet();
    bouncingAnimatorSet.playTogether(new Animator[] { bounceXAnimator, bounceYAnimator });
    bouncingAnimatorSet.setInterpolator(new AnticipateOvershootInterpolator(2.0F, 1.5F));
    bouncingAnimatorSet.addListener(new SimpleAnimationListener()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        LyftDriverToggleService.access$800(this$0).setEnabled(true);
        LyftDriverToggleService.LyftToggleTouchListener.this.changeTextVisibility(false);
        LyftDriverToggleService.LyftToggleTouchListener.this.changeBackgroundVisibility(false);
        if (shouldSwitchUserMode)
        {
          LyftDriverToggleService.LyftToggleTouchListener.access$2502(LyftDriverToggleService.LyftToggleTouchListener.this, false);
          LyftDriverToggleService.access$2600(this$0);
        }
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        super.onAnimationStart(paramAnonymousAnimator);
        LyftDriverToggleService.access$800(this$0).setEnabled(false);
      }
    });
    bouncingAnimatorSet.setDuration(500L);
    bouncingAnimatorSet.start();
  }
  
  private void changeBackgroundVisibility(boolean paramBoolean)
  {
    Object localObject = LyftDriverToggleService.access$100(this$0);
    if (paramBoolean)
    {
      i = 0;
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this$0;
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (int i = LyftDriverToggleService.access$500(this$0);; i = 128)
    {
      LyftDriverToggleService.access$502((LyftDriverToggleService)localObject, i);
      return;
      i = 8;
      break;
    }
  }
  
  private void changeTextVisibility(boolean paramBoolean)
  {
    TextView localTextView = LyftDriverToggleService.access$400(this$0);
    int i;
    if (paramBoolean)
    {
      i = 0;
      localTextView.setVisibility(i);
      localTextView = LyftDriverToggleService.access$400(this$0);
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (float f = 1.0F;; f = 0.0F)
    {
      localTextView.setAlpha(f);
      return;
      i = 8;
      break;
    }
  }
  
  private double distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt(Math.pow(paramFloat3 - paramFloat1, 2.0D) + Math.pow(paramFloat4 - paramFloat2, 2.0D));
  }
  
  private boolean isToggleTresholdReached(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    return distance(initialTouchX, initialTouchY, f1, f2) > LyftDriverToggleService.access$2100(this$0);
  }
  
  private boolean shouldDismissChathead(MotionEvent paramMotionEvent)
  {
    if (LyftDriverToggleService.access$100(this$0).getVisibility() == 8) {
      return false;
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    paramMotionEvent = LyftDriverToggleService.access$2200(this$0, LyftDriverToggleService.access$300(this$0));
    return ((f1 > left) && (f2 > top + paramMotionEvent.height() / 2)) || ((f1 > left + paramMotionEvent.width() / 2) && (f2 > top));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (LyftDriverToggleService.access$1600(this$0).onTouchEvent(paramMotionEvent)) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      initialX = access$1700this$0).x;
      initialTouchX = paramMotionEvent.getRawX();
      initialY = access$1700this$0).y;
      initialTouchY = paramMotionEvent.getRawY();
      return true;
    case 1: 
      if (shouldDismissChathead(paramMotionEvent))
      {
        DriverAnalytics.trackDriverDefenseDragToDismiss();
        this$0.lyftPreferences.setDriverShortcutEnabled(false);
        this$0.stopSelf();
        return true;
      }
      LyftDriverToggleService.access$800(this$0).setEnabled(false);
      paramView = this$0.driverRideProvider.getDriverRide();
      if ((isToggleTresholdReached(paramMotionEvent)) && ((paramView.isNull()) || (!paramView.isInProgress()))) {
        shouldSwitchUserMode = true;
      }
      animateBouncingBack();
      return true;
    }
    access$1700this$0).x = ((int)(initialX + (paramMotionEvent.getRawX() - initialTouchX)));
    access$1700this$0).y = ((int)(initialY + (paramMotionEvent.getRawY() - initialTouchY)));
    LyftDriverToggleService.access$1900(this$0).updateViewLayout(LyftDriverToggleService.access$1800(this$0), LyftDriverToggleService.access$1700(this$0));
    if (shouldDismissChathead(paramMotionEvent)) {
      LyftDriverToggleService.access$2000(this$0).onNext(LyftDriverToggleService.DraggingZone.DRAG_TO_REMOVE);
    }
    for (;;)
    {
      changeBackgroundVisibility(true);
      return true;
      if (isToggleTresholdReached(paramMotionEvent)) {
        LyftDriverToggleService.access$2000(this$0).onNext(LyftDriverToggleService.DraggingZone.DRAG_TO_SWITCH);
      } else {
        LyftDriverToggleService.access$2000(this$0).onNext(LyftDriverToggleService.DraggingZone.DRAG_STARTED);
      }
    }
  }
  
  protected void stopAnimations()
  {
    bouncingAnimatorSet.cancel();
    bounceXAnimator.cancel();
    bounceYAnimator.cancel();
    bounceXAnimator.removeAllUpdateListeners();
    bounceYAnimator.removeAllUpdateListeners();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.LyftToggleTouchListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */