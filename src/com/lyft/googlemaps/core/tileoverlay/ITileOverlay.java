package com.lyft.googlemaps.core.tileoverlay;

import com.lyft.googlemaps.core.common.INullable;

public abstract interface ITileOverlay
  extends INullable
{
  public abstract void clearTileCache();
  
  public abstract void remove();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.tileoverlay.ITileOverlay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */