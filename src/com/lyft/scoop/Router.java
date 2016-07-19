package com.lyft.scoop;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Router
{
  private boolean allowEmptyStack;
  private ScreenBackstack backStack = new ScreenBackstack();
  
  public Router()
  {
    allowEmptyStack = false;
  }
  
  public Router(boolean paramBoolean)
  {
    allowEmptyStack = paramBoolean;
  }
  
  private void performRouteChange(List<Screen> paramList1, List<Screen> paramList2, TransitionDirection paramTransitionDirection)
  {
    onRouteChanged(new RouteChange(paramList1, paramList2, paramTransitionDirection));
  }
  
  private boolean tryHandleEmptyBackstack(Screen paramScreen)
  {
    if (backStack.isEmpty())
    {
      backStack.push(paramScreen);
      performRouteChange(Collections.emptyList(), backStack.asList(), TransitionDirection.ENTER);
      return true;
    }
    return false;
  }
  
  public boolean goBack()
  {
    if (!backStack.isEmpty())
    {
      List localList = backStack.asList();
      backStack.pop();
      performRouteChange(localList, backStack.asList(), TransitionDirection.EXIT);
      if ((!backStack.isEmpty()) || (allowEmptyStack)) {
        return true;
      }
    }
    return false;
  }
  
  public void goTo(Screen paramScreen)
  {
    if (tryHandleEmptyBackstack(paramScreen)) {}
    List localList;
    do
    {
      return;
      localList = backStack.asList();
    } while (Screen.equals(backStack.peek(), paramScreen));
    backStack.push(paramScreen);
    performRouteChange(localList, backStack.asList(), TransitionDirection.ENTER);
  }
  
  public boolean hasActiveScreen()
  {
    return !backStack.isEmpty();
  }
  
  protected abstract void onRouteChanged(RouteChange paramRouteChange);
  
  protected Screen peek()
  {
    return backStack.peek();
  }
  
  public void replaceAllWith(List<Screen> paramList)
  {
    List localList = backStack.asList();
    backStack.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Screen localScreen = (Screen)paramList.next();
      backStack.push(localScreen);
    }
    performRouteChange(localList, backStack.asList(), TransitionDirection.ENTER);
  }
  
  public void replaceAllWith(Screen... paramVarArgs)
  {
    replaceAllWith(Arrays.asList(paramVarArgs));
  }
  
  public void replaceWith(Screen paramScreen)
  {
    if (tryHandleEmptyBackstack(paramScreen)) {}
    List localList;
    do
    {
      return;
      localList = backStack.asList();
    } while (Screen.equals(backStack.peek(), paramScreen));
    if (!backStack.isEmpty()) {
      backStack.pop();
    }
    backStack.push(paramScreen);
    performRouteChange(localList, backStack.asList(), TransitionDirection.ENTER);
  }
  
  public void resetTo(Screen paramScreen)
  {
    if (tryHandleEmptyBackstack(paramScreen)) {
      return;
    }
    resetTo(paramScreen, TransitionDirection.EXIT);
  }
  
  public void resetTo(Screen paramScreen, TransitionDirection paramTransitionDirection)
  {
    List localList = backStack.asList();
    if ((!backStack.isEmpty()) && (Screen.equals(paramScreen, backStack.peek()))) {
      return;
    }
    do
    {
      backStack.pop();
      if (backStack.isEmpty()) {
        break;
      }
    } while (!Screen.equals(paramScreen, backStack.peek()));
    performRouteChange(localList, backStack.asList(), paramTransitionDirection);
    return;
    backStack.push(paramScreen);
    performRouteChange(localList, backStack.asList(), paramTransitionDirection);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.Router
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */