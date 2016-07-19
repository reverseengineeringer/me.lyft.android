package com.lyft.googlemaps.core;

import android.content.Context;
import android.widget.FrameLayout;

public abstract class IMapTooltipView
  extends FrameLayout
{
  public IMapTooltipView(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void onClick();
  
  public abstract void setText(String paramString);
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.IMapTooltipView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */