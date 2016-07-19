package com.lyft.scoop;

public class ScreenSwap
{
  public final TransitionDirection direction;
  public final Screen next;
  public final Screen previous;
  
  public ScreenSwap(Screen paramScreen1, Screen paramScreen2, TransitionDirection paramTransitionDirection)
  {
    previous = paramScreen1;
    next = paramScreen2;
    direction = paramTransitionDirection;
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ScreenSwap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */