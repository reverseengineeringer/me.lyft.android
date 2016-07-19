package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

class ViewCompat$BaseViewCompatImpl
  implements ViewCompat.ViewCompatImpl
{
  WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;
  
  private boolean canScrollingViewScrollHorizontally(ScrollingView paramScrollingView, int paramInt)
  {
    boolean bool = true;
    int i = paramScrollingView.computeHorizontalScrollOffset();
    int j = paramScrollingView.computeHorizontalScrollRange() - paramScrollingView.computeHorizontalScrollExtent();
    if (j == 0) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (paramInt >= 0) {
          break;
        }
      } while (i > 0);
      return false;
    } while (i < j - 1);
    return false;
  }
  
  private boolean canScrollingViewScrollVertically(ScrollingView paramScrollingView, int paramInt)
  {
    boolean bool = true;
    int i = paramScrollingView.computeVerticalScrollOffset();
    int j = paramScrollingView.computeVerticalScrollRange() - paramScrollingView.computeVerticalScrollExtent();
    if (j == 0) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (paramInt >= 0) {
          break;
        }
      } while (i > 0);
      return false;
    } while (i < j - 1);
    return false;
  }
  
  public ViewPropertyAnimatorCompat animate(View paramView)
  {
    return new ViewPropertyAnimatorCompat(paramView);
  }
  
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return ((paramView instanceof ScrollingView)) && (canScrollingViewScrollHorizontally((ScrollingView)paramView, paramInt));
  }
  
  public boolean canScrollVertically(View paramView, int paramInt)
  {
    return ((paramView instanceof ScrollingView)) && (canScrollingViewScrollVertically((ScrollingView)paramView, paramInt));
  }
  
  public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return paramWindowInsetsCompat;
  }
  
  public float getAlpha(View paramView)
  {
    return 1.0F;
  }
  
  public float getElevation(View paramView)
  {
    return 0.0F;
  }
  
  public boolean getFitsSystemWindows(View paramView)
  {
    return false;
  }
  
  long getFrameTime()
  {
    return 10L;
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return 0;
  }
  
  public int getLayerType(View paramView)
  {
    return 0;
  }
  
  public int getLayoutDirection(View paramView)
  {
    return 0;
  }
  
  public int getMinimumHeight(View paramView)
  {
    return ViewCompatBase.getMinimumHeight(paramView);
  }
  
  public int getMinimumWidth(View paramView)
  {
    return ViewCompatBase.getMinimumWidth(paramView);
  }
  
  public int getOverScrollMode(View paramView)
  {
    return 2;
  }
  
  public int getPaddingEnd(View paramView)
  {
    return paramView.getPaddingRight();
  }
  
  public int getPaddingStart(View paramView)
  {
    return paramView.getPaddingLeft();
  }
  
  public ViewParent getParentForAccessibility(View paramView)
  {
    return paramView.getParent();
  }
  
  public float getScaleX(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationX(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationY(View paramView)
  {
    return 0.0F;
  }
  
  public boolean hasAccessibilityDelegate(View paramView)
  {
    return false;
  }
  
  public boolean hasOverlappingRendering(View paramView)
  {
    return true;
  }
  
  public boolean hasTransientState(View paramView)
  {
    return false;
  }
  
  public boolean isNestedScrollingEnabled(View paramView)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    ViewCompatBase.offsetLeftAndRight(paramView, paramInt);
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    ViewCompatBase.offsetTopAndBottom(paramView, paramInt);
  }
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return paramWindowInsetsCompat;
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    paramView.invalidate();
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, getFrameTime());
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postDelayed(paramRunnable, getFrameTime() + paramLong);
  }
  
  public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
  
  public void setAlpha(View paramView, float paramFloat) {}
  
  public void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void setElevation(View paramView, float paramFloat) {}
  
  public void setImportantForAccessibility(View paramView, int paramInt) {}
  
  public void setLayerType(View paramView, int paramInt, Paint paramPaint) {}
  
  public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  public void setOverScrollMode(View paramView, int paramInt) {}
  
  public void setSaveFromParentEnabled(View paramView, boolean paramBoolean) {}
  
  public void setScaleX(View paramView, float paramFloat) {}
  
  public void setScaleY(View paramView, float paramFloat) {}
  
  public void setTranslationX(View paramView, float paramFloat) {}
  
  public void setTranslationY(View paramView, float paramFloat) {}
  
  public void stopNestedScroll(View paramView)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      ((NestedScrollingChild)paramView).stopNestedScroll();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.BaseViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */