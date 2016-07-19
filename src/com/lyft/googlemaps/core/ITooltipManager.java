package com.lyft.googlemaps.core;

import android.view.View;

public abstract interface ITooltipManager
{
  public abstract View getTooltipView(String paramString1, String paramString2);
  
  public abstract void handleTooltipClick(String paramString);
  
  public abstract void handleTooltipClosed(String paramString);
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.ITooltipManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */