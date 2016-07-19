package com.lyft.scoop;

import java.util.List;

public class RouteChange
{
  public final TransitionDirection direction;
  public final List<Screen> fromPath;
  public final List<Screen> toPath;
  
  public RouteChange(List<Screen> paramList1, List<Screen> paramList2, TransitionDirection paramTransitionDirection)
  {
    fromPath = paramList1;
    toPath = paramList2;
    direction = paramTransitionDirection;
  }
  
  private Screen getScreenFromPath(List<Screen> paramList)
  {
    Screen localScreen = null;
    if (!paramList.isEmpty()) {
      localScreen = (Screen)paramList.get(paramList.size() - 1);
    }
    return localScreen;
  }
  
  private Screen nextScreen()
  {
    return getScreenFromPath(toPath);
  }
  
  private Screen previousScreen()
  {
    return getScreenFromPath(fromPath);
  }
  
  public ScreenSwap toScreenSwap()
  {
    return new ScreenSwap(previousScreen(), nextScreen(), direction);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.RouteChange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */