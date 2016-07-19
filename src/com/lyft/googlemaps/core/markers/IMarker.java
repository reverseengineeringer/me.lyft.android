package com.lyft.googlemaps.core.markers;

import android.graphics.Bitmap;
import com.lyft.googlemaps.core.common.INullable;

public abstract interface IMarker
  extends INullable
{
  public abstract float getAnchorXOffset();
  
  public abstract float getAnchorYOffset();
  
  public abstract String getClickId();
  
  public abstract Bitmap getIcon();
  
  public abstract void hideInfoWindow();
  
  public abstract boolean isInfoWindowShown();
  
  public abstract void remove();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setIcon(Bitmap paramBitmap);
  
  public abstract void setPosition(double paramDouble1, double paramDouble2);
  
  public abstract void setRotation(float paramFloat);
  
  public abstract void setText(String paramString);
  
  public abstract void setVisibility(boolean paramBoolean);
  
  public abstract void showInfoWindow();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.markers.IMarker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */