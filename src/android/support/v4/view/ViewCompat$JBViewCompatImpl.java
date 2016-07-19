package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewCompat$JBViewCompatImpl
  extends ViewCompat.ICSMr1ViewCompatImpl
{
  public boolean getFitsSystemWindows(View paramView)
  {
    return ViewCompatJB.getFitsSystemWindows(paramView);
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return ViewCompatJB.getImportantForAccessibility(paramView);
  }
  
  public int getMinimumHeight(View paramView)
  {
    return ViewCompatJB.getMinimumHeight(paramView);
  }
  
  public int getMinimumWidth(View paramView)
  {
    return ViewCompatJB.getMinimumWidth(paramView);
  }
  
  public ViewParent getParentForAccessibility(View paramView)
  {
    return ViewCompatJB.getParentForAccessibility(paramView);
  }
  
  public boolean hasOverlappingRendering(View paramView)
  {
    return ViewCompatJB.hasOverlappingRendering(paramView);
  }
  
  public boolean hasTransientState(View paramView)
  {
    return ViewCompatJB.hasTransientState(paramView);
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    ViewCompatJB.postInvalidateOnAnimation(paramView);
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    ViewCompatJB.postOnAnimation(paramView, paramRunnable);
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    ViewCompatJB.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
  }
  
  public void setImportantForAccessibility(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 4) {
      i = 2;
    }
    ViewCompatJB.setImportantForAccessibility(paramView, i);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.JBViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */