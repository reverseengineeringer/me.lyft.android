package com.lyft.googlemaps.core.tileoverlay;

public class NullTileOverlay
  implements ITileOverlay
{
  private static final ITileOverlay INSTANCE = new NullTileOverlay();
  
  public static ITileOverlay getInstance()
  {
    return INSTANCE;
  }
  
  public void clearTileCache() {}
  
  public boolean isNull()
  {
    return true;
  }
  
  public void remove() {}
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.tileoverlay.NullTileOverlay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */