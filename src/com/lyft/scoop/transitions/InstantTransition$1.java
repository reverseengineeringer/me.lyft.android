package com.lyft.scoop.transitions;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.lyft.scoop.TransitionListener;

class InstantTransition$1
  implements View.OnAttachStateChangeListener
{
  InstantTransition$1(InstantTransition paramInstantTransition, TransitionListener paramTransitionListener) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    val$transitionListener.onTransitionCompleted();
    paramView.removeOnAttachStateChangeListener(this);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}

/* Location:
 * Qualified Name:     com.lyft.scoop.transitions.InstantTransition.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */