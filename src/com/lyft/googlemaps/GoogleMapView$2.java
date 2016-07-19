package com.lyft.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.lyft.googlemaps.core.callback.Callback0;
import com.lyft.googlemaps.core.callback.Callback1;
import com.lyft.googlemaps.core.callback.Callbacks;
import com.lyft.googlemaps.googlemap.GooglePlayMap;
import com.lyft.googlemaps.googlemap.IMap;

class GoogleMapView$2
  implements OnMapReadyCallback
{
  GoogleMapView$2(GoogleMapView paramGoogleMapView) {}
  
  public void onMapReady(GoogleMap paramGoogleMap)
  {
    GoogleMapView.access$102(this$0, new GooglePlayMap(paramGoogleMap));
    if (GoogleMapView.access$200(this$0) != null) {
      GoogleMapView.access$100(this$0).setLocationSource(GoogleMapView.access$200(this$0));
    }
    GoogleMapView.access$100(this$0).setOnCameraChangeCallback(new Callback0()
    {
      public void call()
      {
        GoogleMapView.access$300(this$0).call();
      }
    });
    GoogleMapView.access$400(this$0).call(paramGoogleMap);
    GoogleMapView.access$402(this$0, Callbacks.empty());
    GoogleMapView.access$500(this$0).call();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.GoogleMapView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */