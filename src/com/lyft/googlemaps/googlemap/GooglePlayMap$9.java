package com.lyft.googlemaps.googlemap;

import com.google.android.gms.maps.model.UrlTileProvider;
import com.lyft.googlemaps.core.tileoverlay.ITileProvider;
import java.net.URL;

class GooglePlayMap$9
  extends UrlTileProvider
{
  GooglePlayMap$9(GooglePlayMap paramGooglePlayMap, int paramInt1, int paramInt2, ITileProvider paramITileProvider)
  {
    super(paramInt1, paramInt2);
  }
  
  public URL getTileUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    return val$provider.getTileUrl(paramInt1, paramInt2, paramInt3);
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */