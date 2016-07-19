package com.lyft.googlemaps.googlemap.marker;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.lyft.googlemaps.core.markers.IMarker;

public class GoogleMarker
  implements IMarker
{
  private Bitmap icon;
  protected final Marker marker;
  private float xOffset;
  private float yOffset;
  
  public GoogleMarker(Marker paramMarker, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    marker = paramMarker;
    icon = paramBitmap;
    xOffset = paramFloat1;
    yOffset = paramFloat2;
    paramMarker.setInfoWindowAnchor(0.5F, 0.5F);
  }
  
  public float getAnchorXOffset()
  {
    return xOffset;
  }
  
  public float getAnchorYOffset()
  {
    return yOffset;
  }
  
  public final String getClickId()
  {
    return marker.getId();
  }
  
  public Bitmap getIcon()
  {
    return icon;
  }
  
  public void hideInfoWindow()
  {
    marker.hideInfoWindow();
  }
  
  public boolean isInfoWindowShown()
  {
    return marker.isInfoWindowShown();
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public void remove()
  {
    marker.remove();
  }
  
  public void setAlpha(float paramFloat)
  {
    marker.setAlpha(paramFloat);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    xOffset = paramFloat1;
    yOffset = paramFloat2;
    marker.setAnchor(paramFloat1, paramFloat2);
  }
  
  public void setIcon(Bitmap paramBitmap)
  {
    if (!icon.sameAs(paramBitmap))
    {
      marker.setIcon(BitmapDescriptorFactory.fromBitmap(paramBitmap));
      icon = paramBitmap;
    }
  }
  
  public void setPosition(double paramDouble1, double paramDouble2)
  {
    marker.setPosition(new LatLng(paramDouble1, paramDouble2));
  }
  
  public void setRotation(float paramFloat)
  {
    marker.setRotation(paramFloat);
  }
  
  public void setText(String paramString)
  {
    marker.setTitle(paramString);
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    marker.setVisible(paramBoolean);
  }
  
  public void showInfoWindow()
  {
    marker.showInfoWindow();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.marker.GoogleMarker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */