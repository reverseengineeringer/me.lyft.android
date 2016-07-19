package com.lyft.scoop.transitions;

import android.view.View;
import android.view.ViewGroup;
import com.lyft.scoop.TransitionListener;

class ObjectAnimatorTransition$1
  implements ObjectAnimatorTransition.OnMeasuredCallback
{
  ObjectAnimatorTransition$1(ObjectAnimatorTransition paramObjectAnimatorTransition, ViewGroup paramViewGroup, View paramView1, View paramView2, TransitionListener paramTransitionListener) {}
  
  public void onMeasured(View paramView, int paramInt1, int paramInt2)
  {
    this$0.performTranslate(val$root, val$from, val$to, val$transitionListener);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.transitions.ObjectAnimatorTransition.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */