package com.lyft.googlemaps.googlemap.tileoverlay;

import com.google.android.gms.maps.model.TileOverlay;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlay;

public class GoogleTileOverlay
  implements ITileOverlay
{
  private final TileOverlay tileOverlay;
  
  public GoogleTileOverlay(TileOverlay paramTileOverlay)
  {
    tileOverlay = paramTileOverlay;
  }
  
  public void clearTileCache()
  {
    tileOverlay.clearTileCache();
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public void remove()
  {
    tileOverlay.remove();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.tileoverlay.GoogleTileOverlay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */