package android.support.v4.view;

import android.view.View;

class ViewCompat$LollipopViewCompatImpl
  extends ViewCompat.KitKatViewCompatImpl
{
  public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return ViewCompatLollipop.dispatchApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public float getElevation(View paramView)
  {
    return ViewCompatLollipop.getElevation(paramView);
  }
  
  public boolean isNestedScrollingEnabled(View paramView)
  {
    return ViewCompatLollipop.isNestedScrollingEnabled(paramView);
  }
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    ViewCompatLollipop.offsetLeftAndRight(paramView, paramInt);
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    ViewCompatLollipop.offsetTopAndBottom(paramView, paramInt);
  }
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return ViewCompatLollipop.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public void setElevation(View paramView, float paramFloat)
  {
    ViewCompatLollipop.setElevation(paramView, paramFloat);
  }
  
  public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    ViewCompatLollipop.setOnApplyWindowInsetsListener(paramView, paramOnApplyWindowInsetsListener);
  }
  
  public void stopNestedScroll(View paramView)
  {
    ViewCompatLollipop.stopNestedScroll(paramView);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.LollipopViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */