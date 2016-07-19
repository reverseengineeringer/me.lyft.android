package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private LatLngBounds agp;
  private float aif;
  private float aim;
  private boolean ain = true;
  private boolean aio = false;
  private BitmapDescriptor aiq;
  private LatLng air;
  private float ais;
  private float ait;
  private float aiu = 0.0F;
  private float aiv = 0.5F;
  private float aiw = 0.5F;
  private final int mVersionCode;
  
  public GroundOverlayOptions()
  {
    mVersionCode = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean1, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    aiq = new BitmapDescriptor(zzd.zza.zzfc(paramIBinder));
    air = paramLatLng;
    ais = paramFloat1;
    ait = paramFloat2;
    agp = paramLatLngBounds;
    aif = paramFloat3;
    aim = paramFloat4;
    ain = paramBoolean1;
    aiu = paramFloat5;
    aiv = paramFloat6;
    aiw = paramFloat7;
    aio = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return aiv;
  }
  
  public float getAnchorV()
  {
    return aiw;
  }
  
  public float getBearing()
  {
    return aif;
  }
  
  public LatLngBounds getBounds()
  {
    return agp;
  }
  
  public float getHeight()
  {
    return ait;
  }
  
  public LatLng getLocation()
  {
    return air;
  }
  
  public float getTransparency()
  {
    return aiu;
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
  
  public boolean isVisible()
  {
    return ain;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzbqg()
  {
    return aiq.zzbpg().asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.GroundOverlayOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */