package com.lyft.scoop.transitions;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.lyft.scoop.ScreenTransition;
import com.lyft.scoop.TransitionListener;

public abstract class ObjectAnimatorTransition
  implements ScreenTransition
{
  private static void waitForMeasure(View paramView, final OnMeasuredCallback paramOnMeasuredCallback)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i > 0) && (j > 0))
    {
      paramOnMeasuredCallback.onMeasured(paramView, i, j);
      return;
    }
    paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        ViewTreeObserver localViewTreeObserver = val$view.getViewTreeObserver();
        if (localViewTreeObserver.isAlive()) {
          localViewTreeObserver.removeOnPreDrawListener(this);
        }
        paramOnMeasuredCallback.onMeasured(val$view, val$view.getWidth(), val$view.getHeight());
        return true;
      }
    });
  }
  
  protected abstract void performTranslate(ViewGroup paramViewGroup, View paramView1, View paramView2, TransitionListener paramTransitionListener);
  
  public void transition(final ViewGroup paramViewGroup, final View paramView1, final View paramView2, final TransitionListener paramTransitionListener)
  {
    if (paramView2 == null)
    {
      performTranslate(paramViewGroup, paramView1, paramView2, paramTransitionListener);
      return;
    }
    paramViewGroup.addView(paramView2);
    waitForMeasure(paramView2, new OnMeasuredCallback()
    {
      public void onMeasured(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        performTranslate(paramViewGroup, paramView1, paramView2, paramTransitionListener);
      }
    });
  }
  
  private static abstract interface OnMeasuredCallback
  {
    public abstract void onMeasured(View paramView, int paramInt1, int paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.transitions.ObjectAnimatorTransition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */