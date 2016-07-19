package com.lyft.scoop;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ScreenBackstack
{
  ArrayDeque<Screen> backStack = new ArrayDeque();
  
  public List<Screen> asList()
  {
    List localList = Arrays.asList((Screen[])backStack.toArray(new Screen[backStack.size()]));
    Collections.reverse(localList);
    return localList;
  }
  
  public void clear()
  {
    while (!backStack.isEmpty()) {
      pop();
    }
  }
  
  public boolean isEmpty()
  {
    return backStack.isEmpty();
  }
  
  public Screen peek()
  {
    return (Screen)backStack.peek();
  }
  
  public void pop()
  {
    Screen localScreen = (Screen)backStack.pop();
  }
  
  public void push(Screen paramScreen)
  {
    backStack.push(paramScreen);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ScreenBackstack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */