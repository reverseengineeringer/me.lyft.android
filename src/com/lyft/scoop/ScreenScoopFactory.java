package com.lyft.scoop;

public class ScreenScoopFactory
{
  protected Scoop addServices(Scoop.Builder paramBuilder, Screen paramScreen, Scoop paramScoop)
  {
    return paramBuilder.build();
  }
  
  public final Scoop createScreenScoop(Screen paramScreen, Scoop paramScoop)
  {
    return addServices(new Scoop.Builder(paramScreen.getClass().getSimpleName(), paramScoop).service("screen", paramScreen), paramScreen, paramScoop);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ScreenScoopFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */