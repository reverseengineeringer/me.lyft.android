package com.lyft.googlemaps.core.tileoverlay;

public abstract interface ITileOverlayOptions
{
  public abstract ITileProvider getProvider();
  
  public abstract float getZIndex();
  
  public abstract boolean isFadeIn();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.tileoverlay.ITileOverlayOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */