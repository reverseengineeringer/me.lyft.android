package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private LatLng aih = null;
  private double aii = 0.0D;
  private float aij = 10.0F;
  private int aik = -16777216;
  private int ail = 0;
  private float aim = 0.0F;
  private boolean ain = true;
  private boolean aio = false;
  private final int mVersionCode;
  
  public CircleOptions()
  {
    mVersionCode = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt1;
    aih = paramLatLng;
    aii = paramDouble;
    aij = paramFloat1;
    aik = paramInt2;
    ail = paramInt3;
    aim = paramFloat2;
    ain = paramBoolean1;
    aio = paramBoolean2;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    aih = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    ail = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return aih;
  }
  
  public int getFillColor()
  {
    return ail;
  }
  
  public double getRadius()
  {
    return aii;
  }
  
  public int getStrokeColor()
  {
    return aik;
  }
  
  public float getStrokeWidth()
  {
    return aij;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public float getZIndex()
  {
    return aim;
  }
  
  public boolean isClickable()
  {
    return aio;
  }
  
  public boolean isVisible()
  {
    return ain;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    aii = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    aik = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    aij = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.CircleOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */