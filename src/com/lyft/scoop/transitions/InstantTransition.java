package com.lyft.scoop.transitions;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.lyft.scoop.ScreenTransition;
import com.lyft.scoop.TransitionListener;

public class InstantTransition
  implements ScreenTransition
{
  public void transition(ViewGroup paramViewGroup, View paramView1, View paramView2, final TransitionListener paramTransitionListener)
  {
    paramViewGroup.removeView(paramView1);
    if (paramView2 == null)
    {
      paramTransitionListener.onTransitionCompleted();
      return;
    }
    paramView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public void onViewAttachedToWindow(View paramAnonymousView)
      {
        paramTransitionListener.onTransitionCompleted();
        paramAnonymousView.removeOnAttachStateChangeListener(this);
      }
      
      public void onViewDetachedFromWindow(View paramAnonymousView) {}
    });
    paramViewGroup.addView(paramView2);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.transitions.InstantTransition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */