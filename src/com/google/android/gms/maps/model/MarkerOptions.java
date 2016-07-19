package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private String Fx;
  private LatLng ahK;
  private String aiE;
  private BitmapDescriptor aiF;
  private boolean aiG;
  private boolean aiH = false;
  private float aiI = 0.0F;
  private float aiJ = 0.5F;
  private float aiK = 0.0F;
  private float aim;
  private boolean ain = true;
  private float aiv = 0.5F;
  private float aiw = 1.0F;
  private float mAlpha = 1.0F;
  private final int mVersionCode;
  
  public MarkerOptions()
  {
    mVersionCode = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    mVersionCode = paramInt;
    ahK = paramLatLng;
    Fx = paramString1;
    aiE = paramString2;
    if (paramIBinder == null) {}
    for (paramLatLng = null;; paramLatLng = new BitmapDescriptor(zzd.zza.zzfc(paramIBinder)))
    {
      aiF = paramLatLng;
      aiv = paramFloat1;
      aiw = paramFloat2;
      aiG = paramBoolean1;
      ain = paramBoolean2;
      aiH = paramBoolean3;
      aiI = paramFloat3;
      aiJ = paramFloat4;
      aiK = paramFloat5;
      mAlpha = paramFloat6;
      aim = paramFloat7;
      return;
    }
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    aiv = paramFloat1;
    aiw = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAlpha()
  {
    return mAlpha;
  }
  
  public float getAnchorU()
  {
    return aiv;
  }
  
  public float getAnchorV()
  {
    return aiw;
  }
  
  public float getInfoWindowAnchorU()
  {
    return aiJ;
  }
  
  public float getInfoWindowAnchorV()
  {
    return aiK;
  }
  
  public LatLng getPosition()
  {
    return ahK;
  }
  
  public float getRotation()
  {
    return aiI;
  }
  
  public String getSnippet()
  {
    return aiE;
  }
  
  public String getTitle()
  {
    return Fx;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public float getZIndex()
  {
    return aim;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    aiF = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isDraggable()
  {
    return aiG;
  }
  
  public boolean isFlat()
  {
    return aiH;
  }
  
  public boolean isVisible()
  {
    return ain;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }
    ahK = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    aiI = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzbqh()
  {
    if (aiF == null) {
      return null;
    }
    return aiF.zzbpg().asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.MarkerOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */