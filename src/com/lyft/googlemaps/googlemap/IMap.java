package com.lyft.googlemaps.googlemap;

import android.graphics.Bitmap;
import com.lyft.googlemaps.core.ITooltipManager;
import com.lyft.googlemaps.core.callback.Callback0;
import com.lyft.googlemaps.core.callback.Callback1;
import com.lyft.googlemaps.core.camera.IMapBound;
import com.lyft.googlemaps.core.camera.IMapPosition;
import com.lyft.googlemaps.core.camera.MapPosition;
import com.lyft.googlemaps.core.circle.ICircle;
import com.lyft.googlemaps.core.circle.ICircleOptions;
import com.lyft.googlemaps.core.common.INullable;
import com.lyft.googlemaps.core.function.Listener;
import com.lyft.googlemaps.core.markers.IMarker;
import com.lyft.googlemaps.core.markers.IMarkerOptions;
import com.lyft.googlemaps.core.polygon.IPolygon;
import com.lyft.googlemaps.core.polygon.IPolygonOptions;
import com.lyft.googlemaps.core.polyline.IPolyline;
import com.lyft.googlemaps.core.polyline.IPolylineOptions;
import com.lyft.googlemaps.core.projection.IProjection;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlay;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlayOptions;
import com.lyft.googlemaps.googlemap.latlng.LocationSourceHook;

public abstract interface IMap
  extends INullable
{
  public abstract ICircle addCircle(ICircleOptions paramICircleOptions);
  
  public abstract IMarker addMarker(IMarkerOptions paramIMarkerOptions);
  
  public abstract IPolygon addPolygon(IPolygonOptions paramIPolygonOptions);
  
  public abstract IPolyline addPolyline(IPolylineOptions paramIPolylineOptions);
  
  public abstract ITileOverlay addTileOverlay(ITileOverlayOptions paramITileOverlayOptions);
  
  public abstract void animateCamera(IMapBound paramIMapBound, Callback0 paramCallback0);
  
  public abstract void animateCamera(IMapPosition paramIMapPosition, Callback0 paramCallback0);
  
  public abstract void applyPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void clear();
  
  public abstract void clearPadding();
  
  public abstract void disableTraffic();
  
  public abstract void displayLocation();
  
  public abstract void enableTraffic();
  
  public abstract IMapPosition getMapPosition();
  
  public abstract IProjection getProjection();
  
  public abstract void hideLocation();
  
  public abstract void moveCamera(MapPosition paramMapPosition);
  
  public abstract void setCompassEnabled(boolean paramBoolean);
  
  public abstract void setGesturesEnabled(Boolean paramBoolean);
  
  public abstract void setIndoorLevelPickerEnabled(boolean paramBoolean);
  
  public abstract void setLocationSource(LocationSourceHook paramLocationSourceHook);
  
  public abstract void setMapToolbarEnabled(boolean paramBoolean);
  
  public abstract void setMyLocationButtonEnabled(boolean paramBoolean);
  
  public abstract void setMyLocationEnabled(boolean paramBoolean);
  
  public abstract void setOnCameraChangeCallback(Callback0 paramCallback0);
  
  public abstract void setOnMarkerClickListener(Listener<String, Boolean> paramListener);
  
  public abstract void setRotateGesturesEnabled(boolean paramBoolean);
  
  public abstract void setTiltGesturesEnabled(boolean paramBoolean);
  
  public abstract void setTooltipManager(ITooltipManager paramITooltipManager);
  
  public abstract void setZoomControlsEnabled(boolean paramBoolean);
  
  public abstract void snapshot(Callback1<Bitmap> paramCallback1);
  
  public abstract void stopAnimation();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.IMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */