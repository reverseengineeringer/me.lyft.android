package com.lyft.googlemaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;
import com.lyft.googlemaps.core.IMapView;
import com.lyft.googlemaps.core.ITooltipManager;
import com.lyft.googlemaps.core.callback.Callback0;
import com.lyft.googlemaps.core.callback.Callback1;
import com.lyft.googlemaps.core.callback.Callbacks;
import com.lyft.googlemaps.core.camera.IMapBound;
import com.lyft.googlemaps.core.camera.IMapPosition;
import com.lyft.googlemaps.core.camera.MapBound;
import com.lyft.googlemaps.core.camera.MapPosition;
import com.lyft.googlemaps.core.circle.ICircle;
import com.lyft.googlemaps.core.circle.ICircleOptions;
import com.lyft.googlemaps.core.function.Listener;
import com.lyft.googlemaps.core.latlng.MapLatLng;
import com.lyft.googlemaps.core.markers.IMarker;
import com.lyft.googlemaps.core.markers.IMarkerOptions;
import com.lyft.googlemaps.core.polygon.IPolygon;
import com.lyft.googlemaps.core.polygon.IPolygonOptions;
import com.lyft.googlemaps.core.polyline.IPolyline;
import com.lyft.googlemaps.core.polyline.IPolylineOptions;
import com.lyft.googlemaps.core.projection.IProjection;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlay;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlayOptions;
import com.lyft.googlemaps.core.util.MetricsUtils;
import com.lyft.googlemaps.core.util.ViewExtension;
import com.lyft.googlemaps.googlemap.GooglePlayMap;
import com.lyft.googlemaps.googlemap.IMap;
import com.lyft.googlemaps.googlemap.NullMap;
import com.lyft.googlemaps.googlemap.latlng.LocationSourceHook;
import java.util.List;

public class GoogleMapView
  extends MapView
  implements IMapView
{
  private static final int MAP_DRAG_ANIMATION_DELAY = 250;
  private static final double MIN_DISTANCE_CHANGE = 5.0D;
  private static final float MIN_MOVE_DELTA = 7.0F;
  private static final double MIN_PIXEL_CHANGE = 25.0D;
  private static final long TIME_INITIAL = -1L;
  private int bottomPadding;
  private Callback0 cameraPositionChangeCallback = Callbacks.empty();
  private boolean centerMapGestures;
  private final Runnable dragEndRunnable = new Runnable()
  {
    public void run()
    {
      mapDragEndCallback.call();
    }
  };
  private float firstMoveX;
  private float firstMoveY;
  private Callback0 googleMapLoadedCallback = Callbacks.empty();
  private Callback1<GoogleMap> internalMapCallback = Callbacks.empty();
  private boolean isMapDragging;
  private long lastActionUpTime = -1L;
  private LocationSourceHook locationSourceHook;
  private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
  private IMap map = NullMap.getInstance();
  private Callback0 mapDragCallback = Callbacks.empty();
  private Callback0 mapDragEndCallback = Callbacks.empty();
  private MetricsUtils metricsUtils = MetricsUtils.fromView(this);
  private boolean multiTouch;
  private MapLatLng prevCenter;
  private int topPadding;
  
  public GoogleMapView(Context paramContext)
  {
    super(paramContext);
    MapsInitializer.initialize(getContext());
  }
  
  private MotionEvent centerMotionEvent(MotionEvent paramMotionEvent)
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      f2 += paramMotionEvent.getX(i);
      f1 += paramMotionEvent.getY(i);
      i += 1;
    }
    f2 /= paramMotionEvent.getPointerCount();
    f1 /= paramMotionEvent.getPointerCount();
    paramMotionEvent.offsetLocation(getWidth() / 2.0F - f2, (getHeight() + topPadding - bottomPadding) / 2.0F - f1);
    return paramMotionEvent;
  }
  
  private double distanceBetween(Point paramPoint1, Point paramPoint2)
  {
    double d1 = x - x;
    double d2 = y - y;
    return Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  private void interceptMapTouch(MotionEvent paramMotionEvent)
  {
    float f1 = metricsUtils.pixelsToDp(paramMotionEvent.getX());
    float f2 = metricsUtils.pixelsToDp(paramMotionEvent.getY());
    switch (paramMotionEvent.getAction())
    {
    }
    Object localObject;
    Point localPoint;
    double d;
    do
    {
      do
      {
        return;
        firstMoveX = f1;
        firstMoveY = f2;
        prevCenter = map.getMapPosition().getLocation();
        return;
      } while ((Math.abs(firstMoveX - f1) <= 7.0F) && (Math.abs(firstMoveY - f2) <= 7.0F));
      if (!isMapDragging) {
        mainThreadHandler.removeCallbacks(dragEndRunnable);
      }
      mapDragCallback.call();
      isMapDragging = true;
      return;
      isMapDragging = false;
      paramMotionEvent = map.getMapPosition().getLocation();
      localObject = map.getProjection();
      localPoint = ((IProjection)localObject).toScreenLocation(paramMotionEvent);
      localObject = ((IProjection)localObject).toScreenLocation(prevCenter);
      d = SphericalUtil.computeDistanceBetween(new LatLng(paramMotionEvent.getLat(), paramMotionEvent.getLng()), new LatLng(prevCenter.getLat(), prevCenter.getLng()));
    } while ((distanceBetween(localPoint, (Point)localObject) <= 25.0D) && (d <= 5.0D));
    prevCenter = paramMotionEvent;
    queueMapMoveEnded();
  }
  
  private void queueMapMoveEnded()
  {
    mainThreadHandler.removeCallbacks(dragEndRunnable);
    mainThreadHandler.postDelayed(dragEndRunnable, 250L);
  }
  
  private boolean resolveDispactTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getPointerCount() > 1)
    {
      multiTouch = true;
      bool = super.dispatchTouchEvent(centerMotionEvent(paramMotionEvent));
    }
    do
    {
      return bool;
      if (paramMotionEvent.getAction() == 1)
      {
        multiTouch = false;
        Long localLong = Long.valueOf(lastActionUpTime);
        lastActionUpTime = System.currentTimeMillis();
        if ((localLong.longValue() != -1L) && (lastActionUpTime - localLong.longValue() < ViewConfiguration.getDoubleTapTimeout())) {
          return super.dispatchTouchEvent(centerMotionEvent(paramMotionEvent));
        }
        return super.dispatchTouchEvent(paramMotionEvent);
      }
    } while (multiTouch);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public ICircle addCircle(ICircleOptions paramICircleOptions)
  {
    return map.addCircle(paramICircleOptions);
  }
  
  public IMarker addMarker(IMarkerOptions paramIMarkerOptions)
  {
    return map.addMarker(paramIMarkerOptions);
  }
  
  public IPolygon addPolygon(IPolygonOptions paramIPolygonOptions)
  {
    return map.addPolygon(paramIPolygonOptions);
  }
  
  public IPolyline addPolyline(IPolylineOptions paramIPolylineOptions)
  {
    return map.addPolyline(paramIPolylineOptions);
  }
  
  public ITileOverlay addTileOverlay(ITileOverlayOptions paramITileOverlayOptions)
  {
    return map.addTileOverlay(paramITileOverlayOptions);
  }
  
  public void animateCamera(IMapBound paramIMapBound, Callback0 paramCallback0)
  {
    map.animateCamera(paramIMapBound, paramCallback0);
  }
  
  public void animateCamera(IMapPosition paramIMapPosition, Callback0 paramCallback0)
  {
    map.animateCamera(paramIMapPosition, paramCallback0);
  }
  
  public void animateToBounds(final List<? extends MapLatLng> paramList, final int paramInt1, final int paramInt2, final Callback0 paramCallback0)
  {
    ViewExtension.onViewLoaded(this, new Callback0()
    {
      public void call()
      {
        int i = getMeasuredWidth();
        int j = paramInt1;
        int k = getMeasuredHeight();
        int m = paramInt2;
        MapBound localMapBound = new MapBound(paramList, i - j, k - m, 0);
        animateCamera(localMapBound, paramCallback0);
      }
    });
  }
  
  public void applyPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    topPadding = paramInt2;
    bottomPadding = paramInt4;
    map.applyPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void clear()
  {
    map.clear();
  }
  
  public void clearPadding()
  {
    map.clearPadding();
  }
  
  public void create(Bundle paramBundle)
  {
    onCreate(paramBundle);
    getMapAsync(new OnMapReadyCallback()
    {
      public void onMapReady(GoogleMap paramAnonymousGoogleMap)
      {
        GoogleMapView.access$102(GoogleMapView.this, new GooglePlayMap(paramAnonymousGoogleMap));
        if (locationSourceHook != null) {
          map.setLocationSource(locationSourceHook);
        }
        map.setOnCameraChangeCallback(new Callback0()
        {
          public void call()
          {
            cameraPositionChangeCallback.call();
          }
        });
        internalMapCallback.call(paramAnonymousGoogleMap);
        GoogleMapView.access$402(GoogleMapView.this, Callbacks.empty());
        googleMapLoadedCallback.call();
      }
    });
  }
  
  public void destroy()
  {
    onDestroy();
    mainThreadHandler.removeCallbacksAndMessages(null);
    map = NullMap.getInstance();
  }
  
  public void disableTraffic()
  {
    map.disableTraffic();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!centerMapGestures) {}
    for (boolean bool = super.dispatchTouchEvent(paramMotionEvent);; bool = resolveDispactTouchEvent(paramMotionEvent))
    {
      interceptMapTouch(paramMotionEvent);
      return bool;
    }
  }
  
  public void displayLocation()
  {
    map.displayLocation();
  }
  
  public void enableTraffic()
  {
    map.enableTraffic();
  }
  
  public IMapPosition getMapPosition()
  {
    return map.getMapPosition();
  }
  
  public IProjection getProjection()
  {
    return map.getProjection();
  }
  
  public void hideLocation()
  {
    map.hideLocation();
  }
  
  public void lowMemory()
  {
    onLowMemory();
  }
  
  public void moveCamera(MapPosition paramMapPosition)
  {
    map.moveCamera(paramMapPosition);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    mainThreadHandler.removeCallbacksAndMessages(null);
  }
  
  public void pause()
  {
    onPause();
  }
  
  public void resume()
  {
    onResume();
  }
  
  public void setCenterMapGestures(boolean paramBoolean)
  {
    centerMapGestures = paramBoolean;
  }
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    map.setCompassEnabled(paramBoolean);
  }
  
  public void setGesturesEnabled(Boolean paramBoolean)
  {
    map.setGesturesEnabled(paramBoolean);
  }
  
  public void setGoogleMapLoadedCallback(Callback0 paramCallback0)
  {
    googleMapLoadedCallback = paramCallback0;
    if (!map.isNull()) {
      googleMapLoadedCallback.call();
    }
  }
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    map.setIndoorLevelPickerEnabled(paramBoolean);
  }
  
  public void setLocationSource(LocationSourceHook paramLocationSourceHook)
  {
    locationSourceHook = paramLocationSourceHook;
    map.setLocationSource(paramLocationSourceHook);
  }
  
  public void setMapDragCallback(Callback0 paramCallback0)
  {
    mapDragCallback = paramCallback0;
  }
  
  public void setMapDragEndCallback(Callback0 paramCallback0)
  {
    mapDragEndCallback = paramCallback0;
  }
  
  public void setMapToolbarEnabled(boolean paramBoolean)
  {
    map.setMapToolbarEnabled(paramBoolean);
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    map.setMyLocationButtonEnabled(paramBoolean);
  }
  
  public void setMyLocationEnabled(boolean paramBoolean)
  {
    map.setMyLocationEnabled(paramBoolean);
  }
  
  public void setOnCameraChangeCallback(Callback0 paramCallback0)
  {
    map.setOnCameraChangeCallback(paramCallback0);
  }
  
  public void setOnMarkerClickListener(Listener<String, Boolean> paramListener)
  {
    map.setOnMarkerClickListener(paramListener);
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    map.setRotateGesturesEnabled(paramBoolean);
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    map.setTiltGesturesEnabled(paramBoolean);
  }
  
  public void setTooltipManager(ITooltipManager paramITooltipManager)
  {
    map.setTooltipManager(paramITooltipManager);
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean)
  {
    map.setZoomControlsEnabled(paramBoolean);
  }
  
  public void snapshot(Callback1<Bitmap> paramCallback1)
  {
    map.snapshot(paramCallback1);
  }
  
  public void stopAnimation()
  {
    map.stopAnimation();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.GoogleMapView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */