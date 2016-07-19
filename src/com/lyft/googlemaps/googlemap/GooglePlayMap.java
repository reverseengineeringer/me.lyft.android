package com.lyft.googlemaps.googlemap;

import android.graphics.Bitmap;
import android.location.Location;
import android.view.View;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds.Builder;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.UrlTileProvider;
import com.lyft.googlemaps.core.ITooltipManager;
import com.lyft.googlemaps.core.callback.Callback0;
import com.lyft.googlemaps.core.callback.Callback1;
import com.lyft.googlemaps.core.camera.IMapBound;
import com.lyft.googlemaps.core.camera.IMapPosition;
import com.lyft.googlemaps.core.camera.MapPosition;
import com.lyft.googlemaps.core.circle.ICircle;
import com.lyft.googlemaps.core.circle.ICircleOptions;
import com.lyft.googlemaps.core.function.Listener;
import com.lyft.googlemaps.core.latlng.MapLatLng;
import com.lyft.googlemaps.core.markers.IMarker;
import com.lyft.googlemaps.core.markers.IMarkerOptions;
import com.lyft.googlemaps.core.polygon.ColorOptions;
import com.lyft.googlemaps.core.polygon.IPolygon;
import com.lyft.googlemaps.core.polygon.IPolygonOptions;
import com.lyft.googlemaps.core.polyline.IPolyline;
import com.lyft.googlemaps.core.polyline.IPolylineOptions;
import com.lyft.googlemaps.core.projection.IProjection;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlay;
import com.lyft.googlemaps.core.tileoverlay.ITileOverlayOptions;
import com.lyft.googlemaps.core.tileoverlay.ITileProvider;
import com.lyft.googlemaps.core.util.Objects;
import com.lyft.googlemaps.googlemap.circle.GoogleCircle;
import com.lyft.googlemaps.googlemap.latlng.LocationSourceHook;
import com.lyft.googlemaps.googlemap.marker.GoogleMarker;
import com.lyft.googlemaps.googlemap.polygon.GooglePolygon;
import com.lyft.googlemaps.googlemap.polyline.GooglePolyline;
import com.lyft.googlemaps.googlemap.projection.GoogleMapProjection;
import com.lyft.googlemaps.googlemap.tileoverlay.GoogleTileOverlay;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class GooglePlayMap
  implements IMap
{
  private static final Integer DEFAULT_ANIMATION_SPEED = Integer.valueOf(300);
  private static final CameraPosition NULL_CAMERA_POSITION = new CameraPosition(new LatLng(-1.0D, -1.0D), 0.0F, 0.0F, 0.0F);
  private final GoogleMap googleMap;
  
  public GooglePlayMap(GoogleMap paramGoogleMap)
  {
    googleMap = paramGoogleMap;
  }
  
  private void animateCamera(CameraUpdate paramCameraUpdate, final Callback0 paramCallback0)
  {
    try
    {
      googleMap.animateCamera(paramCameraUpdate, DEFAULT_ANIMATION_SPEED.intValue(), new GoogleMap.CancelableCallback()
      {
        public void onCancel()
        {
          paramCallback0.call();
        }
        
        public void onFinish()
        {
          paramCallback0.call();
        }
      });
      return;
    }
    catch (Throwable paramCameraUpdate)
    {
      paramCallback0.call();
    }
  }
  
  private CameraUpdate getCameraUpdate(IMapPosition paramIMapPosition)
  {
    return CameraUpdateFactory.newCameraPosition(new CameraPosition(LatLngMapper.toLatLng(paramIMapPosition.getLocation()), paramIMapPosition.getZoom(), paramIMapPosition.getTilt(), paramIMapPosition.getBearing()));
  }
  
  public ICircle addCircle(ICircleOptions paramICircleOptions)
  {
    CircleOptions localCircleOptions = new CircleOptions();
    localCircleOptions.center(LatLngMapper.toLatLng(paramICircleOptions.getCenter()));
    localCircleOptions.fillColor(paramICircleOptions.getFillColor());
    localCircleOptions.radius(paramICircleOptions.getRadius());
    localCircleOptions.strokeColor(paramICircleOptions.getStrokeColor());
    localCircleOptions.strokeWidth(paramICircleOptions.getStrokeWidth());
    return new GoogleCircle(googleMap.addCircle(localCircleOptions));
  }
  
  public IMarker addMarker(IMarkerOptions paramIMarkerOptions)
  {
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.rotation(paramIMarkerOptions.getRotation());
    localMarkerOptions.anchor(paramIMarkerOptions.getXOffset(), paramIMarkerOptions.getYOffset());
    localMarkerOptions.icon(BitmapDescriptorFactory.fromBitmap(paramIMarkerOptions.getIcon()));
    localMarkerOptions.position(LatLngMapper.toLatLng(paramIMarkerOptions.getPosition()));
    return new GoogleMarker(googleMap.addMarker(localMarkerOptions), paramIMarkerOptions.getIcon(), paramIMarkerOptions.getXOffset(), paramIMarkerOptions.getYOffset());
  }
  
  public IPolygon addPolygon(IPolygonOptions paramIPolygonOptions)
  {
    PolygonOptions localPolygonOptions = new PolygonOptions();
    localPolygonOptions.addAll(LatLngMapper.toLatLng(paramIPolygonOptions.getLocations()));
    paramIPolygonOptions = paramIPolygonOptions.getColorOptions();
    localPolygonOptions.strokeColor(strokeColor);
    localPolygonOptions.strokeWidth(strokeWidth);
    localPolygonOptions.fillColor(fillColor);
    return new GooglePolygon(googleMap.addPolygon(localPolygonOptions));
  }
  
  public IPolyline addPolyline(IPolylineOptions paramIPolylineOptions)
  {
    PolylineOptions localPolylineOptions = new PolylineOptions();
    Iterator localIterator = paramIPolylineOptions.getLocations().iterator();
    while (localIterator.hasNext()) {
      localPolylineOptions.add(LatLngMapper.toLatLng((MapLatLng)localIterator.next()));
    }
    localPolylineOptions.color(paramIPolylineOptions.getColor());
    localPolylineOptions.width(paramIPolylineOptions.getWidth());
    return new GooglePolyline(googleMap.addPolyline(localPolylineOptions));
  }
  
  public ITileOverlay addTileOverlay(ITileOverlayOptions paramITileOverlayOptions)
  {
    TileOverlayOptions localTileOverlayOptions = new TileOverlayOptions();
    final ITileProvider localITileProvider = paramITileOverlayOptions.getProvider();
    localTileOverlayOptions.tileProvider(new UrlTileProvider(localITileProvider.getWidth(), localITileProvider.getHeight())
    {
      public URL getTileUrl(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        return localITileProvider.getTileUrl(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
      }
    });
    localTileOverlayOptions.zIndex(paramITileOverlayOptions.getZIndex());
    localTileOverlayOptions.fadeIn(paramITileOverlayOptions.isFadeIn());
    return new GoogleTileOverlay(googleMap.addTileOverlay(localTileOverlayOptions));
  }
  
  public void animateCamera(IMapBound paramIMapBound, Callback0 paramCallback0)
  {
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    Iterator localIterator = paramIMapBound.getLocationList().iterator();
    while (localIterator.hasNext()) {
      localBuilder.include(LatLngMapper.toLatLng((MapLatLng)localIterator.next()));
    }
    animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramIMapBound.getWidth(), paramIMapBound.getHeight(), paramIMapBound.getPadding()), paramCallback0);
  }
  
  public void animateCamera(IMapPosition paramIMapPosition, Callback0 paramCallback0)
  {
    animateCamera(getCameraUpdate(paramIMapPosition), paramCallback0);
  }
  
  public void applyPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    googleMap.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void clear()
  {
    googleMap.clear();
  }
  
  public void clearPadding()
  {
    googleMap.setPadding(0, 0, 0, 0);
  }
  
  public void disableTraffic()
  {
    googleMap.setTrafficEnabled(false);
  }
  
  public void displayLocation()
  {
    googleMap.setMyLocationEnabled(true);
  }
  
  public void enableTraffic()
  {
    googleMap.setTrafficEnabled(true);
  }
  
  public MapPosition getMapPosition()
  {
    CameraPosition localCameraPosition = (CameraPosition)Objects.firstNonNull(googleMap.getCameraPosition(), NULL_CAMERA_POSITION);
    return new MapPosition(LatLngMapper.toMapLatLng(target), zoom, tilt, bearing);
  }
  
  public IProjection getProjection()
  {
    return new GoogleMapProjection(googleMap.getProjection());
  }
  
  public void hideLocation()
  {
    googleMap.setMyLocationEnabled(false);
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public void moveCamera(MapPosition paramMapPosition)
  {
    paramMapPosition = getCameraUpdate(paramMapPosition);
    try
    {
      googleMap.moveCamera(paramMapPosition);
      return;
    }
    catch (Throwable paramMapPosition) {}
  }
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    googleMap.getUiSettings().setCompassEnabled(paramBoolean);
  }
  
  public void setGesturesEnabled(Boolean paramBoolean)
  {
    UiSettings localUiSettings = googleMap.getUiSettings();
    localUiSettings.setScrollGesturesEnabled(paramBoolean.booleanValue());
    localUiSettings.setZoomGesturesEnabled(paramBoolean.booleanValue());
  }
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    googleMap.getUiSettings().setIndoorLevelPickerEnabled(paramBoolean);
  }
  
  public void setLocationSource(final LocationSourceHook paramLocationSourceHook)
  {
    googleMap.setLocationSource(new LocationSource()
    {
      public void activate(final LocationSource.OnLocationChangedListener paramAnonymousOnLocationChangedListener)
      {
        paramLocationSourceHook.activate(new Callback1()
        {
          public void call(Location paramAnonymous2Location)
          {
            paramAnonymousOnLocationChangedListener.onLocationChanged(paramAnonymous2Location);
          }
        });
      }
      
      public void deactivate()
      {
        paramLocationSourceHook.deactivate();
      }
    });
  }
  
  public void setMapToolbarEnabled(boolean paramBoolean)
  {
    googleMap.getUiSettings().setMapToolbarEnabled(paramBoolean);
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    googleMap.getUiSettings().setMyLocationButtonEnabled(paramBoolean);
  }
  
  public void setMyLocationEnabled(boolean paramBoolean)
  {
    googleMap.setMyLocationEnabled(paramBoolean);
  }
  
  public void setOnCameraChangeCallback(final Callback0 paramCallback0)
  {
    googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener()
    {
      public void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        paramCallback0.call();
      }
    });
  }
  
  public void setOnMarkerClickListener(final Listener<String, Boolean> paramListener)
  {
    googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        return ((Boolean)paramListener.call(paramAnonymousMarker.getId())).booleanValue();
      }
    });
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    googleMap.getUiSettings().setRotateGesturesEnabled(paramBoolean);
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    googleMap.getUiSettings().setTiltGesturesEnabled(paramBoolean);
  }
  
  public void setTooltipManager(final ITooltipManager paramITooltipManager)
  {
    googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter()
    {
      public View getInfoContents(Marker paramAnonymousMarker)
      {
        return null;
      }
      
      public View getInfoWindow(Marker paramAnonymousMarker)
      {
        return paramITooltipManager.getTooltipView(paramAnonymousMarker.getId(), paramAnonymousMarker.getTitle());
      }
    });
    googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener()
    {
      public void onInfoWindowClick(Marker paramAnonymousMarker)
      {
        paramITooltipManager.handleTooltipClick(paramAnonymousMarker.getId());
      }
    });
    googleMap.setOnInfoWindowCloseListener(new GoogleMap.OnInfoWindowCloseListener()
    {
      public void onInfoWindowClose(Marker paramAnonymousMarker)
      {
        paramITooltipManager.handleTooltipClosed(paramAnonymousMarker.getId());
      }
    });
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean)
  {
    googleMap.getUiSettings().setZoomControlsEnabled(paramBoolean);
  }
  
  public void snapshot(final Callback1<Bitmap> paramCallback1)
  {
    googleMap.snapshot(new GoogleMap.SnapshotReadyCallback()
    {
      public void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        paramCallback1.call(paramAnonymousBitmap);
      }
    });
  }
  
  public void stopAnimation()
  {
    googleMap.stopAnimation();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */