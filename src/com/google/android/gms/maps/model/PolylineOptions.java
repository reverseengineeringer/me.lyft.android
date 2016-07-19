package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  private final List<LatLng> aiO;
  private boolean aiQ = false;
  private float aim = 0.0F;
  private boolean ain = true;
  private boolean aio = false;
  private float ais = 10.0F;
  private int mColor = -16777216;
  private final int mVersionCode;
  
  public PolylineOptions()
  {
    mVersionCode = 1;
    aiO = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    mVersionCode = paramInt1;
    aiO = paramList;
    ais = paramFloat1;
    mColor = paramInt2;
    aim = paramFloat2;
    ain = paramBoolean1;
    aiQ = paramBoolean2;
    aio = paramBoolean3;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    aiO.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    mColor = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getColor()
  {
    return mColor;
  }
  
  public List<LatLng> getPoints()
  {
    return aiO;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public float getWidth()
  {
    return ais;
  }
  
  public float getZIndex()
  {
    return aim;
  }
  
  public boolean isClickable()
  {
    return aio;
  }
  
  public boolean isGeodesic()
  {
    return aiQ;
  }
  
  public boolean isVisible()
  {
    return ain;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    ais = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.PolylineOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */