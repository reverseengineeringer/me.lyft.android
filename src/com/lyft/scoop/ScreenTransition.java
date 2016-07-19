package com.lyft.scoop;

import android.view.View;
import android.view.ViewGroup;

public abstract interface ScreenTransition
{
  public abstract void transition(ViewGroup paramViewGroup, View paramView1, View paramView2, TransitionListener paramTransitionListener);
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ScreenTransition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */