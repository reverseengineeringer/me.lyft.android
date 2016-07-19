package com.lyft.googlemaps.core.tileoverlay;

import java.net.URL;

public abstract interface ITileProvider
{
  public abstract int getHeight();
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int getWidth();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.tileoverlay.ITileProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */