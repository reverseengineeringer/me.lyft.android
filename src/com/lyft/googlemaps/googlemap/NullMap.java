package com.lyft.googlemaps.googlemap;

import android.graphics.Bitmap;
import com.lyft.googlemaps.core.ITooltipManager;
import com.lyft.googlemaps.core.callback.Callback0;
import com.lyft.googlemaps.core.callback.Callback1;
import com.lyft.googlemaps.core.camera.IMapBound;
import com.lyft.googlemaps.core.camera.IMapPosition;
import com.lyft.googlemaps.core.camera.MapPosition;
import com.lyft.googlemaps.core.camera.NullMapPosition;
import com.lyft.googlemaps.core.circle.ICircle;
import com.lyft.googlemaps.core.circle.ICircleOptions;
import com.lyft.googlemaps.core.circle.NullCircle;
import com.lyft.googlemaps.core.function.Listener;
import com.lyft.googlemaps.core.markers.IMarker;
import com.lyft.googlemaps.core.markers.IMarkerOptions;
import com.lyft.googlemaps.core.markers.NullMarker;
import com.lyft.googlemaps.core.polygon.IPolygon;
import com.lyft.googlemaps.core.polygon.IPolygonOptions;
import com.lyft.googlemaps.core.polygon.NullPolygon;
import com.lyft.googlemaps.core.polyline.IPolyline;
import com.lyft.googlemaps.core.polyline.IPolylineOptions;
import com.lyft.googlemaps.core.polyline.NullPolyline;
import com.lyft.googlemaps.core.projection.IProjection;
import com.lyft.googlemaps.core.projection.NullProjection;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlay;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlayOptions;
import com.lyft.googlemaps.core.tileoverlay.NullTileOverlay;
import com.lyft.googlemaps.googlemap.latlng.LocationSourceHook;

public class NullMap
  implements IMap
{
  private static final IMap INSTANCE = new NullMap();
  
  public static IMap getInstance()
  {
    return INSTANCE;
  }
  
  public ICircle addCircle(ICircleOptions paramICircleOptions)
  {
    return NullCircle.getInstance();
  }
  
  public IMarker addMarker(IMarkerOptions paramIMarkerOptions)
  {
    return NullMarker.getInstance();
  }
  
  public IPolygon addPolygon(IPolygonOptions paramIPolygonOptions)
  {
    return NullPolygon.getInstance();
  }
  
  public IPolyline addPolyline(IPolylineOptions paramIPolylineOptions)
  {
    return NullPolyline.getInstance();
  }
  
  public ITileOverlay addTileOverlay(ITileOverlayOptions paramITileOverlayOptions)
  {
    return NullTileOverlay.getInstance();
  }
  
  public void animateCamera(IMapBound paramIMapBound, Callback0 paramCallback0) {}
  
  public void animateCamera(IMapPosition paramIMapPosition, Callback0 paramCallback0) {}
  
  public void applyPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void clear() {}
  
  public void clearPadding() {}
  
  public void disableTraffic() {}
  
  public void displayLocation() {}
  
  public void enableTraffic() {}
  
  public IMapPosition getMapPosition()
  {
    return NullMapPosition.getInstance();
  }
  
  public IProjection getProjection()
  {
    return NullProjection.getInstance();
  }
  
  public void hideLocation() {}
  
  public boolean isNull()
  {
    return true;
  }
  
  public void moveCamera(MapPosition paramMapPosition) {}
  
  public void setCompassEnabled(boolean paramBoolean) {}
  
  public void setGesturesEnabled(Boolean paramBoolean) {}
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean) {}
  
  public void setLocationSource(LocationSourceHook paramLocationSourceHook) {}
  
  public void setMapToolbarEnabled(boolean paramBoolean) {}
  
  public void setMyLocationButtonEnabled(boolean paramBoolean) {}
  
  public void setMyLocationEnabled(boolean paramBoolean) {}
  
  public void setOnCameraChangeCallback(Callback0 paramCallback0) {}
  
  public void setOnMarkerClickListener(Listener<String, Boolean> paramListener) {}
  
  public void setRotateGesturesEnabled(boolean paramBoolean) {}
  
  public void setTiltGesturesEnabled(boolean paramBoolean) {}
  
  public void setTooltipManager(ITooltipManager paramITooltipManager) {}
  
  public void setZoomControlsEnabled(boolean paramBoolean) {}
  
  public void snapshot(Callback1<Bitmap> paramCallback1) {}
  
  public void stopAnimation() {}
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.NullMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */