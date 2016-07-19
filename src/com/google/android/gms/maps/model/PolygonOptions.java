package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  private final List<LatLng> aiO;
  private final List<List<LatLng>> aiP;
  private boolean aiQ = false;
  private float aij = 10.0F;
  private int aik = -16777216;
  private int ail = 0;
  private float aim = 0.0F;
  private boolean ain = true;
  private boolean aio = false;
  private final int mVersionCode;
  
  public PolygonOptions()
  {
    mVersionCode = 1;
    aiO = new ArrayList();
    aiP = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    mVersionCode = paramInt1;
    aiO = paramList;
    aiP = paramList1;
    aij = paramFloat1;
    aik = paramInt2;
    ail = paramInt3;
    aim = paramFloat2;
    ain = paramBoolean1;
    aiQ = paramBoolean2;
    aio = paramBoolean3;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      aiO.add(localLatLng);
    }
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    ail = paramInt;
    return this;
  }
  
  public int getFillColor()
  {
    return ail;
  }
  
  public List<LatLng> getPoints()
  {
    return aiO;
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
  
  public boolean isGeodesic()
  {
    return aiQ;
  }
  
  public boolean isVisible()
  {
    return ain;
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    aik = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    aij = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  List zzbqi()
  {
    return aiP;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.PolygonOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */