package com.google.android.gms.maps.model;

public final class CameraPosition$Builder
{
  private LatLng aic;
  private float aid;
  private float aie;
  private float aif;
  
  public Builder bearing(float paramFloat)
  {
    aif = paramFloat;
    return this;
  }
  
  public CameraPosition build()
  {
    return new CameraPosition(aic, aid, aie, aif);
  }
  
  public Builder target(LatLng paramLatLng)
  {
    aic = paramLatLng;
    return this;
  }
  
  public Builder tilt(float paramFloat)
  {
    aie = paramFloat;
    return this;
  }
  
  public Builder zoom(float paramFloat)
  {
    aid = paramFloat;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.CameraPosition.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */