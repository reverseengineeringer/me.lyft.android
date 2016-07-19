package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

abstract interface ViewCompat$ViewCompatImpl
{
  public abstract ViewPropertyAnimatorCompat animate(View paramView);
  
  public abstract boolean canScrollHorizontally(View paramView, int paramInt);
  
  public abstract boolean canScrollVertically(View paramView, int paramInt);
  
  public abstract WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat);
  
  public abstract float getAlpha(View paramView);
  
  public abstract float getElevation(View paramView);
  
  public abstract boolean getFitsSystemWindows(View paramView);
  
  public abstract int getImportantForAccessibility(View paramView);
  
  public abstract int getLayerType(View paramView);
  
  public abstract int getLayoutDirection(View paramView);
  
  public abstract int getMinimumHeight(View paramView);
  
  public abstract int getMinimumWidth(View paramView);
  
  public abstract int getOverScrollMode(View paramView);
  
  public abstract int getPaddingEnd(View paramView);
  
  public abstract int getPaddingStart(View paramView);
  
  public abstract ViewParent getParentForAccessibility(View paramView);
  
  public abstract float getScaleX(View paramView);
  
  public abstract float getTranslationX(View paramView);
  
  public abstract float getTranslationY(View paramView);
  
  public abstract boolean hasAccessibilityDelegate(View paramView);
  
  public abstract boolean hasOverlappingRendering(View paramView);
  
  public abstract boolean hasTransientState(View paramView);
  
  public abstract boolean isNestedScrollingEnabled(View paramView);
  
  public abstract void offsetLeftAndRight(View paramView, int paramInt);
  
  public abstract void offsetTopAndBottom(View paramView, int paramInt);
  
  public abstract WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat);
  
  public abstract void postInvalidateOnAnimation(View paramView);
  
  public abstract void postOnAnimation(View paramView, Runnable paramRunnable);
  
  public abstract void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong);
  
  public abstract void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat);
  
  public abstract void setAlpha(View paramView, float paramFloat);
  
  public abstract void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean);
  
  public abstract void setElevation(View paramView, float paramFloat);
  
  public abstract void setImportantForAccessibility(View paramView, int paramInt);
  
  public abstract void setLayerType(View paramView, int paramInt, Paint paramPaint);
  
  public abstract void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener);
  
  public abstract void setOverScrollMode(View paramView, int paramInt);
  
  public abstract void setSaveFromParentEnabled(View paramView, boolean paramBoolean);
  
  public abstract void setScaleX(View paramView, float paramFloat);
  
  public abstract void setScaleY(View paramView, float paramFloat);
  
  public abstract void setTranslationX(View paramView, float paramFloat);
  
  public abstract void setTranslationY(View paramView, float paramFloat);
  
  public abstract void stopNestedScroll(View paramView);
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */