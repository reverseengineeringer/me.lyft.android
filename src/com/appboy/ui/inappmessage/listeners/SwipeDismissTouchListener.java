package com.appboy.ui.inappmessage.listeners;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

public class SwipeDismissTouchListener
  implements View.OnTouchListener
{
  private long mAnimationTime;
  private DismissCallbacks mCallbacks;
  private float mDownX;
  private float mDownY;
  private int mMaxFlingVelocity;
  private int mMinFlingVelocity;
  private int mSlop;
  private boolean mSwiping;
  private int mSwipingSlop;
  private Object mToken;
  private float mTranslationX;
  private VelocityTracker mVelocityTracker;
  private View mView;
  private int mViewWidth = 1;
  
  public SwipeDismissTouchListener(View paramView, Object paramObject, DismissCallbacks paramDismissCallbacks)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramView.getContext());
    mSlop = localViewConfiguration.getScaledTouchSlop();
    mMinFlingVelocity = (localViewConfiguration.getScaledMinimumFlingVelocity() * 16);
    mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    mAnimationTime = paramView.getContext().getResources().getInteger(17694720);
    mView = paramView;
    mToken = paramObject;
    mCallbacks = paramDismissCallbacks;
  }
  
  @TargetApi(12)
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.offsetLocation(mTranslationX, 0.0F);
    if (mViewWidth < 2) {
      mViewWidth = mView.getWidth();
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    label218:
    label242:
    label390:
    label399:
    label409:
    label433:
    label439:
    label445:
    label451:
    label461:
    do
    {
      for (;;)
      {
        return false;
        mDownX = paramMotionEvent.getRawX();
        mDownY = paramMotionEvent.getRawY();
        if (mCallbacks.canDismiss(mToken))
        {
          mVelocityTracker = VelocityTracker.obtain();
          mVelocityTracker.addMovement(paramMotionEvent);
        }
        return false;
        if (mVelocityTracker != null)
        {
          f1 = paramMotionEvent.getRawX() - mDownX;
          mVelocityTracker.addMovement(paramMotionEvent);
          mVelocityTracker.computeCurrentVelocity(1000);
          f2 = mVelocityTracker.getXVelocity();
          f3 = Math.abs(f2);
          float f4 = Math.abs(mVelocityTracker.getYVelocity());
          int k = 0;
          int m = 0;
          int j;
          if ((Math.abs(f1) > mViewWidth / 2) && (mSwiping))
          {
            j = 1;
            if (f1 > 0.0F)
            {
              i = 1;
              if (j == 0) {
                break label461;
              }
              paramView = mView.animate();
              if (i == 0) {
                break label451;
              }
              f1 = mViewWidth;
              paramView.translationX(f1).alpha(0.0F).setDuration(mAnimationTime).setListener(new AnimatorListenerAdapter()
              {
                public void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  performDismiss();
                }
              });
            }
          }
          for (;;)
          {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
            mTranslationX = 0.0F;
            mDownX = 0.0F;
            mDownY = 0.0F;
            mSwiping = false;
            break;
            i = 0;
            break label218;
            j = k;
            i = m;
            if (mMinFlingVelocity > f3) {
              break label218;
            }
            j = k;
            i = m;
            if (f3 > mMaxFlingVelocity) {
              break label218;
            }
            j = k;
            i = m;
            if (f4 >= f3) {
              break label218;
            }
            j = k;
            i = m;
            if (!mSwiping) {
              break label218;
            }
            if (f2 < 0.0F)
            {
              i = 1;
              if (f1 >= 0.0F) {
                break label433;
              }
              j = 1;
              if (i != j) {
                break label439;
              }
              j = 1;
              if (mVelocityTracker.getXVelocity() <= 0.0F) {
                break label445;
              }
            }
            for (i = 1;; i = 0)
            {
              break;
              i = 0;
              break label390;
              j = 0;
              break label399;
              j = 0;
              break label409;
            }
            f1 = -mViewWidth;
            break label242;
            if (mSwiping) {
              mView.animate().translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
            }
          }
          if (mVelocityTracker != null)
          {
            mView.animate().translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
            mVelocityTracker.recycle();
            mVelocityTracker = null;
            mTranslationX = 0.0F;
            mDownX = 0.0F;
            mDownY = 0.0F;
            mSwiping = false;
          }
        }
      }
    } while (mVelocityTracker == null);
    mVelocityTracker.addMovement(paramMotionEvent);
    float f1 = paramMotionEvent.getRawX() - mDownX;
    float f2 = paramMotionEvent.getRawY();
    float f3 = mDownY;
    if ((Math.abs(f1) > mSlop) && (Math.abs(f2 - f3) < Math.abs(f1) / 2.0F))
    {
      mSwiping = true;
      if (f1 <= 0.0F) {
        break label730;
      }
    }
    label730:
    for (int i = mSlop;; i = -mSlop)
    {
      mSwipingSlop = i;
      mView.getParent().requestDisallowInterceptTouchEvent(true);
      paramView = MotionEvent.obtain(paramMotionEvent);
      paramView.setAction(paramMotionEvent.getActionIndex() << 8 | 0x3);
      mView.onTouchEvent(paramView);
      paramView.recycle();
      if (!mSwiping) {
        break;
      }
      mTranslationX = f1;
      mView.setTranslationX(f1 - mSwipingSlop);
      return true;
    }
  }
  
  @TargetApi(12)
  public void performDismiss()
  {
    final ViewGroup.LayoutParams localLayoutParams = mView.getLayoutParams();
    final int i = mView.getHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, 1 }).setDuration(mAnimationTime);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mCallbacks.onDismiss(mView, mToken);
        mView.setAlpha(1.0F);
        mView.setTranslationX(0.0F);
        localLayoutParamsheight = i;
        mView.setLayoutParams(localLayoutParams);
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        localLayoutParamsheight = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        mView.setLayoutParams(localLayoutParams);
      }
    });
    localValueAnimator.start();
  }
  
  public static abstract interface DismissCallbacks
  {
    public abstract boolean canDismiss(Object paramObject);
    
    public abstract void onDismiss(View paramView, Object paramObject);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.SwipeDismissTouchListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */