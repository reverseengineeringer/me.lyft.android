package com.lyft.googlemaps.core.markers;

import android.graphics.Bitmap;

public class NullMarker
  implements IMarker
{
  private static final IMarker INSTANCE = new NullMarker();
  
  public static IMarker getInstance()
  {
    return INSTANCE;
  }
  
  public float getAnchorXOffset()
  {
    return 0.0F;
  }
  
  public float getAnchorYOffset()
  {
    return 0.0F;
  }
  
  public String getClickId()
  {
    return "";
  }
  
  public Bitmap getIcon()
  {
    return null;
  }
  
  public void hideInfoWindow() {}
  
  public boolean isInfoWindowShown()
  {
    return false;
  }
  
  public boolean isNull()
  {
    return true;
  }
  
  public void remove() {}
  
  public void setAlpha(float paramFloat) {}
  
  public void setAnchor(float paramFloat1, float paramFloat2) {}
  
  public void setIcon(Bitmap paramBitmap) {}
  
  public void setPosition(double paramDouble1, double paramDouble2) {}
  
  public void setRotation(float paramFloat) {}
  
  public void setText(String paramString) {}
  
  public void setVisibility(boolean paramBoolean) {}
  
  public void showInfoWindow() {}
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.markers.NullMarker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */