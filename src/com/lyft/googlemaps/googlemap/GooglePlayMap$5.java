package com.lyft.googlemaps.googlemap;

import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.lyft.googlemaps.core.callback.Callback0;

class GooglePlayMap$5
  implements GoogleMap.CancelableCallback
{
  GooglePlayMap$5(GooglePlayMap paramGooglePlayMap, Callback0 paramCallback0) {}
  
  public void onCancel()
  {
    val$onAnimationFinishCallback.call();
  }
  
  public void onFinish()
  {
    val$onAnimationFinishCallback.call();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */