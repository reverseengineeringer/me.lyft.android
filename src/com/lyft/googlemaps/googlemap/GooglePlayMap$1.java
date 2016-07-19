package com.lyft.googlemaps.googlemap;

import android.graphics.Bitmap;
import com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback;
import com.lyft.googlemaps.core.callback.Callback1;

class GooglePlayMap$1
  implements GoogleMap.SnapshotReadyCallback
{
  GooglePlayMap$1(GooglePlayMap paramGooglePlayMap, Callback1 paramCallback1) {}
  
  public void onSnapshotReady(Bitmap paramBitmap)
  {
    val$snapshotCallback.call(paramBitmap);
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */