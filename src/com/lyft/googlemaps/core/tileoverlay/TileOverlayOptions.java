package com.lyft.googlemaps.core.tileoverlay;

public class TileOverlayOptions
  implements ITileOverlayOptions
{
  private final boolean isFadeIn;
  private final ITileProvider tileProvider;
  private final float zIndex;
  
  public TileOverlayOptions(ITileProvider paramITileProvider, float paramFloat, boolean paramBoolean)
  {
    tileProvider = paramITileProvider;
    zIndex = paramFloat;
    isFadeIn = paramBoolean;
  }
  
  public ITileProvider getProvider()
  {
    return tileProvider;
  }
  
  public float getZIndex()
  {
    return zIndex;
  }
  
  public boolean isFadeIn()
  {
    return isFadeIn;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.tileoverlay.TileOverlayOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */