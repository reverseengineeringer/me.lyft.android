package com.lyft.googlemaps;

import com.lyft.googlemaps.core.callback.Callback0;
import com.lyft.googlemaps.core.camera.MapBound;
import java.util.List;

class GoogleMapView$3
  implements Callback0
{
  GoogleMapView$3(GoogleMapView paramGoogleMapView, int paramInt1, int paramInt2, List paramList, Callback0 paramCallback0) {}
  
  public void call()
  {
    int i = this$0.getMeasuredWidth();
    int j = val$widthPadding;
    int k = this$0.getMeasuredHeight();
    int m = val$heightPadding;
    MapBound localMapBound = new MapBound(val$locations, i - j, k - m, 0);
    this$0.animateCamera(localMapBound, val$onAnimationFinishCallback);
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.GoogleMapView.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */